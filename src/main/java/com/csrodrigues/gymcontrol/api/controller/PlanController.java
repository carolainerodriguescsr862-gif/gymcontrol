package com.csrodrigues.gymcontrol.api.controller;

import com.csrodrigues.gymcontrol.api.dto.request.PlanRequestDTO;
import com.csrodrigues.gymcontrol.api.dto.response.PlanResponseDTO;
import com.csrodrigues.gymcontrol.domain.service.PlanService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public ResponseEntity<PlanResponseDTO> createPlan(@Valid @RequestBody PlanRequestDTO planRequestDTO) {
        var newPlan = planService.createPlan(planRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlan);
    }

    @GetMapping
    public ResponseEntity<List<PlanResponseDTO>> getAllPlans() {
        return ResponseEntity.ok().body(planService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanResponseDTO> getAllPlansByUser(@PathVariable String id) {
        return ResponseEntity.ok().body(planService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanResponseDTO> updatePlan(@PathVariable String id, @Valid @RequestBody PlanRequestDTO planRequestDTO) {
        var updatePlan = planService.updateById(id, planRequestDTO);
        return ResponseEntity.ok().body(updatePlan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable String id) {
        planService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
