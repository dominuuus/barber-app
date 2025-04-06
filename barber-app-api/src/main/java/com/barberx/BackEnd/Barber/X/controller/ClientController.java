package com.barberx.BackEnd.Barber.X.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.barberx.BackEnd.Barber.X.controller.request.SaveClientRequest;
import com.barberx.BackEnd.Barber.X.controller.request.UpdateClientRequest;
import com.barberx.BackEnd.Barber.X.controller.response.ClientDetailResponse;
import com.barberx.BackEnd.Barber.X.controller.response.ListClientResponse;
import com.barberx.BackEnd.Barber.X.controller.response.SaveClientResponse;
import com.barberx.BackEnd.Barber.X.controller.response.UpdateClientResponse;
import com.barberx.BackEnd.Barber.X.mapper.IClientMapper;
import com.barberx.BackEnd.Barber.X.service.IClientService;
import com.barberx.BackEnd.Barber.X.service.query.IClientQueryService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

@RestController
@RequestMapping("clients")
@AllArgsConstructor
public class ClientController {

    private final IClientService service;
    private final IClientQueryService queryService;
    private final IClientMapper mapper;

    @PostMapping
    @ResponseStatus(CREATED)
    SaveClientResponse save(@RequestBody @Valid final SaveClientRequest request){
        var entity = mapper.toEntity(request);
        service.save(entity);
        return mapper.toSaveResponse(entity);
    }

    @PutMapping("{id}")
    UpdateClientResponse update(@PathVariable final long id, @RequestBody @Valid final UpdateClientRequest request){
        var entity = mapper.toEntity(id, request);
        service.update(entity);
        return mapper.toUpdateResponse(entity);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    void delete(@PathVariable final long id){
        service.delete(id);
    }

    @GetMapping("{id}")
    ClientDetailResponse findById(@PathVariable final long id){
        var entity = queryService.findById(id);
        return mapper.toDetailResponse(entity);
    }

    @GetMapping
    List<ListClientResponse> list(){
        var entities = queryService.list();
        return mapper.toListResponse(entities);
    }

}