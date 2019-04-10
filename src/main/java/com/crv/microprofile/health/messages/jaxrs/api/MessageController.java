package com.crv.microprofile.health.messages.jaxrs.api;

import com.crv.microprofile.health.messages.jaxrs.MessageService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Path("/messages/jaxrs")
@AllArgsConstructor(onConstructor_ = { @Inject })
@NoArgsConstructor
@Slf4j
public class MessageController {
    private MessageAdapter messageAdapter;
    private MessageService messageService;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putMessage(MessageResource messageResource) {
        log.info("Sending message");
        messageService.send(messageAdapter.fromResource(messageResource));
        return Response.accepted(messageResource).build();
    }
}
