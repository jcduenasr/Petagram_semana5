package com.jduenas.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jduenas.petagram.R;
import com.jduenas.petagram.adapter.MascotaAdaptador;
import com.jduenas.petagram.adapter.PerfilMascotaAdaptador;
import com.jduenas.petagram.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_perfil, container, false);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        TextView tvNombrePerfil = (TextView) v.findViewById(R.id.tvNombrePerfil);
        tvNombrePerfil.setText("Droopy");
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvPerfilMascotas);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return  v;
    }

    public PerfilMascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new PerfilMascotaAdaptador(mascotas,getActivity());
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Droopy",0,R.drawable.images));
        mascotas.add(new Mascota("Droopy",1,R.drawable.images));
        mascotas.add(new Mascota("Droopy",2,R.drawable.images));
        mascotas.add(new Mascota("Droopy",5,R.drawable.images));
        mascotas.add(new Mascota("Droopy",3,R.drawable.images));
        mascotas.add(new Mascota("Droopy",4,R.drawable.images));
        mascotas.add(new Mascota("Droopy",5,R.drawable.images));
        mascotas.add(new Mascota("Droopy",3,R.drawable.images));
        mascotas.add(new Mascota("Droopy",4,R.drawable.images));
    }
}
