package info.eati.quarkus.exceptions;

import java.util.NoSuchElementException;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ApiExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        if(exception instanceof NoSuchElementException){
            return Response.status(Response.Status.NOT_FOUND).entity("Registro não encontrado.").build();
        }
        throw new UnsupportedOperationException("Unimplemented method 'toResponse'");
    }
    
}
