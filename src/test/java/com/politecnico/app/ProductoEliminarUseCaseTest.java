package com.politecnico.app;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.politecnico.app.application.useCases.ProductoEliminarUseCase;
import com.politecnico.app.domain.repositories.IProductoRepository;

public class ProductoEliminarUseCaseTest {

  @Mock
  private IProductoRepository mockProductoRepo;

  @InjectMocks
  private ProductoEliminarUseCase productoEliminarUseCase;

  @BeforeEach
  void setUp(){
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void ProductoEliminarUseCase(){
    String proId = "abc-001";
    productoEliminarUseCase.execute(proId);
    verify(mockProductoRepo,times(1)).deleteById(proId);
  }
}
