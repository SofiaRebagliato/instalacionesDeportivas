package com.example.instalacionesDeportivas.services;

import com.example.instalacionesDeportivas.interfaces.IContacto;
import java.lang.System.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactoService implements IContacto{
    
    //private static final Logger LOGGER = LoggerFactory.getLogger(ContactoService.class);
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    
    public void enviarEmail(String from, String to, String subject, String message){
        
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        
        javaMailSender.send(mailMessage);
    }
  
//    @Override
//    public boolean sendEmail(EmailBody emailBody)  {
//            LOGGER.info("EmailBody: {}", emailBody.toString());
//            return sendEmailTool(emailBody.getContent(),emailBody.getEmail(), emailBody.getSubject());
//    }
//
//
//    private boolean sendEmailTool(String textMessage, String email,String subject) {
//            boolean send = false;
//            MimeMessage message = sender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message);		
//            try {
//                    helper.setTo(email);
//                    helper.setText(textMessage, true);
//                    helper.setSubject(subject);
//                    sender.send(message);
//                    send = true;
//                    LOGGER.info("Mail enviado!");
//            } catch (MessagingException e) {
//                    LOGGER.error("Hubo un error al enviar el mail: {}", e);
//            }
//            return send;
//    }	
    
}
