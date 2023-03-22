package com.SberTech.CreditService.Repos.Participants;

import com.SberTech.CreditService.Entities.Participants.Participant;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepo<T extends Participant> extends ListCrudRepository<T, Long> {
}
