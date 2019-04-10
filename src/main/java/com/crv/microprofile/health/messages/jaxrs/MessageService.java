package com.crv.microprofile.health.messages.jaxrs;

import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.opentracing.Tracer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Traced
@ApplicationScoped
@Slf4j
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = { @Inject })
public class MessageService {
    private Tracer tracer;
    @Traced
    public void send(Message fromResource) {
        tracer.activeSpan()
              .log("Thorntail version 2.4.0");
        log.info("Thorntail version 2.4.0");
    }
}
