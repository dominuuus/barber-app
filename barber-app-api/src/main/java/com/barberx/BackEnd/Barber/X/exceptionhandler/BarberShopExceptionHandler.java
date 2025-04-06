package com.barberx.BackEnd.Barber.X.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpHeaders;

import com.barberx.BackEnd.Barber.X.controller.response.ProblemResponse;

import lombok.extern.log4j.Log4j2;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.time.OffsetDateTime;

@Log4j2
@ControllerAdvice
public class BarberShopExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUncaught(final Exception ex, final WebRequest request){
        log.error("handleUncaught: ", ex);
        var status = INTERNAL_SERVER_ERROR;
        var response = ProblemResponse.builder()
                .status(status.value())
                .timestamp(OffsetDateTime.now())
                .message(ex.getMessage())
                .build();
        return handleExceptionInternal(ex, response, new HttpHeaders(), status, request);
    }

}
