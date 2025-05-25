package com.Streaming.microservicioS.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Streaming.microservicioS.Model.StreamingSession;

import java.util.List;

@Repository
public interface StreamingSessionRepository extends JpaRepository<StreamingSession, Long> {
    List<StreamingSession> findByIdUsuario(Long idUsuario);
    List<StreamingSession> findByEstado(StreamingSession.EstadoSesion estado);
}
