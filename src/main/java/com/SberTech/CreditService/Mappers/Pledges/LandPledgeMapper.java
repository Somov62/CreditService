package com.SberTech.CreditService.Mappers.Pledges;

import com.SberTech.CreditService.CreditDealDatabase.Entities.Pledges.LandPledge;
import com.SberTech.CreditService.Mappers.IDtoMapper;
import com.SberTech.CreditService.Dto.Pledges.LandPledgeDto;
import org.springframework.stereotype.Service;

@Service
public class LandPledgeMapper implements IDtoMapper<LandPledge, LandPledgeDto> {
    @Override
    public LandPledgeDto mapToDto(LandPledge entity) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");
        LandPledgeDto dto = new LandPledgeDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAmount(entity.getAmount());
        return dto;
    }

    @Override
    public LandPledge mapToEntity(LandPledgeDto dto) {
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        return updateEntity(new LandPledge(), dto);
    }

    @Override
    public LandPledge updateEntity(LandPledge entity, LandPledgeDto dto) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAmount(dto.getAmount());

        entity.setAddress(dto.getAddress());
        entity.setCadastralNumber(dto.getCadastralNumber());
        entity.setTotalArea(dto.getTotalArea());

        return entity;
    }
}
