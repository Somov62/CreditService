package com.SberTech.CreditService.Repos;

import com.SberTech.CreditService.Entities.CreditDeal;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditDealRepo extends ListCrudRepository<CreditDeal, Long> {
}
