package com.politecnico.app.application.dtos;

public class ProductoCrearDto {
  private String nombre;
  private double precio;
  private int cantidad;

  public String getNombre() {
    return nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public int getCantidad() {
    return cantidad;
  }

  public ProductoCrearDto(){}
  
  public ProductoCrearDto(String nombre,double precio,int cantidad){
    this.nombre = nombre;
    this.precio = precio;
    this.cantidad = cantidad;
  }
}
