package com.barberx.BackEnd.Barber.X.service.query;

import java.util.List;

import com.barberx.BackEnd.Barber.X.Entity.ClientEntity;

public interface IClientQueryService {

    ClientEntity findById(final long id);
    List<ClientEntity> list();
    void verifyPhone(final String phone);
    void verifyPhone(final long id,final String phone);
    void verifyEmail(final String email);
    void verifyEmail(final long id,final String email);
}
