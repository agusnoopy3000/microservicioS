package com.Streaming.microservicioS.Model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "streaming_session")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StreamingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSesion;

    @Column(nullable = false)
    private Long idUsuario;

    @Column(nullable = false)
    private Long idJuego;

    @Column(nullable = false)
    private Long idMaquina;

    @Column(nullable = false)
    private LocalDateTime inicio;

    private LocalDateTime fin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoSesion estado;
    public enum EstadoSesion {
        ACTIVA, FINALIZADA, ERROR
    }

}
