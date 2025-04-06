package com.barberx.BackEnd.Barber.X.service.impl;

import org.springframework.stereotype.Service;

import com.barberx.BackEnd.Barber.X.Entity.ScheduleEntity;
import com.barberx.BackEnd.Barber.X.repository.IScheduleRepository;
import com.barberx.BackEnd.Barber.X.service.IScheduleService;
import com.barberx.BackEnd.Barber.X.service.query.IScheduleQueryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService {

    private final IScheduleRepository repository;
    private final IScheduleQueryService queryService;

    @Override
    public ScheduleEntity save(final ScheduleEntity entity) {
        queryService.verifyIfScheduleExists(entity.getStartAt(), entity.getEndAt());

        return repository.save(entity);
    }

    @Override
    public void delete(final long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}
