package com.csrodrigues.gymcontrol.domain.repository;

import com.csrodrigues.gymcontrol.domain.entity.Enrollment;
import com.csrodrigues.gymcontrol.domain.entity.Member;
import com.csrodrigues.gymcontrol.domain.enums.EnrollmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, String> {
    boolean existsByMemberAndStatus(Member member, EnrollmentStatus status);

}
