package com.SberTech.CreditService.Mappers.Participants;

import com.SberTech.CreditService.Entities.Participants.Participant;
import com.SberTech.CreditService.Mappers.IDtoMapper;
import com.SberTech.CreditService.Models.Participants.ParticipantDto;
import org.springframework.stereotype.Service;

@Service
public class BaseParticipantMapper implements IDtoMapper<Participant, ParticipantDto> {
    @Override
    public ParticipantDto mapToDto(Participant entity) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");

        ParticipantDto dto = new ParticipantDto();
        dto.setId(entity.getId());
        dto.setInn(entity.getInn());
        dto.setName(entity.getName());
        dto.setBorrower(entity.isBorrower());
        dto.setGuarantor(entity.isGuarantor());
        dto.setPledger(entity.isPledger());
        return dto;
    }

    @Override
    public Participant mapToEntity(ParticipantDto dto) {
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        return updateEntity(new Participant(), dto);
    }

    @Override
    public Participant updateEntity(Participant entity, ParticipantDto dto) {
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
        return null;
    }


}
