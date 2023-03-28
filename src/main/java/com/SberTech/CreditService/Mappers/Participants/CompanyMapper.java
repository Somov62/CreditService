package com.SberTech.CreditService.Mappers.Participants;

import com.SberTech.CreditService.Entities.Participants.Company;
import com.SberTech.CreditService.Mappers.IDtoMapper;
import com.SberTech.CreditService.Models.Participants.CompanyDto;
import org.springframework.stereotype.Service;

@Service
public class CompanyMapper implements IDtoMapper<Company, CompanyDto> {
    @Override
    public CompanyDto mapToDto(Company entity) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");

        CompanyDto dto = new CompanyDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setInn(entity.getInn());
        dto.setBorrower(entity.isBorrower());
        dto.setGuarantor(entity.isGuarantor());
        dto.setPledger(entity.isPledger());

        dto.setCompanyName(entity.getCompanyName());
        dto.setOgrn(entity.getOgrn());
        dto.setRegistration_address(entity.getRegistration_address());
        dto.setRegistrationDate(entity.getRegistrationDate());
        dto.setResidential_address(entity.getResidential_address());
        return dto;
    }

    @Override
    public Company mapToEntity(CompanyDto dto)
    {
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        return updateEntity(new Company(), dto);
    }

    @Override
    public Company updateEntity(Company entity, CompanyDto dto) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        entity.setId(dto.getId());
        entity.setInn(dto.getInn());
        entity.setName(dto.getName());
        entity.setBorrower(dto.isBorrower());
        entity.setGuarantor(dto.isGuarantor());
        entity.setPledger(dto.isPledger());

        entity.setCompanyName(dto.getCompanyName());
        entity.setOgrn(dto.getOgrn());
        entity.setRegistrationDate(dto.getRegistrationDate());
        entity.setRegistration_address(dto.getRegistration_address());
        entity.setResidential_address(dto.getResidential_address());
        return entity;
    }
}
