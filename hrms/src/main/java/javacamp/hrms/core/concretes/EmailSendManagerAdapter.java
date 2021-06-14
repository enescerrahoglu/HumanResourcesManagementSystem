package javacamp.hrms.core.concretes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.core.abstracts.EmailSendService;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.emailService.EmailSendManager;
import javacamp.hrms.entities.concretes.Email;
import javacamp.hrms.validationCodeService.ValidationCodeManager;

@Service
public class EmailSendManagerAdapter implements EmailSendService {

	private EmailSendManager emailSendManager;
	private ValidationCodeManager validationCodeManager;
	private static Logger log = LoggerFactory.getLogger(EmailSendManagerAdapter.class);
	
	@Autowired
	public EmailSendManagerAdapter(EmailSendManager emailSendManager, ValidationCodeManager validationCodeManager) {
		this.emailSendManager = emailSendManager;
		this.validationCodeManager = validationCodeManager;
	}
	
	@Override
	public void emailSend(String email) {
		emailSendManager.emailSending(email);
	}

	@Override
	public Result run(String email) throws Exception {
		long code = this.validationCodeManager.createCode();
		
		log.info("HRMS - Doğrulama kodu gönderildi.");
		
		Email mail = new Email();
		mail.setFrom("HRMS");
		mail.setTo(email);
		mail.setSubject("HRMS Doğrulama Kodu");
		mail.setContent("Hesabınızı doğrulamanız için gerekli doğrulama kodunuz: " + code);
		
		emailSendManager.sendSimpleMessage(mail);
		return new SuccessResult("Doğrulama maili gönderildi.");
	}

}
