package top.probiecoder.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/jms")
@Slf4j
public class TestController {
    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping(value = "/send")
    public void test() {
        log.info("send a jms message");
        jmsTemplate.convertAndSend("mailbox", new Email("restcontroller@example.com", "this message from controller"));
        log.info("send a jms message end");
    }
}
