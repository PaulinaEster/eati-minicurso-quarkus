package info.eati.quarkus.resource;

 
import java.util.List;

import info.eati.quarkus.dto.ResultadoApuracaoDto;
import info.eati.quarkus.repository.VotoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/api/apuracao")
public class ApuracaoResource {

    @Inject
    VotoRepository  votoRepository;

    @Path("/")
    @GET
    public Response consultarApuracao(){
        List<ResultadoApuracaoDto> resultados = votoRepository.consultarApuracao();
        return Response.ok().entity(resultados).build();
    }   
}
