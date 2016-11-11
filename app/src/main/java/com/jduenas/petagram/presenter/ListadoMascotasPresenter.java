package com.jduenas.petagram.presenter;

import android.content.Context;

import com.jduenas.petagram.IListadoMascotasView;
import com.jduenas.petagram.db.ConstructorMascotas;
import com.jduenas.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by jduenas on 10/11/2016.
 */

public class ListadoMascotasPresenter implements IListadoMascotasFavoritasPresenter {

    private IListadoMascotasView iListadoMascotasView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public ListadoMascotasPresenter(IListadoMascotasView iListadoMascotasView, Context context) {
        this.iListadoMascotasView = iListadoMascotasView;
        this.context = context;
        obtenerMascotasFavoritasDB();
    }

    @Override
    public void obtenerMascotasFavoritasDB() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotasFavoritas();
        mostrarMascotasFavoritasRV();
    }

    @Override
    public void mostrarMascotasFavoritasRV() {
        iListadoMascotasView.inicializarAdaptadorRV(iListadoMascotasView.crearAdaptador(mascotas));
        iListadoMascotasView.generarLinearLayoutVertical();
    }
}
