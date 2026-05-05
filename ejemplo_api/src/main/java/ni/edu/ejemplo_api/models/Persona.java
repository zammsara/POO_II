package ni.edu.ejemplo_api.models;

/**
 * Project: ejemplo_api
 * From: ni.edu.ejemplo_api.models
 * Created by: Sara Zambrana
 * On: 04/05/2026 at 18:06
 * All rights reserved 2026.
 */
public class Persona {
    private String nombre;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void put(String mensaje, String esMenorDeEdad) {

    }
}
