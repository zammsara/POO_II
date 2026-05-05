package ni.edu.ejemplo_api.models;

/**
 * Project: ejemplo_api
 * From: ni.edu.ejemplo_api.models
 * Created by: Sara Zambrana
 * On: 04/05/2026 at 18:21
 * All rights reserved 2026.
 */
public class Producto {
    private String nombreProducto;
    private Double precio;

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Producto(String nombreProducto, Double precio) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }
}
