package com.jduenas.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.jduenas.petagram.R;
import com.jduenas.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by jduenas on 09/11/2016.
 */

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);
        mascotas = db.obtenerTodasLasMascotas();
        return mascotas;
    }

    public  void insertarTresMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Droopy" );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.mascota3 );
        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Pluto" );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.mascota2 );
        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Coraje" );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.mascota1 );
        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        BaseDatos db = new BaseDatos(context);
        likes = db.obtenerLikesMascota(mascota);
        return likes;
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        BaseDatos db = new BaseDatos(context);
        mascotas = db.obtenerMascotasFavoritas();
        return mascotas;
    }
}
