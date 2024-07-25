package com.politecnico.app.infrastructure.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.politecnico.app.domain.entities.Producto;
import com.politecnico.app.domain.repositories.IProductoRepository;
import com.politecnico.app.infrastructure.persistence.mongo.documents.ProductoDocument;

@Repository
public class MongoProductoRepositoryImp implements IProductoRepository {

  private final MongoTemplate mongoTemplate;

  MongoProductoRepositoryImp(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public void create(Producto producto) {
    ProductoDocument productoDocument = new ProductoDocument(producto.getId(), producto.getNombre(),
        producto.getPrecio(), producto.getCantidad());
    this.mongoTemplate.save(productoDocument);
  }

  @Override
  public List<Producto> findAll() {
    List<ProductoDocument> productosRaw = this.mongoTemplate.find(new Query(), ProductoDocument.class);
    List<Producto> productos = new ArrayList<Producto>();
    for (ProductoDocument productoDocument : productosRaw) {
      productos.add(new Producto(productoDocument.getId(), productoDocument.getNombre(), productoDocument.getPrecio(),
          productoDocument.getCantidad()));
    }
    return productos;

  }

  @Override
  public void deleteById(String productoId) {
    Query query = new Query();
    query.addCriteria(Criteria.where("id").is(productoId));
    this.mongoTemplate.remove(query, ProductoDocument.class);
  }

}
