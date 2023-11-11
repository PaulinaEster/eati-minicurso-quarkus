package info.eati.quarkus.dto;

import lombok.Data;
// import lombok.Getter;
// import lombok.Setter;

// @Getter
// @Setter
@Data
public class ResultadoApuracaoDto {
    private Long quantidadeVotos;
    private Long idJogador;
    private String nomeJogador;
    private int camisaJogador;
    private String timeJogador;

    // public ResultadoApuracaoDto(Long quantidadeVotos, Long idJogador, String nomeJogador, int camisaJogador) {
    //     this.quantidadeVotos = quantidadeVotos;
    //     this.idJogador = idJogador;
    //     this.nomeJogador = nomeJogador;
    //     this.camisaJogador = camisaJogador;
    // }
}
