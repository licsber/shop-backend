package site.licsber.shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.licsber.shop.service.impl.SendMailServiceImpl;

@SpringBootTest
public class EmailSenderTests {

    @Autowired
    private SendMailServiceImpl sendMailService;

    @Test
    void sendSimpleMail() {
        if (true) {
            // skip test
            return;
        }
        assert sendMailService.sendSimpleMail("460874737@qq.com",
                "你好", "这里是正文");
    }

}
