package com.politecnico.app.domain.repositories;

import com.politecnico.app.domain.entities.Producto;
import java.util.List;

public interface IProductoRepository {
  void create(Producto producto);
  void deleteById(String productoId);
  List<Producto> findAll();
}
