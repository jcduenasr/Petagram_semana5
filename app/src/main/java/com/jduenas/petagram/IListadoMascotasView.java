package com.jduenas.petagram;

import com.jduenas.petagram.adapter.MascotaAdaptador;
import com.jduenas.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by jduenas on 10/11/2016.
 */

public interface IListadoMascotasView {
    void generarLinearLayoutVertical();

    MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
