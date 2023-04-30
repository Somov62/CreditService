package com.SberTech.CreditService.CreditDealDatabase.Repos.Pledges;

import com.SberTech.CreditService.CreditDealDatabase.Entities.Pledges.BasePledge;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasePledgeRepo<T extends BasePledge>  extends ListCrudRepository<T, Long> {
}
