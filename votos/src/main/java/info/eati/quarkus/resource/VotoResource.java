package info.eati.quarkus.resource;

import info.eati.quarkus.dto.VotoDto;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("api/votos")
public class VotoResource {

    @Path("/")
    @POST
    public Response registrarVoto(VotoDto  votoDto){
        return Response.ok().build();
    }
    
}
