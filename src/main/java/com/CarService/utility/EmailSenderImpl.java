package com.CarService.utility;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class EmailSenderImpl implements EmailSender {

	@Autowired
	public JavaMailSender javaMailSender;

	@Override
	@Async
	public void sendEmail(String to, String subject, String content) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(to);
			message.setSubject(subject);
			message.setText(content);
			javaMailSender.send(message);
		} catch (MailException exception) {
			exception.printStackTrace();
		}
	}

}
