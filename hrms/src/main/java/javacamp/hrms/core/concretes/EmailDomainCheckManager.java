package javacamp.hrms.core.concretes;


import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import javacamp.hrms.core.abstracts.EmailDomainCheckService;

@Service
public class EmailDomainCheckManager implements EmailDomainCheckService {

	@Override
	public boolean checkDomain(String email, String website) {
		boolean result = false;
		String[] emails = email.split("@");
		String[] domain = website.split("www.");
		if (Objects.equal(emails[1], domain[1])) {
			result = true;
		}
		return result;
	}

}
