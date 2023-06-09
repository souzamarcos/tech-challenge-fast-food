package com.fiap.burger.web.controller;

import com.fiap.burger.domain.misc.exception.DomainException;
import com.fiap.burger.web.dto.common.ErrorResponseDto;
import com.fiap.burger.web.dto.common.ExceptionHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

  @ExceptionHandler({ RuntimeException.class })
  public ResponseEntity<ErrorResponseDto> handleExceptions(Exception exception, WebRequest request) {
    LOGGER.error("Handling error: ", exception);
    return new ResponseEntity<>(
        ErrorResponseDto.toErrorResponseDto(exception),
        ExceptionHttpResponse.getHttpStatusBy(exception)
    );
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlingController.class);
}