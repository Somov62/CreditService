package com.SberTech.CreditService.Repos.Pledges;

import com.SberTech.CreditService.Entities.Pledges.BasePledge;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface BasePledgeRepo<T extends BasePledge>  extends ListCrudRepository<T, Long> {
}
