package javacamp.hrms.core.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.core.abstracts.EmailSendService;
import javacamp.hrms.emailService.EmailSendManager;

@Service
public class EmailSendManagerAdapter implements EmailSendService {

	private EmailSendManager emailSendManager;
	
	@Autowired
	public EmailSendManagerAdapter(EmailSendManager emailSendManager) {
		this.emailSendManager = emailSendManager;
	}
	
	@Override
	public void emailSend(String email) {
		emailSendManager.emailSending(email);
	}

}
