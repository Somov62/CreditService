package com.SberTech.CreditService.Mappers.Pledges;

import com.SberTech.CreditService.CreditDealDatabase.Entities.Pledges.BasePledge;
import com.SberTech.CreditService.Mappers.IDtoMapper;
import com.SberTech.CreditService.Dto.Pledges.BasePledgeDto;
import org.springframework.stereotype.Service;

@Service
public class BasePledgeMapper implements IDtoMapper<BasePledge, BasePledgeDto> {
    @Override
    public BasePledgeDto mapToDto(BasePledge entity) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");
        BasePledgeDto dto = new BasePledgeDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAmount(entity.getAmount());
        return dto;
    }

    @Override
    public BasePledge mapToEntity(BasePledgeDto dto) {
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        return updateEntity(new BasePledge(), dto);
    }

    @Override
    public BasePledge updateEntity(BasePledge entity, BasePledgeDto dto) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");
        if (dto == null)
            throw new IllegalArgumentException("dto is null");
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAmount(dto.getAmount());
        return entity;
    }
}
