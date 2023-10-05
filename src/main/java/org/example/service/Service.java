package org.example.service;

@org.springframework.stereotype.Service
public class Service {
    private EquipoService equipoService;
    private JugadorService jugadorService;
    private PatrocinadorService patrocinadorService;

    public Service(EquipoService equipoService, JugadorService jugadorService, PatrocinadorService patrocinadorService) {
        this.equipoService = equipoService;
        this.jugadorService = jugadorService;
        this.patrocinadorService = patrocinadorService;
    }

    public EquipoService getEquipoService() {
        return equipoService;
    }

    public JugadorService getJugadorService() {
        return jugadorService;
    }

    public PatrocinadorService getPatrocinadorService() {
        return patrocinadorService;
    }
}






