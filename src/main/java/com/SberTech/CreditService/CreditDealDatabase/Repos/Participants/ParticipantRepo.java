package com.SberTech.CreditService.CreditDealDatabase.Repos.Participants;

import com.SberTech.CreditService.CreditDealDatabase.Entities.Participants.Participant;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepo<T extends Participant> extends ListCrudRepository<T, Long> {
}
