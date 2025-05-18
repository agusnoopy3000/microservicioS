package com.Streaming.microservicioS.Controlador;

import com.Streaming.microservicioS.Modelo.StreamingSession;
import com.Streaming.microservicioS.Servicio.StreamingSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/streaming")
@RequiredArgsConstructor
public class StreamingSessionController {

    private final StreamingSessionService streamingSessionService;

    @PostMapping("/iniciar")
    public ResponseEntity<StreamingSession> iniciarSesion(
            @RequestParam Long idUsuario,
            @RequestParam Long idJuego,
            @RequestParam Long idMaquina) {

        StreamingSession sesion = streamingSessionService.iniciarSesion(idUsuario, idJuego, idMaquina);
        return ResponseEntity.ok(sesion);
    }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<StreamingSession> finalizarSesion(@PathVariable Long id) {
        StreamingSession sesion = streamingSessionService.finalizarSesion(id);
        return ResponseEntity.ok(sesion);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<StreamingSession>> listarPorUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(streamingSessionService.listarSesionesPorUsuario(idUsuario));
    }

    @GetMapping("/activas")
    public ResponseEntity<List<StreamingSession>> listarSesionesActivas() {
        return ResponseEntity.ok(streamingSessionService.listarSesionesActivas());
    }
}
