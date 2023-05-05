package com.Vacations.VacationProjectRest.Vacations;

import com.Vacations.VacationProjectRest.Entities.Vacation;
import com.Vacations.VacationProjectRest.Persistance.VacationRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class FakeVacationRepository implements VacationRepository {

    private List<Vacation> vacations;

    public FakeVacationRepository(List<Vacation> vacations){
        this.vacations = vacations;
    }

    @Override
    public List<Vacation> findAll(){
        return new ArrayList<>(vacations);
    }

    @Override
    public Vacation findById(int id) {
        return vacations
                .stream()
                .filter(vacation -> vacation.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Vacation not found by id: " + id));
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Vacation> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Vacation> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Vacation> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Vacation getOne(Integer integer) {
        return null;
    }

    @Override
    public Vacation getById(Integer integer) {
        return null;
    }

    @Override
    public Vacation getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Vacation> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Vacation> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Vacation> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Vacation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Vacation> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Vacation> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Vacation, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Vacation> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Vacation> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Vacation> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }


    @Override
    public List<Vacation> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Vacation entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Vacation> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Vacation> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Vacation> findAll(Pageable pageable) {
        return null;
    }
}
