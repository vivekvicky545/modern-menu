package com.modernmenu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Resource Already Exits")
public class ResourceAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
