package com.crv.microprofile.health.messages.jaxrs.api;

import com.crv.microprofile.health.messages.jaxrs.Message;

import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.ApplicationScoped;

@Traced
@ApplicationScoped
public class MessageAdapter {

    public Message fromResource(MessageResource messageResource) {
        Message message = new Message();
        message.setMessage(messageResource.getMessage());
        return message;
    }
}
