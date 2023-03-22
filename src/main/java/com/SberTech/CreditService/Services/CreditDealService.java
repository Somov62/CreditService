package com.SberTech.CreditService.Services;

import com.SberTech.CreditService.Entities.CreditDeal;
import com.SberTech.CreditService.Entities.Participants.Company;
import com.SberTech.CreditService.Entities.Participants.IndividualBusinessman;
import com.SberTech.CreditService.Entities.Participants.NaturalPerson;
import com.SberTech.CreditService.Entities.Participants.Participant;
import com.SberTech.CreditService.Entities.Pledges.BasePledge;
import com.SberTech.CreditService.Entities.Pledges.CarPledge;
import com.SberTech.CreditService.Entities.Pledges.FlatPledge;
import com.SberTech.CreditService.Entities.Pledges.LandPledge;
import com.SberTech.CreditService.Exceptions.NotFoundException;
import com.SberTech.CreditService.Models.CreditDealModel;
import com.SberTech.CreditService.Models.Participants.CompanyModel;
import com.SberTech.CreditService.Models.Participants.IndividualBusinessmanModel;
import com.SberTech.CreditService.Models.Participants.NaturalPersonModel;
import com.SberTech.CreditService.Models.Pledges.BasePledgeModel;
import com.SberTech.CreditService.Models.Pledges.CarPledgeModel;
import com.SberTech.CreditService.Models.Pledges.FlatPledgeModel;
import com.SberTech.CreditService.Models.Pledges.LandPledgeModel;
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

    public List<CreditDealModel> getAll() {
        return repo.findAll().stream().map(CreditDealModel::new).toList();
    }

    public CreditDealModel getById(long id) throws NotFoundException {
        var deal = repo.findById(id);
        if (deal.isEmpty())
            throw new NotFoundException("Кредитная сделка не найдена");
        return new CreditDealModel(deal.get());
    }

    public CreditDealModel add(CreditDealModel model) {
        
        CreditDeal entity = new CreditDeal();
        entity.setPeriod(model.getPeriod());
        entity.setAmount(model.getAmount());
        entity.setCreditCondition(model.getCreditCondition());
        entity.setCreationDate(model.getCreationDate());
        entity.setInterestRate(model.getInterestRate());
        entity.setParticipants(this.setParticipants(model));
        entity.setPledges(this.setPledges(model));

        entity = repo.save(entity);
        return new CreditDealModel(entity);

    }

    public CreditDealModel edit(CreditDealModel model) throws NotFoundException {
        var find = repo.findById(model.getId());
        if (find.isEmpty())
            throw new NotFoundException("Сделка не найдена");
        CreditDeal entity = find.get();

        entity.setPeriod(model.getPeriod());
        entity.setAmount(model.getAmount());
        entity.setCreditCondition(model.getCreditCondition());
        entity.setCreationDate(model.getCreationDate());
        entity.setInterestRate(model.getInterestRate());
        entity.setParticipants(this.setParticipants(model));
        entity.setPledges(this.setPledges(model));

        entity = repo.save(entity);
        return new CreditDealModel(entity);
    }

    public long delete(long id) throws NotFoundException {
        var find = repo.findById(id);
        if (find.isEmpty())
            throw new NotFoundException("Сделка не найдена");
        CreditDeal entity = find.get();
        repo.delete(entity);
        return id;
    }

    public List<Participant> setParticipants(CreditDealModel model) {

        List<Participant> participants = new ArrayList<>();
        if (model.getParticipants() == null)
            return participants;

        for (var item : model.getParticipants()) {
            var participant = participantRepo.findById(item.getId());
            if (participant.isPresent()) {
                participants.add((Participant)participant.get());
                continue;
            }

            if (item instanceof CompanyModel dto)
            {
                Company company = new Company();
                company.setOgrn(dto.getOgrn());
                company.setCompanyName(dto.getCompanyName());
                company.setRegistration_address(dto.getRegistration_address());
                company.setRegistrationDate(dto.getRegistrationDate());
                company.setResidential_address(dto.getResidential_address());
                company.setGuarantor(dto.isGuarantor());
                company.setBorrower(dto.isBorrower());
                company.setInn(dto.getInn());
                company.setName(dto.getName());
                company.setPledger(dto.isPledger());
                participantRepo.save(company);
                participants.add(company);
                continue;
            }

            if (item instanceof IndividualBusinessmanModel dto)
            {
                IndividualBusinessman indBus = new IndividualBusinessman();
                indBus.setOgrn(dto.getOgrn());
                indBus.setMiddleName(dto.getMiddleName());
                indBus.setLastName(dto.getLastName());
                indBus.setName(dto.getName());
                indBus.setInn(dto.getInn());
                indBus.setLastName(dto.getLastName());
                indBus.setPassportSerial(dto.getPassportSerial());
                indBus.setPassportNumber(dto.getPassportNumber());
                indBus.setBorrower(dto.isBorrower());
                indBus.setGuarantor(dto.isGuarantor());
                indBus.setPledger(dto.isPledger());
                indBus.setRegistration_address(dto.getRegistration_address());
                indBus.setRegistrationDate(dto.getRegistrationDate());
                indBus.setResidential_address(dto.getResidential_address());
                indBus.setGender(dto.getGender());
                participantRepo.save(indBus);
                participants.add(indBus);
                continue;
            }

            if (item instanceof NaturalPersonModel dto)
            {
                NaturalPerson natPers = new NaturalPerson();
                natPers.setMiddleName(dto.getMiddleName());
                natPers.setLastName(dto.getLastName());
                natPers.setName(dto.getName());
                natPers.setInn(dto.getInn());
                natPers.setLastName(dto.getLastName());
                natPers.setPassportSerial(dto.getPassportSerial());
                natPers.setPassportNumber(dto.getPassportNumber());
                natPers.setBorrower(dto.isBorrower());
                natPers.setGuarantor(dto.isGuarantor());
                natPers.setPledger(dto.isPledger());
                natPers.setRegistration_address(dto.getRegistration_address());
                natPers.setResidential_address(dto.getResidential_address());
                natPers.setGender(dto.getGender());
                participantRepo.save(natPers);
                participants.add(natPers);
                continue;
            }

            Participant basePart = new Participant();
            basePart.setBorrower(item.isBorrower());
            basePart.setGuarantor(item.isGuarantor());
            basePart.setPledger(item.isPledger());
            basePart.setName(item.getName());
            basePart.setInn(item.getInn());
            participantRepo.save(basePart);
            participants.add(basePart);
        }
        return participants;
    }

    public List<BasePledge> setPledges(CreditDealModel model) {
        List<BasePledge> pledges = new ArrayList<>();
        if (model.getPledges() == null)
            return pledges;

        for (var item : model.getPledges()) {
            var pledge = pledgeRepo.findById(item.getId());
            if (pledge.isPresent()) {
                pledges.add((BasePledge) pledge.get());
                continue;
            }

            if (item instanceof CarPledgeModel dto) {
                CarPledge car = new CarPledge();
                car.setBrand(dto.getBrand());
                car.setModel(dto.getModel());
                car.setPower(dto.getPower());
                car.setAmount(dto.getAmount());
                car.setVin(dto.getVin());
                car.setRegistrationNumber(dto.getRegistrationNumber());
                car.setReleaseYear(dto.getReleaseYear());
                pledgeRepo.save(car);
                pledges.add(car);
            }

            if (item instanceof LandPledgeModel dto) {
                LandPledge land = new LandPledge();
                land.setAddress(dto.getAddress());
                land.setCadastralNumber(dto.getCadastralNumber());
                land.setTotalArea(dto.getTotalArea());
                land.setAmount(dto.getAmount());
                land.setName(dto.getName());
                pledgeRepo.save(land);
                pledges.add(land);
            }

            if (item instanceof FlatPledgeModel dto) {
                FlatPledge flat = new FlatPledge();
                flat.setAddress(dto.getAddress());
                flat.setCadastralNumber(dto.getCadastralNumber());
                flat.setTotalArea(dto.getTotalArea());
                flat.setAmount(dto.getAmount());
                flat.setName(dto.getName());
                flat.setFloor(dto.getFloor());
                pledgeRepo.save(flat);
                pledges.add(flat);
            }

            BasePledge basePledge = new BasePledge();
            basePledge.setAmount(item.getAmount());
            basePledge.setName(item.getName());
            pledgeRepo.save(basePledge);
            pledges.add(basePledge);
        }

        return pledges;
    }
}
