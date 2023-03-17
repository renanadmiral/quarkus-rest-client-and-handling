package com.example;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.core.Response;

public class PokeApiExceptionMapper implements ResponseExceptionMapper<RuntimeException> {
    @Override
    public RuntimeException toThrowable(Response r) {
        return new RuntimeException(r.getStatus() + " - Pokémon "  + r.readEntity(String.class));
    }
}
