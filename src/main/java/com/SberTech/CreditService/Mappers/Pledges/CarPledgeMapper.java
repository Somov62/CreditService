package com.SberTech.CreditService.Mappers.Pledges;
import com.SberTech.CreditService.Entities.Pledges.CarPledge;
import com.SberTech.CreditService.Mappers.IDtoMapper;
import com.SberTech.CreditService.Models.Pledges.CarPledgeDto;
import org.springframework.stereotype.Service;

@Service
public class CarPledgeMapper implements IDtoMapper<CarPledge, CarPledgeDto> {
    @Override
    public CarPledgeDto mapToDto(CarPledge entity) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");
        CarPledgeDto dto = new CarPledgeDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAmount(entity.getAmount());

        dto.setBrand(entity.getBrand());
        dto.setModel(entity.getModel());
        dto.setPower(entity.getPower());
        dto.setAmount(entity.getAmount());
        dto.setVin(entity.getVin());
        dto.setRegistrationNumber(entity.getRegistrationNumber());
        dto.setReleaseYear(entity.getReleaseYear());
        return dto;
    }

    @Override
    public CarPledge mapToEntity(CarPledgeDto dto) {
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        return updateEntity(new CarPledge(), dto);
    }

    @Override
    public CarPledge updateEntity(CarPledge entity, CarPledgeDto dto) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");
        if (dto == null)
            throw new IllegalArgumentException("dto is null");
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAmount(dto.getAmount());

        entity.setBrand(dto.getBrand());
        entity.setModel(dto.getModel());
        entity.setPower(dto.getPower());
        entity.setAmount(dto.getAmount());
        entity.setVin(dto.getVin());
        entity.setRegistrationNumber(dto.getRegistrationNumber());
        entity.setReleaseYear(dto.getReleaseYear());
        return entity;
    }
}
