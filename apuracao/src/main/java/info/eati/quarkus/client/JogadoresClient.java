package info.eati.quarkus.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import info.eati.quarkus.dto.JogadorDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api/jogadores")
@RegisterRestClient(configKey = "clients.jogadores")
public interface JogadoresClient {

    @GET
    @Path("/")
    JogadorDto consultarJogadorPeloId(Long id);
    
}
    