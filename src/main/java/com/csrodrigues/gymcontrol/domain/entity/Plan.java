package com.csrodrigues.gymcontrol.domain.entity;

import com.csrodrigues.gymcontrol.domain.enums.PlanDuration;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name= "tb_plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PlanDuration duration;
    @Column(nullable = false)
    private boolean active = true;


    public Plan(){}

    public Plan(String name, String description, BigDecimal price, PlanDuration duration) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PlanDuration getDuration() {
        return duration;
    }

    public void setDuration(PlanDuration duration) {
        this.duration = duration;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return Objects.equals(id, plan.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
