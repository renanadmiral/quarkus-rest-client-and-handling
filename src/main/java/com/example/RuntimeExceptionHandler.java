package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RuntimeExceptionHandler implements ExceptionMapper<RuntimeException> {

    @Inject
    ObjectMapper objectMapper;

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(RuntimeException e) {

        try {
            return Response.ok(objectMapper.readTree("{\"errorMessage\": \"" + e.getMessage() + "\"}")).status(Response.Status.BAD_REQUEST).build();
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
