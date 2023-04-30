package com.SberTech.CreditService.Mappers.Participants;

import com.SberTech.CreditService.CreditDealDatabase.Entities.Participants.Company;
import com.SberTech.CreditService.CreditDealDatabase.Entities.Participants.IndividualBusinessman;
import com.SberTech.CreditService.CreditDealDatabase.Entities.Participants.NaturalPerson;
import com.SberTech.CreditService.CreditDealDatabase.Entities.Participants.Participant;
import com.SberTech.CreditService.Mappers.IDtoMapper;
import com.SberTech.CreditService.Dto.Participants.CompanyDto;
import com.SberTech.CreditService.Dto.Participants.IndividualBusinessmanDto;
import com.SberTech.CreditService.Dto.Participants.NaturalPersonDto;
import com.SberTech.CreditService.Dto.Participants.ParticipantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Главный маппер класс участников сделки, для использования в сервисах и контроллерах
//Оборачивает в себя четыря маппера для каждой сущности
@Service
public class ParticipantMapper implements IDtoMapper<Participant, ParticipantDto> {

    @Autowired
    private BaseParticipantMapper baseMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private NaturalPersonMapper natPersMapper;
    @Autowired
    private IndividualBusinessmanMapper indBusMapper;

    @Override
    public ParticipantDto mapToDto(Participant entity) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");

        if (entity.getClass() == Company.class)
            return companyMapper.mapToDto((Company) entity);

        if (entity.getClass() == NaturalPerson.class)
            return natPersMapper.mapToDto((NaturalPerson) entity);

        if (entity.getClass() == IndividualBusinessman.class)
            return indBusMapper.mapToDto((IndividualBusinessman) entity);

        return baseMapper.mapToDto(entity);
    }

    @Override
    public Participant mapToEntity(ParticipantDto dto) {
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        if (dto.getClass() == CompanyDto.class)
            return companyMapper.mapToEntity((CompanyDto) dto);

        if (dto.getClass() == NaturalPersonDto.class)
            return natPersMapper.mapToEntity((NaturalPersonDto) dto);

        if (dto.getClass() == IndividualBusinessmanDto.class)
            return indBusMapper.mapToEntity((IndividualBusinessmanDto) dto);

        return baseMapper.mapToEntity(dto);
    }

    @Override
    public Participant updateEntity(Participant entity, ParticipantDto dto) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        if (entity.getClass() == Company.class && dto.getClass() == CompanyDto.class)
            return companyMapper.updateEntity((Company) entity, (CompanyDto) dto);

        if (entity.getClass() == NaturalPerson.class && dto.getClass() == NaturalPersonDto.class)
            return natPersMapper.updateEntity((NaturalPerson) entity, (NaturalPersonDto) dto);

        if (entity.getClass() == IndividualBusinessman.class && dto.getClass() == IndividualBusinessmanDto.class)
            return indBusMapper.updateEntity((IndividualBusinessman) entity, (IndividualBusinessmanDto) dto);

        return baseMapper.updateEntity(entity, dto);
    }
}
