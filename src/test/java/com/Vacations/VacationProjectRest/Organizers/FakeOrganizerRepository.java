package com.Vacations.VacationProjectRest.Organizers;

import com.Vacations.VacationProjectRest.Entities.Organizer;
import com.Vacations.VacationProjectRest.Entities.Vacation;
import com.Vacations.VacationProjectRest.Persistance.OrganizerRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class FakeOrganizerRepository implements OrganizerRepository {

    private List<Organizer> organizers;

    public FakeOrganizerRepository(List<Organizer> organizers){
        this.organizers = organizers;
    }

    public List<Organizer> findAll(){
        return new ArrayList<>(organizers);
    }

    @Override
    public Organizer findById(int id) {
        return organizers
                .stream()
                .filter(vacation -> vacation.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Vacation not found by id: " + id));
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Organizer> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Organizer> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Organizer> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Organizer getOne(Integer integer) {
        return null;
    }

    @Override
    public Organizer getById(Integer integer) {
        return null;
    }

    @Override
    public Organizer getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Organizer> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Organizer> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Organizer> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public List<Organizer> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public <S extends Organizer> S save(S entity) {
        return null;
    }

    @Override
    public Optional<Organizer> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Organizer entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Organizer> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Organizer> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Organizer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Organizer> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Organizer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Organizer> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Organizer> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Organizer, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
