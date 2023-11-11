package info.eati.quarkus.resource;

import info.eati.quarkus.dto.VotoDto;
import info.eati.quarkus.services.VotoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("api/votos")
public class VotoResource {

    @Inject
    VotoService votoService;

    @Path("/")
    @POST
    public Response registrarVoto(VotoDto  votoDto){
        votoService.registrarVoto(votoDto);
        return Response.ok().build();
    }
}