package com.example.juliancamilomunoz.listviewex;

/**
 * Created by Xingke on 03/06/2015.
 */
public class ListaEntrada {
    private int idImagen;
    private String Nombre;
    private String NombrePila;
    private String Fecha;

    public ListaEntrada(int idImagen, String nombrePila, String nombre, String fecha) {
        this.idImagen = idImagen;
        this.NombrePila = nombrePila;
        this.Nombre = nombre;
        this.Fecha = fecha;
    }

    public String getFecha() {
        return Fecha;
    }

    public int getIdImagen() { return idImagen; }

    public String getNombre() {
        return Nombre;
    }

    public String getNombrePila() {
        return NombrePila;
    }
}
