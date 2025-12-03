package com.SpringBootWebpage.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	public void SendEmail(String to,String sub,String body) {
		SimpleMailMessage Content = new SimpleMailMessage();
		Content.setTo(to);
		Content.setSubject(sub);
		Content.setText(body);
		javaMailSender.send(Content);
		
	
	}

}
