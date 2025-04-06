package com.barberx.BackEnd.Barber.X.service.query;

import java.time.OffsetDateTime;
import java.util.List;

import com.barberx.BackEnd.Barber.X.Entity.ScheduleEntity;

public interface IScheduleQueryService {
    ScheduleEntity findById(final long id);
    List<ScheduleEntity> findInMonth(final OffsetDateTime startAt, final OffsetDateTime endAt);
    void verifyIfScheduleExists(final OffsetDateTime startAt, final OffsetDateTime endAt);
}
