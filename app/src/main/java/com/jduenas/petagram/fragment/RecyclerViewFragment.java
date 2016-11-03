package com.jduenas.petagram.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jduenas.petagram.MainActivity;
import com.jduenas.petagram.R;
import com.jduenas.petagram.adapter.MascotaAdaptador;
import com.jduenas.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by jduenas on 01/11/2016.
 */

public class RecyclerViewFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        FloatingActionButton tomarFoto = (FloatingActionButton) v.findViewById(R.id.camera);
        tomarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Tomando Foto",Toast.LENGTH_SHORT).show();
            }
        });
        rvMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return  v;
    }
    public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas,getActivity());
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Coraje",0,R.drawable.mascota1));
        mascotas.add(new Mascota("Pluto",1,R.drawable.mascota2));
        mascotas.add(new Mascota("Droopy",2,R.drawable.mascota3));
    }
}
