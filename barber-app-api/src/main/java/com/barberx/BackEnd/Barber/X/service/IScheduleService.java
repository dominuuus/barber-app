package com.barberx.BackEnd.Barber.X.service;

import com.barberx.BackEnd.Barber.X.Entity.ScheduleEntity;

public interface IScheduleService {

    ScheduleEntity save(final ScheduleEntity entity);
    void delete(final long id);

}
