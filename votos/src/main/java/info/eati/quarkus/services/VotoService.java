package info.eati.quarkus.services;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.OnOverflow;

import info.eati.quarkus.dto.VotoDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class VotoService {
    
    @Inject
    @Channel("voto-computado")
    @OnOverflow(value = OnOverflow.Strategy.UNBOUNDED_BUFFER)
    Emitter<VotoDto> votoComputadoEmitter;

    public void registrarVoto(VotoDto voto){
        votoComputadoEmitter.send(voto);
    }
}
