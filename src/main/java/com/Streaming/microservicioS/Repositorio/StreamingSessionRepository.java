package com.Streaming.microservicioS.Repositorio;


import com.Streaming.microservicioS.Modelo.StreamingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreamingSessionRepository extends JpaRepository<StreamingSession, Long> {
    List<StreamingSession> findByIdUsuario(Long idUsuario);
    List<StreamingSession> findByEstado(StreamingSession.EstadoSesion estado);
}
