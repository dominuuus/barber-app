package com.barberx.BackEnd.Barber.X.service;

import com.barberx.BackEnd.Barber.X.Entity.ClientEntity;

public interface IClientService {

    ClientEntity save(final ClientEntity entity);
    ClientEntity update(final ClientEntity entity);
    void delete(final long id);
    
}
