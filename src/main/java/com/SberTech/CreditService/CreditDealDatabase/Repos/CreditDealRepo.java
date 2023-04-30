package com.SberTech.CreditService.CreditDealDatabase.Repos;

import com.SberTech.CreditService.Audit.Database.Enitities.AuditEntity;
import com.SberTech.CreditService.CreditDealDatabase.Entities.CreditDeal;
import com.SberTech.CreditService.Audit.Aspect.Auditable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditDealRepo extends ListCrudRepository<CreditDeal, Long> {

    @Auditable
    public CreditDeal save(CreditDeal entity);

    @Auditable
    void delete(CreditDeal entity);

}
