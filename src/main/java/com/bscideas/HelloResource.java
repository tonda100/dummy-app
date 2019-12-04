package com.bscideas;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;


@Path("/info")
@ApplicationScoped
public class HelloResource {

    @ConfigProperty(name = "info.text")
    String infoText;

    @ConfigProperty(name = "info.wait-secs")
    Integer infoWaitSecs;

    @PostConstruct
    void init(){
        try {
            Thread.sleep(infoWaitSecs * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return infoText;
    }
}
