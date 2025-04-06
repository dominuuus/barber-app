package com.barberx.BackEnd.Barber.X.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barberx.BackEnd.Barber.X.Entity.ClientEntity;

public interface IClientRepository extends JpaRepository<ClientEntity, Long>{
    boolean existsByEmail(final String email);
    boolean existsByPhone(final String phone);
    Optional<ClientEntity> findByEmail(final String email);
    Optional<ClientEntity> findByPhone(final String phone);
}
