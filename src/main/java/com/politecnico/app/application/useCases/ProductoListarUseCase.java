package com.politecnico.app.application.useCases;

import com.politecnico.app.domain.entities.Producto;
import com.politecnico.app.domain.repositories.IProductoRepository;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductoListarUseCase {
  private final IProductoRepository productoRepository;
  
  ProductoListarUseCase(IProductoRepository productoRepository){
    this.productoRepository = productoRepository;
  }

  public List<Producto> execute(){
    List<Producto> productos  = this.productoRepository.findAll();
    return productos;
  }

}
