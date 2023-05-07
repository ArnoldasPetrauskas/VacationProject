package com.Vacations.VacationProjectRest.Services;

import com.Vacations.VacationProjectRest.Entities.Organizer;
import com.Vacations.VacationProjectRest.Persistance.OrganizerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrganizerService {
    private final OrganizerRepository organizerRepository;

    public OrganizerService(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }

    public Organizer getOrganizer(int id){
        return organizerRepository.findById(id);
    }

    public void saveAll(Set<Organizer> organizerList){
        organizerRepository.saveAll(organizerList);
    }

    public List<Organizer> findAll(){
        return organizerRepository.findAll();
    }

    public Organizer findById(int organizerId) {
        return organizerRepository.findById(organizerId);
    }

    public void save(Organizer organizer) {
        organizerRepository.save(organizer);
    }
}
