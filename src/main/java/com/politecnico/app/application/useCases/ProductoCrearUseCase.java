package com.politecnico.app.application.useCases;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.politecnico.app.application.dtos.ProductoCrearDto;
import com.politecnico.app.domain.entities.Producto;
import com.politecnico.app.domain.repositories.IProductoRepository;

@Service
public class ProductoCrearUseCase {

  private final IProductoRepository productoRepo;

  public ProductoCrearUseCase(IProductoRepository productoRepo) {
    this.productoRepo = productoRepo;
  }

  public Producto execute(ProductoCrearDto body){
    UUID id = UUID.randomUUID();
    Producto producto = new Producto(id.toString(), body.getNombre(), body.getPrecio(), body.getCantidad());
    this.productoRepo.create(producto);
    return producto;
  }
}
