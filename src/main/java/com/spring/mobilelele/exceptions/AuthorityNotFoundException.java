package com.spring.mobilelele.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.spring.mobilelele.exceptions.constants.ExceptionMessages.AUTHORITY_NOT_FOUND_MESSAGE;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = AUTHORITY_NOT_FOUND_MESSAGE)
public class AuthorityNotFoundException extends RuntimeException {

}
