package com.barberx.BackEnd.Barber.X.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barberx.BackEnd.Barber.X.Entity.ScheduleEntity;

@Repository
public interface IScheduleRepository extends JpaRepository<ScheduleEntity, Long>{

    List<ScheduleEntity> findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(
            final OffsetDateTime startAt,
            final OffsetDateTime endAt
    );

    boolean existsByStartAtAndEndAt(final OffsetDateTime startAt, final OffsetDateTime endAt);
    
} 
