package com.ro.panel.player.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class PlayerExceptionHandler {

    @ExceptionHandler(value = PlayerRequestException.class)
    public ResponseEntity<Object> handlePlayerRequestException(PlayerRequestException e){
        // 1. Create payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        PlayerExeption playerExeption = new PlayerExeption(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        //2. Return response entity
        return new ResponseEntity<>(playerExeption, badRequest);

    }
}
