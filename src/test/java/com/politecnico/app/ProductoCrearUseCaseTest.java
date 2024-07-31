package com.politecnico.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import com.politecnico.app.application.dtos.ProductoCrearDto;
import com.politecnico.app.application.useCases.ProductoCrearUseCase;
import com.politecnico.app.domain.entities.Producto;
import com.politecnico.app.domain.repositories.IProductoRepository;

public class ProductoCrearUseCaseTest {

  @Mock
  private IProductoRepository mockProductoRepository;

  @InjectMocks
  private ProductoCrearUseCase productoCrearUseCase;

  @BeforeEach
  void setUp(){
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void ProductoCrearUseCase(){
    ProductoCrearDto dto = new ProductoCrearDto("arroz",1400,1);
    productoCrearUseCase.execute(dto);
    verify(mockProductoRepository).create(any(Producto.class));
  }
}
