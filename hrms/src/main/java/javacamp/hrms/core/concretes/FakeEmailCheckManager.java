package javacamp.hrms.core.concretes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javacamp.hrms.core.abstracts.EmailCheckService;

@Primary
@Component
public class FakeEmailCheckManager implements EmailCheckService {

	@Override
	public boolean emailCheck(String email) {
		return true;
	}

}
