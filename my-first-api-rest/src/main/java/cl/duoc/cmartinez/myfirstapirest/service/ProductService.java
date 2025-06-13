package cl.duoc.cmartinez.myfirstapirest.service;

import cl.duoc.cmartinez.myfirstapirest.repository.jpa.ProductJpaRespository;
import cl.duoc.cmartinez.myfirstapirest.repository.jpa.entity.ProductJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
  @Autowired private ProductJpaRespository repository;

  public Optional<Long> saveProduct(String productName, String description) {
    Optional<ProductJpa> found = repository.findByName(productName);
    if (found.isPresent()) {
      return Optional.empty();
    }
    ProductJpa newProduct = new ProductJpa();
    newProduct.setName(productName);
    newProduct.setDescription(description);
    return Optional.of(repository.save(newProduct).getId());
  }

  public Optional<ProductJpa> getProduct(Long id) {
    return repository.findById(id);
  }

  public Optional<ProductJpa> getProduct(String productName) {
    return repository.findByName(productName);
  }

  public List<ProductJpa> getAllProducts() {
    return repository.findAll();
  }
}
