package com.politecnico.app.application.useCases;

import org.springframework.stereotype.Service;

import com.politecnico.app.domain.repositories.IProductoRepository;

@Service
public class ProductoEliminarUseCase {
  private final IProductoRepository productoRepository;
  
  ProductoEliminarUseCase(IProductoRepository productoRepository){
    this.productoRepository = productoRepository;
  }

  public void execute(String productoId){
    this.productoRepository.deleteById(productoId);
  }
}
