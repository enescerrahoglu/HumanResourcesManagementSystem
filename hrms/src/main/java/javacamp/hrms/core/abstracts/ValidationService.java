package javacamp.hrms.core.abstracts;

import org.springframework.web.bind.MethodArgumentNotValidException;

import javacamp.hrms.core.utilities.results.ErrorDataResult;

public interface ValidationService {
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception);
}
