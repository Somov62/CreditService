package com.SberTech.CreditService.Mappers;

import com.SberTech.CreditService.Entities.CreditDeal;
import com.SberTech.CreditService.Mappers.Participants.ParticipantMapper;
import com.SberTech.CreditService.Mappers.Pledges.PledgeMapper;
import com.SberTech.CreditService.Models.CreditDealDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CreditDealMapper implements IDtoMapper<CreditDeal, CreditDealDto> {

    @Autowired
    private ParticipantMapper participantMapper;
    @Autowired
    private PledgeMapper pledgeMapper;

    @Override
    public CreditDealDto mapToDto(CreditDeal entity) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");

        CreditDealDto dto = new CreditDealDto();

        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setCreditCondition(entity.getCreditCondition());
        dto.setAmount(entity.getAmount());
        dto.setPeriod(entity.getPeriod());
        dto.setInterestRate(entity.getInterestRate());
        dto.setVersion(entity.getVersion());

        //Приведение методом toList создаст иммутабельную коллекцию
        //Связанный список участников сделки
        dto.setParticipants(entity.getParticipants().stream().map(participantMapper::mapToDto).toList());
        //Связанный список залогов
        dto.setPledges(entity.getPledges().stream().map(pledgeMapper::mapToDto).toList());
        return dto;
    }

    @Override
    public CreditDeal mapToEntity(CreditDealDto dto) {
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        return updateEntity(new CreditDeal(), dto);
    }

    @Override
    public CreditDeal updateEntity(CreditDeal entity, CreditDealDto dto) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        entity.setPeriod(dto.getPeriod());
        entity.setAmount(dto.getAmount());
        entity.setCreditCondition(dto.getCreditCondition());
        entity.setCreationDate(dto.getCreationDate());
        entity.setInterestRate(dto.getInterestRate());
        entity.setVersion(dto.getVersion());

        //Используем приведение к ArrayList, который изменяем и подходит для hibernate
        if (dto.getParticipants() != null)
            entity.setParticipants(
                    dto.getParticipants().stream().map(participantMapper::mapToEntity)
                            .collect(Collectors.toList()));
        if (dto.getPledges() != null)
            entity.setPledges(
                    dto.getPledges().stream().map(pledgeMapper::mapToEntity)
                            .collect(Collectors.toList()));
        return entity;
    }
}