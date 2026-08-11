package com.csrodrigues.gymcontrol.domain.repository;

import com.csrodrigues.gymcontrol.domain.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlanRepository extends JpaRepository<Plan, String> {

    boolean existsByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCaseAndIdNot(String name, String id);

    List<Plan> findAllByActiveTrue();

    Optional<Plan> findByIdAndActiveTrue(String id);
}
