package com.example.android.agenda;

/**
 * Created by INTEL on 10/08/2016.
 */
public class Contacto {

    private String Nombre;
    private String Mail;
    private String Telefono;

    public Contacto(String mail, String telefono, String nombre) {
        Mail = mail;
        Telefono = telefono;
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
}
