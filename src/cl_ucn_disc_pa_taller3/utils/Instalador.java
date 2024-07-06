package cl_ucn_disc_pa_taller3.utils;

import cl_ucn_disc_pa_taller3.services.ISistemaCompras;
import cl_ucn_disc_pa_taller3.services.SistemaCompras;

public class Instalador {

    private ISistemaCompras sistemaHaInstalar;

    public Instalador() {
        this.sistemaHaInstalar = new SistemaCompras();
    }

    public ISistemaCompras instalarSistema() {
        return this.sistemaHaInstalar;
    }
}
