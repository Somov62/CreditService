package com.SberTech.CreditService.Audit.Database;

import com.SberTech.CreditService.Audit.Database.Enitities.AuditEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Profile("auditEntityManagerFactory")
public interface AuditRepo extends ListCrudRepository<AuditEntity, Long> {

    List<AuditEntity> findByNameAndPrimaryKey(String name, String primaryKey);

}
