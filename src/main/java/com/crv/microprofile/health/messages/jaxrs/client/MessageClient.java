package com.crv.microprofile.health.messages.jaxrs.client;

import com.crv.microprofile.health.messages.jaxrs.Message;
import com.crv.microprofile.health.messages.jaxrs.api.MessageResource;

import org.eclipse.microprofile.opentracing.Traced;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/messages")
@Traced
public interface MessageClient {

    @PUT
    @Path("/")
    MessageResource sendMessage(Message message);
}
