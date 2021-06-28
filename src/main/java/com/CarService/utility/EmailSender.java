package com.CarService.utility;

public interface EmailSender {
	void sendEmail(String to, String subject, String content);
}
