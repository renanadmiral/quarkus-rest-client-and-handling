package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@RegisterRestClient(baseUri = "https://pokeapi.co/api/v2/")
@RegisterProvider(PokeApiExceptionMapper.class)
@Produces("application/json")
@Consumes("application/json")
public interface PokeApiIntegrationClient {

    @GET
    @Path("/pokemon/{pokemon}")
    JsonNode getPokemon(@PathParam("pokemon") String entity) throws RuntimeException;
}
