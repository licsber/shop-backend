package site.licsber.shop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import site.licsber.shop.service.SendMailService;

@Slf4j
@Service
public class SendMailServiceImpl implements SendMailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    public SendMailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public boolean sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
            log.info(to + " 发送成功 " + subject);
            return true;
        } catch (Exception e) {
            log.info(to + " 发送失败 " + subject + e.getMessage());
            return false;
        }
    }

}
