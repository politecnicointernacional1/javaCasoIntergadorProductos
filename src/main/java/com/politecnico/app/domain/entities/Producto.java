package com.politecnico.app.domain.entities;

public class Producto {
  private String id;
  private String nombre;
  private double precio;
  private int cantidad;
  
  public String getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public int getCantidad() {
    return cantidad;
  }

  public Producto(String id, String nombre, double precio, int cantidad) {
    this.id = id;
    this.nombre = nombre;
    this.precio = precio;
    this.cantidad = cantidad;
  }
}
