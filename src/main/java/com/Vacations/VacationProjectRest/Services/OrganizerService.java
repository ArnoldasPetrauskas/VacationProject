package com.Vacations.VacationProjectRest.Services;

import com.Vacations.VacationProjectRest.Entities.Organizer;
import com.Vacations.VacationProjectRest.Persistance.OrganizerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrganizerService {
    private final OrganizerRepository organizerRepository;

    public OrganizerService(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }

    public Organizer getOrganizer(int id){
        return organizerRepository.findById(id).get();
    }

    public void saveAll(Set<Organizer> organizerList){
        organizerRepository.saveAll(organizerList);
    }
}
