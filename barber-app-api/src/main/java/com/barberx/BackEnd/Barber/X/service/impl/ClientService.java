package com.barberx.BackEnd.Barber.X.service.impl;

import org.springframework.stereotype.Repository;

import com.barberx.BackEnd.Barber.X.Entity.ClientEntity;
import com.barberx.BackEnd.Barber.X.repository.IClientRepository;
import com.barberx.BackEnd.Barber.X.service.IClientService;
import com.barberx.BackEnd.Barber.X.service.query.IClientQueryService;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ClientService implements IClientService {

    private final IClientRepository repository;
    private final IClientQueryService queryService;

    @Override
    public ClientEntity save(final ClientEntity entity) {
        queryService.verifyEmail(entity.getEmail());
        queryService.verifyPhone(entity.getPhone());

        return repository.save(entity);
    }

    @Override
    public ClientEntity update(final ClientEntity entity) {
        queryService.verifyEmail(entity.getId(), entity.getEmail());
        queryService.verifyPhone(entity.getId(), entity.getPhone());

        var stored = queryService.findById(entity.getId());
        stored.setName(entity.getName());
        stored.setPhone(entity.getPhone());
        stored.setEmail(entity.getEmail());
        return repository.save(stored);
    }

    @Override
    public void delete(final long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}