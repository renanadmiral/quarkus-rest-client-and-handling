package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pokemon")
@RequiredArgsConstructor
public class ExampleResource {

    @RestClient
    @Inject
    PokeApiIntegrationClient integrationClient;

    @GET
    @Path("/{pokemon}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(@PathParam("pokemon") final String pokemon) {
        return Response.ok(integrationClient.getPokemon(pokemon)).build();
    }
}