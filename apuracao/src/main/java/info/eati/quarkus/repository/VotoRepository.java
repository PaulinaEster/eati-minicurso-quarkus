package info.eati.quarkus.repository;

import java.util.List;

import info.eati.quarkus.dto.ResultadoApuracaoDto;
import info.eati.quarkus.entity.Voto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class VotoRepository implements PanacheRepository<Voto> {

    @Inject
    EntityManager entityManager;

    @Transactional
    public List<ResultadoApuracaoDto> consultarApuracao() {
        String query = """
                select new info.eati.quarkus.dto.ResultadoApuracaoDto(
                    count(*),
                    v.idJogador,
                    v.nomeJogador,
                    v.camisaJogador,
                    v.timeJogador
                )
                from Voto v
                group by
                    v.idJogador,
                    v.nomeJogador,
                    v.camisaJogador,
                    v.timeJogador
                order by count(*) desc
                """;
        return entityManager.createQuery(query, ResultadoApuracaoDto.class).getResultList();
    }
}