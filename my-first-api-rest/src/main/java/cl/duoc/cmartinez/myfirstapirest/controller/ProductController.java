package cl.duoc.cmartinez.myfirstapirest.controller;

import cl.duoc.cmartinez.myfirstapirest.controller.request.ProductRequest;
import cl.duoc.cmartinez.myfirstapirest.controller.response.IdResponse;
import cl.duoc.cmartinez.myfirstapirest.controller.response.ProductResponse;
import cl.duoc.cmartinez.myfirstapirest.repository.jpa.entity.ProductJpa;
import cl.duoc.cmartinez.myfirstapirest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
  @Autowired private ProductService service;

  @GetMapping
  public ResponseEntity<List<ProductResponse>> getProducts() {
    List<ProductJpa> allProducts = service.getAllProducts();

    List<ProductResponse> productResponses =
        allProducts.stream()
            .map(
                product ->
                    new ProductResponse(
                        product.getId(), product.getName(), product.getDescription()))
            .collect(Collectors.toList());

    return ResponseEntity.ok(productResponses);
  }

  @GetMapping("/{productId}")
  public ResponseEntity<ProductResponse> getProduct(@PathVariable Long productId) {
    return service
        .getProduct(productId)
        .map(
            product ->
                ResponseEntity.ok(
                    new ProductResponse(
                        product.getId(), product.getName(), product.getDescription())))
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<IdResponse> createProduct(@RequestBody ProductRequest request) {
    return service
        .saveProduct(request.getName(), request.getDescription())
        .map(id -> ResponseEntity.status(HttpStatus.CREATED).body(new IdResponse(id)))
        .orElse(ResponseEntity.badRequest().build());
  }
}
