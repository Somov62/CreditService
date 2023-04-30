package com.SberTech.CreditService.Mappers.Pledges;

import com.SberTech.CreditService.CreditDealDatabase.Entities.Pledges.FlatPledge;
import com.SberTech.CreditService.Mappers.IDtoMapper;
import com.SberTech.CreditService.Dto.Pledges.FlatPledgeDto;
import org.springframework.stereotype.Service;

@Service
public class FlatPledgeMapper implements IDtoMapper<FlatPledge, FlatPledgeDto> {
    @Override
    public FlatPledgeDto mapToDto(FlatPledge entity) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");
        FlatPledgeDto dto = new FlatPledgeDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAmount(entity.getAmount());

        dto.setAddress(entity.getAddress());
        dto.setFloor(entity.getFloor());
        dto.setCadastralNumber(entity.getCadastralNumber());
        dto.setTotalArea(entity.getTotalArea());

        return dto;
    }

    @Override
    public FlatPledge mapToEntity(FlatPledgeDto dto) {
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        return updateEntity(new FlatPledge(), dto);
    }

    @Override
    public FlatPledge updateEntity(FlatPledge entity, FlatPledgeDto dto) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAmount(dto.getAmount());

        entity.setAddress(dto.getAddress());
        entity.setFloor(dto.getFloor());
        entity.setCadastralNumber(dto.getCadastralNumber());
        entity.setTotalArea(dto.getTotalArea());

        return entity;
    }
}
