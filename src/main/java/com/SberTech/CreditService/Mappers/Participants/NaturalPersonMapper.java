package com.SberTech.CreditService.Mappers.Participants;

import com.SberTech.CreditService.Entities.Participants.NaturalPerson;
import com.SberTech.CreditService.Mappers.IDtoMapper;
import com.SberTech.CreditService.Models.Participants.NaturalPersonDto;
import org.springframework.stereotype.Service;

@Service
public class NaturalPersonMapper implements IDtoMapper<NaturalPerson, NaturalPersonDto> {
    @Override
    public NaturalPersonDto mapToDto(NaturalPerson entity) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");

        NaturalPersonDto dto = new NaturalPersonDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setInn(entity.getInn());
        dto.setBorrower(entity.isBorrower());
        dto.setGuarantor(entity.isGuarantor());
        dto.setPledger(entity.isPledger());

        dto.setFirstName(entity.getFirstName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setLastName(entity.getLastName());
        dto.setPassportSerial(entity.getPassportSerial());
        dto.setPassportNumber(entity.getPassportNumber());
        dto.setGender(entity.getGender());

        dto.setRegistration_address(entity.getRegistration_address());
        dto.setResidential_address(entity.getResidential_address());

        return dto;
    }

    @Override
    public NaturalPerson mapToEntity(NaturalPersonDto dto) {
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        return updateEntity(new NaturalPerson(), dto);
    }

    @Override
    public NaturalPerson updateEntity(NaturalPerson entity, NaturalPersonDto dto) {
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

        entity.setFirstName(dto.getFirstName());
        entity.setMiddleName(dto.getMiddleName());
        entity.setLastName(dto.getLastName());
        entity.setPassportSerial(dto.getPassportSerial());
        entity.setPassportNumber(dto.getPassportNumber());
        entity.setGender(dto.getGender());

        entity.setRegistration_address(dto.getRegistration_address());
        entity.setResidential_address(dto.getResidential_address());
        return entity;
    }
}
