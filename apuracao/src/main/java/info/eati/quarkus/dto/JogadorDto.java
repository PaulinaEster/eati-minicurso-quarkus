package info.eati.quarkus.dto;

import lombok.Data;

@Data
public class JogadorDto {
    private Long id;
    
    private String nome;
    private String time;
    private int camisa;
}
