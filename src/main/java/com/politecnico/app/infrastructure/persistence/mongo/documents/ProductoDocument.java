package com.politecnico.app.infrastructure.persistence.mongo.documents;

import org.springframework.data.mongodb.core.mapping.Document;

import com.politecnico.app.domain.entities.Producto;

@Document(collection = "productos")
public class ProductoDocument extends Producto {

  public ProductoDocument(String id, String nombre, double precio, int cantidad) {
    super(id, nombre, precio, cantidad);
  }

}
