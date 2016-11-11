package com.jduenas.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jduenas.petagram.adapter.MascotaAdaptador;
import com.jduenas.petagram.pojo.Mascota;
import com.jduenas.petagram.presenter.IListadoMascotasFavoritasPresenter;
import com.jduenas.petagram.presenter.ListadoMascotasPresenter;

import java.util.ArrayList;

public class ListadoMascotas extends AppCompatActivity implements IListadoMascotasView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IListadoMascotasFavoritasPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_mascotas);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.toolbar);
        if (miActionBar!=null){
            setSupportActionBar(miActionBar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFav);

        presenter = new ListadoMascotasPresenter(this,this);

    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Coraje",0,R.drawable.mascota1));
        mascotas.add(new Mascota("Pluto",1,R.drawable.mascota2));
        mascotas.add(new Mascota("Droopy",2,R.drawable.mascota3));
        mascotas.add(new Mascota("Huesos",3,R.drawable.images));
        mascotas.add(new Mascota("Scooby",4,R.drawable.mascota5));
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
