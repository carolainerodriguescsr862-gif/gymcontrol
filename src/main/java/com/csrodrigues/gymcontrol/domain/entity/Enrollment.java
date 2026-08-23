package com.csrodrigues.gymcontrol.domain.entity;

import com.csrodrigues.gymcontrol.domain.enums.EnrollmentStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name= "tb_enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(optional = false)
    @JoinColumn(name= "member_id",  nullable = false)
    private Member member;
    @ManyToOne(optional = false)
    @JoinColumn(name= "plan_id",   nullable = false)
    private Plan plan;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnrollmentStatus status;
    @Column(nullable = false)
    private LocalDate startDate;
    @Column(nullable = false)
    private LocalDate endDate;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Enrollment() {}

    public Enrollment(Member member, Plan plan, EnrollmentStatus status,
                      LocalDate startDate) {
        this.member = member;
        this.plan = plan;
        this.status = status;
        this.startDate = (startDate != null) ? startDate : LocalDate.now();
        this.endDate = this.startDate.plusDays(plan.getDuration().getDays());
    }

    @PrePersist
    private void onCreated() {
       this.createdAt = LocalDateTime.now();
       this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdated() {
        this.updatedAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
