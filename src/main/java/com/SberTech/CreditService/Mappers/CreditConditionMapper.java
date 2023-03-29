package com.SberTech.CreditService.Mappers;

import com.SberTech.CreditService.Entities.CreditCondition;
import com.SberTech.CreditService.Models.CreditConditionDto;
import org.springframework.stereotype.Service;

@Service
public class CreditConditionMapper implements IDtoMapper<CreditCondition, CreditConditionDto> {

    @Override
    public CreditConditionDto mapToDto(CreditCondition entity) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");

        CreditConditionDto dto = new CreditConditionDto();

        dto.setId(entity.getId());
        dto.setCreditConditionType(entity.getCreditConditionType());
        dto.setAmount(entity.getAmount());
        dto.setPeriod(entity.getPeriod());
        dto.setInterestRate(entity.getInterestRate());

        return dto;
    }

    @Override
    public CreditCondition mapToEntity(CreditConditionDto dto) {
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        return updateEntity(new CreditCondition(), dto);
    }

    @Override
    public CreditCondition updateEntity(CreditCondition entity, CreditConditionDto dto) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        entity.setId(dto.getId());
        entity.setPeriod(dto.getPeriod());
        entity.setInterestRate(dto.getInterestRate());
        entity.setCreditConditionType(dto.getCreditConditionType());
        entity.setAmount(dto.getAmount());
        return entity;
    }
}
