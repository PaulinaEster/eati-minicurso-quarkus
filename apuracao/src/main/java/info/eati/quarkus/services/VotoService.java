package info.eati.quarkus.services;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.ClientWebApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.eati.quarkus.client.JogadoresClient;
import info.eati.quarkus.dto.JogadorDto;
import info.eati.quarkus.dto.VotoDto;
import info.eati.quarkus.entity.Voto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class VotoService {
    
    @Inject
    @RestClient
    JogadoresClient jogadoresClient;

    private static final Logger log = LoggerFactory.getLogger(VotoService.class);

    @Transactional
    @Incoming("voto-computado")
    public void computarVoto(VotoDto votoDto ){
        try{
            JogadorDto jogador = jogadoresClient.consultarJogadorPeloId(votoDto.getIdJogador());
            Voto voto = new Voto();
            voto.setIdJogador(jogador.getId() );
            voto.setCamisaJogador(jogador.getCamisa());
            voto.setTimeJogador(jogador.getTime());
            voto.setNomeJogador(jogador.getNome());
            voto.persist();
        }catch(ClientWebApplicationException e){
            if(e.getResponse().getStatus() != Response.Status.NOT_FOUND.getStatusCode() ){
                throw e;
            }
            log.info("Voto não encontrado, ", votoDto);
        }
    }

}
