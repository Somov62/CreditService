package com.SberTech.CreditService.Services;

import com.SberTech.CreditService.Entities.CreditDeal;
import com.SberTech.CreditService.Entities.Participants.Participant;
import com.SberTech.CreditService.Entities.Pledges.BasePledge;
import com.SberTech.CreditService.Exceptions.NotFoundException;
import com.SberTech.CreditService.Mappers.CreditDealMapper;
import com.SberTech.CreditService.Models.CreditDealDto;
import com.SberTech.CreditService.Repos.CreditDealRepo;
import com.SberTech.CreditService.Repos.Participants.ParticipantRepo;
import com.SberTech.CreditService.Repos.Pledges.BasePledgeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditDealService {

    @Autowired
    private CreditDealRepo repo;
    @Autowired
    private ParticipantRepo<Participant> participantRepo;
    @Autowired
    private BasePledgeRepo<BasePledge> pledgeRepo;
    @Autowired
    private CreditDealMapper creditDealMapper;

    public List<CreditDealDto> getAll() {

        return repo.findAll().stream().map(creditDealMapper::mapToDto).toList();
    }

    public CreditDealDto getById(long id) throws NotFoundException {
        var deal = repo.findById(id);
        if (deal.isEmpty())
            throw new NotFoundException("Кредитная сделка не найдена");
        return creditDealMapper.mapToDto(deal.get());
    }

    public CreditDealDto add(CreditDealDto model) {
        
        CreditDeal entity = creditDealMapper.mapToEntity(model);
        entity = repo.save(entity);
        return creditDealMapper.mapToDto(entity);

    }

    public CreditDealDto edit(CreditDealDto model) throws NotFoundException {
        var find = repo.findById(model.getId());
        if (find.isEmpty())
            throw new NotFoundException("Сделка не найдена");
        CreditDeal entity = find.get();

        entity = creditDealMapper.updateEntity(entity, model);

        entity = repo.save(entity);
        return creditDealMapper.mapToDto(entity);
    }

    public long delete(long id) throws NotFoundException {
        var find = repo.findById(id);
        if (find.isEmpty())
            throw new NotFoundException("Сделка не найдена");
        CreditDeal entity = find.get();
        repo.delete(entity);
        return id;
    }
}
