package com.SberTech.CreditService.Services;

import com.SberTech.CreditService.CreditDealDatabase.Entities.CreditDeal;
import com.SberTech.CreditService.CreditDealDatabase.Entities.Participants.Participant;
import com.SberTech.CreditService.CreditDealDatabase.Entities.Pledges.BasePledge;
import com.SberTech.CreditService.Exceptions.NotFoundException;
import com.SberTech.CreditService.Mappers.CreditDealMapper;
import com.SberTech.CreditService.Dto.CreditDealDto;
import com.SberTech.CreditService.CreditDealDatabase.Repos.CreditDealRepo;
import com.SberTech.CreditService.CreditDealDatabase.Repos.Participants.ParticipantRepo;
import com.SberTech.CreditService.CreditDealDatabase.Repos.Pledges.BasePledgeRepo;
import com.SberTech.CreditService.Audit.Database.AuditRepo;
import com.SberTech.CreditService.Audit.Database.Enitities.AuditEntity;
import jakarta.persistence.OptimisticLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public CreditDealDto edit(CreditDealDto model) throws NotFoundException, OptimisticLockException {
        var find = repo.findById(model.getId());
        if (find.isEmpty())
            throw new NotFoundException("Сделка не найдена");
        CreditDeal entity = find.get();

        if (model.getVersion() != entity.getVersion())
            throw new OptimisticLockException(
                    "Полученные данные не актуальны, пожалуйста, вновь получите данные и сервера и обновите их");

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
