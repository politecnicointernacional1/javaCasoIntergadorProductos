package com.politecnico.app.infrastructure.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.politecnico.app.application.dtos.ProductoCrearDto;
import com.politecnico.app.application.useCases.ProductoCrearUseCase;
import com.politecnico.app.application.useCases.ProductoEliminarUseCase;
import com.politecnico.app.application.useCases.ProductoListarUseCase;
import com.politecnico.app.domain.entities.Producto;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProductoController {

  private final ProductoCrearUseCase productoCrearUseCase;
  private final ProductoListarUseCase productoListarUseCase;
  private final ProductoEliminarUseCase productoEliminarUseCase;

  public ProductoController(ProductoCrearUseCase productoCrearUseCase, ProductoListarUseCase productoListarUseCase,
      ProductoEliminarUseCase productoEliminarUseCase) {
    this.productoCrearUseCase = productoCrearUseCase;
    this.productoListarUseCase = productoListarUseCase;
    this.productoEliminarUseCase = productoEliminarUseCase;
  }

  @PostMapping("/api/producto")
  public Producto crear(@RequestBody ProductoCrearDto body) {
    Producto producto = this.productoCrearUseCase.execute(body);
    return producto;
  }

  @GetMapping("/api/producto")
  public List<Producto> listar(@RequestParam String param) {
    List<Producto> productos = this.productoListarUseCase.execute();
    return productos;
  }

  @DeleteMapping("/api/producto/{id}")
  public String eliminar(@PathVariable String id){
    this.productoEliminarUseCase.execute(id);
    return "producto eliminado";
  }

}
