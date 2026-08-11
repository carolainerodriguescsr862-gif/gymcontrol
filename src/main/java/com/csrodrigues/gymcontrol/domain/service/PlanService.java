package com.csrodrigues.gymcontrol.domain.service;

import com.csrodrigues.gymcontrol.api.dto.request.PlanRequestDTO;
import com.csrodrigues.gymcontrol.api.dto.response.PlanResponseDTO;
import com.csrodrigues.gymcontrol.api.mapper.PlanMapper;
import com.csrodrigues.gymcontrol.domain.entity.Plan;
import com.csrodrigues.gymcontrol.domain.exception.BusinessException;
import com.csrodrigues.gymcontrol.domain.exception.ResourceNotFoundException;
import com.csrodrigues.gymcontrol.domain.repository.PlanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanService {


    // TODO: IMPLEMENTAR QUANDO CRIAR O MÓDULO DE MATRÍCULAS
    // Injetar o EnrollmentRepository e validar a integridade antes de desativar:
    // boolean hasActiveEnrollments = enrollmentRepository.existsByPlanIdAndActiveTrue(id);
    // if (hasActiveEnrollments) {
    //     throw new BusinessException("Cannot delete this plan because there are active students enrolled in it!");
    //

    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    private Plan findByIdOrThrow(String id){
        return  planRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plan not found"));
    }

    @Transactional
    public PlanResponseDTO createPlan(PlanRequestDTO planRequestDTO) {
        boolean exists = planRepository.existsByNameIgnoreCase(planRequestDTO.name());

        if(exists){
            throw  new BusinessException("There is already a plan with that name!");
        }
        Plan plan = PlanMapper.toEntity(planRequestDTO);
        Plan saved = planRepository.save(plan);

        return PlanMapper.toDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<PlanResponseDTO> findAll() {
        return planRepository.findAllByActiveTrue()
                .stream()
                .map(PlanMapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public PlanResponseDTO findById(String id) {
        Plan plan = findByIdOrThrow(id);
        return PlanMapper.toDTO(plan);
    }

    @Transactional
    public PlanResponseDTO updateById(String id, PlanRequestDTO planRequestDTO) {
        Plan plan = findByIdOrThrow(id);

            if(!planRequestDTO.name().equals(plan.getName())){
                boolean exists = planRepository.existsByNameIgnoreCaseAndIdNot(planRequestDTO.name(), id);
                if(exists){
                    throw  new BusinessException("There is already a plan with that name!");
                }
            }
            PlanMapper.updateEntityFromDTO(planRequestDTO, plan);
            Plan saved = planRepository.save(plan);
            return PlanMapper.toDTO(saved);
    }

    @Transactional
    public void deleteById(String id) {
        Plan plan = findByIdOrThrow(id);
        plan.setActive(false);
        planRepository.save(plan);
    }
}
