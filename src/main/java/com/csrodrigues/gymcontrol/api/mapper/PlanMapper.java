package com.csrodrigues.gymcontrol.api.mapper;

import com.csrodrigues.gymcontrol.api.dto.request.PlanRequestDTO;
import com.csrodrigues.gymcontrol.api.dto.response.PlanResponseDTO;
import com.csrodrigues.gymcontrol.domain.entity.Plan;

public class PlanMapper {

    public static Plan toEntity(PlanRequestDTO requestDTO){
        return new Plan(
                requestDTO.name(),
                requestDTO.description(),
                requestDTO.price(),
                requestDTO.duration()
        );
    }

    public static PlanResponseDTO toDTO(Plan plan){
        return new PlanResponseDTO(
                plan.getId(),
                plan.getName(),
                plan.getDescription(),
                plan.getPrice(),
                plan.getDuration(),
                plan.getActive()
        );
    }

    public static void updateEntityFromDTO(PlanRequestDTO requestDTO, Plan plan) {
        plan.setName(requestDTO.name());
        plan.setDescription(requestDTO.description());
        plan.setPrice(requestDTO.price());
        plan.setDuration(requestDTO.duration());
    }
}
