package com.politecnico.app;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.politecnico.app.application.useCases.ProductoListarUseCase;
import com.politecnico.app.domain.entities.Producto;
import com.politecnico.app.domain.repositories.IProductoRepository;


public class ProductoListarUseCaseTest {

  @Mock IProductoRepository mockProductoRepository;

  @InjectMocks
  private ProductoListarUseCase productoListarUseCase;

  @BeforeEach
  void setUp(){
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void ProductoListarUseCase(){
    Producto producto1 = new Producto("1", "Producto1", 10.0, 100);
    Producto producto2 = new Producto("2", "Producto2", 20.0, 200);
    
    List<Producto> productos = new ArrayList<Producto>();
    productos.add(producto1);
    productos.add(producto2);

    when(mockProductoRepository.findAll()).thenReturn(productos);

    List<Producto> resultado =  productoListarUseCase.execute();

    assertEquals(productos, resultado,"la lista de productos debe conicidir");
  }
}
