package com.app.employeetddexample.email.event;

import com.app.employeetddexample.email.model.EmailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class MailPublisher {
    @Autowired
    private MailOutputStream mailOutputStream;

    public void sendMessageToEmail(EmailData emailData){

        mailOutputStream.publicMessage().
                send(MessageBuilder.withPayload(emailData).build());

    }
}
