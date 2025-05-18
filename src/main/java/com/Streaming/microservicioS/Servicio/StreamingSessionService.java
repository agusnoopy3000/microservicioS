package com.Streaming.microservicioS.Servicio;

import com.Streaming.microservicioS.Modelo.StreamingSession;
import com.Streaming.microservicioS.Repositorio.StreamingSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingSessionService {

    private final StreamingSessionRepository repository;


    public StreamingSession iniciarSesion(Long idUsuario, Long idJuego, Long idMaquina) {
        StreamingSession sesion = StreamingSession.builder()
                .idUsuario(idUsuario)
                .idJuego(idJuego)
                .idMaquina(idMaquina)
                .inicio(LocalDateTime.now())
                .estado(StreamingSession.EstadoSesion.ACTIVA)
                .build();
        return repository.save(sesion);
    }

    // Finalizar Streaming por id
    public StreamingSession finalizarSesion(Long idSesion) {
        Optional<StreamingSession> opt = repository.findById(idSesion);
        if (opt.isPresent()) {
            StreamingSession sesion = opt.get();
            sesion.setFin(LocalDateTime.now());
            sesion.setEstado(StreamingSession.EstadoSesion.FINALIZADA);
            return repository.save(sesion);
        }
        throw new RuntimeException("Sesión no encontrada.");
    }
    //Listar Sesiones por id usuario.
    public List<StreamingSession> listarSesionesPorUsuario(Long idUsuario) {
        return repository.findByIdUsuario(idUsuario);
    }
    //Listar Sesiones Activas
    public List<StreamingSession> listarSesionesActivas() {
        return repository.findByEstado(StreamingSession.EstadoSesion.ACTIVA);
    }
    //Crear Sesion de streaming
    public StreamingSession crearStreaming(StreamingSession streaming) {
        return repository.save(streaming);
    }
    //Eliminar Sesion de Streaming por ID
    public void eliminarStreaming(Long id) {
        repository.deleteById(id);
    }


}
