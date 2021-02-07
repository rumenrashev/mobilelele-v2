package com.spring.mobilelele.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.spring.mobilelele.exceptions.constants.ExceptionMessages.BRAND_NOT_FOUND_MESSAGE;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = BRAND_NOT_FOUND_MESSAGE)
public class BrandNotFoundException extends RuntimeException {

}
