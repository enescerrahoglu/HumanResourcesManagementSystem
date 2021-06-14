package javacamp.hrms.core.abstracts;

import javacamp.hrms.core.utilities.results.Result;

public interface EmailSendService {
	public void emailSend(String email);
	
	public Result run(String email) throws Exception;
}
