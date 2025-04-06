package com.barberx.BackEnd.Barber.X.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.barberx.BackEnd.Barber.X.Entity.ClientEntity;
import com.barberx.BackEnd.Barber.X.controller.request.SaveClientRequest;
import com.barberx.BackEnd.Barber.X.controller.request.UpdateClientRequest;
import com.barberx.BackEnd.Barber.X.controller.response.ClientDetailResponse;
import com.barberx.BackEnd.Barber.X.controller.response.ListClientResponse;
import com.barberx.BackEnd.Barber.X.controller.response.SaveClientResponse;
import com.barberx.BackEnd.Barber.X.controller.response.UpdateClientResponse;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final SaveClientRequest request);

    SaveClientResponse toSaveResponse(final ClientEntity entity);

    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final long id, final UpdateClientRequest request);

    UpdateClientResponse toUpdateResponse(final ClientEntity entity);

    ClientDetailResponse toDetailResponse(final ClientEntity entity);

    List<ListClientResponse> toListResponse(final List<ClientEntity> entities);

}
