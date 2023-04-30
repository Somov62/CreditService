package com.SberTech.CreditService.Mappers.Pledges;

import com.SberTech.CreditService.CreditDealDatabase.Entities.Pledges.BasePledge;
import com.SberTech.CreditService.CreditDealDatabase.Entities.Pledges.CarPledge;
import com.SberTech.CreditService.CreditDealDatabase.Entities.Pledges.FlatPledge;
import com.SberTech.CreditService.CreditDealDatabase.Entities.Pledges.LandPledge;
import com.SberTech.CreditService.Mappers.IDtoMapper;
import com.SberTech.CreditService.Dto.Pledges.BasePledgeDto;
import com.SberTech.CreditService.Dto.Pledges.CarPledgeDto;
import com.SberTech.CreditService.Dto.Pledges.FlatPledgeDto;
import com.SberTech.CreditService.Dto.Pledges.LandPledgeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Главный маппер класс залогов, для использования в сервисах и контроллерах
//Оборачивает в себя четыря маппера для каждой сущности
@Service
public class PledgeMapper implements IDtoMapper<BasePledge, BasePledgeDto> {

    @Autowired
    private BasePledgeMapper baseMapper;
    @Autowired
    private CarPledgeMapper carMapper;
    @Autowired
    private FlatPledgeMapper flatMapper;
    @Autowired
    private LandPledgeMapper landMapper;

    @Override
    public BasePledgeDto mapToDto(BasePledge entity) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");

        if (entity.getClass() == CarPledge.class)
            return carMapper.mapToDto((CarPledge) entity);

        if (entity.getClass() == FlatPledge.class)
            return flatMapper.mapToDto((FlatPledge) entity);

        if (entity.getClass() == LandPledge.class)
            return landMapper.mapToDto((LandPledge) entity);

        return baseMapper.mapToDto(entity);
    }

    @Override
    public BasePledge mapToEntity(BasePledgeDto dto) {
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        if (dto.getClass() == CarPledgeDto.class)
            return carMapper.mapToEntity((CarPledgeDto) dto);

        if (dto.getClass() == FlatPledgeDto.class)
            return flatMapper.mapToEntity((FlatPledgeDto) dto);

        if (dto.getClass() == LandPledgeDto.class)
            return landMapper.mapToEntity((LandPledgeDto) dto);

        return baseMapper.mapToEntity(dto);
    }

    @Override
    public BasePledge updateEntity(BasePledge entity, BasePledgeDto dto) {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");
        if (dto == null)
            throw new IllegalArgumentException("dto is null");

        if (entity.getClass() == CarPledge.class && dto.getClass() == CarPledgeDto.class)
            return carMapper.updateEntity((CarPledge) entity, (CarPledgeDto) dto);

        if (entity.getClass() == FlatPledge.class && dto.getClass() == FlatPledgeDto.class)
            return flatMapper.updateEntity((FlatPledge) entity, (FlatPledgeDto) dto);

        if (entity.getClass() == LandPledge.class && dto.getClass() == LandPledgeDto.class)
            return landMapper.updateEntity((LandPledge) entity, (LandPledgeDto) dto);

        return baseMapper.updateEntity(entity, dto);
    }
}
