package site.licsber.shop.service;

public interface SendMailService {

    boolean sendSimpleMail(String to, String subject, String content);
        
}
