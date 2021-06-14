package javacamp.hrms.core.concretes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javacamp.hrms.core.abstracts.ValidationService;
import javacamp.hrms.core.utilities.results.ErrorDataResult;

@Service
public class ValidationManager implements ValidationService {

	@Override
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception) {
		Map<String, String> validationErros = new HashMap<String, String>();
		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
			validationErros.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErros, "Doğrulama Hataları");
		return errors;
	}

}
