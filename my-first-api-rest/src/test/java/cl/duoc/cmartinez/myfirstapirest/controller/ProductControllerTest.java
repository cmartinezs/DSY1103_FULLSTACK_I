package cl.duoc.cmartinez.myfirstapirest.controller;

import cl.duoc.cmartinez.myfirstapirest.controller.request.ProductRequest;
import cl.duoc.cmartinez.myfirstapirest.controller.response.IdResponse;
import cl.duoc.cmartinez.myfirstapirest.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    @Mock
    private ProductService service;
    @InjectMocks
    private ProductController controller;

    @Test
    void getProducts() {
      }

    @Test
    void getProduct() {
      }

    @Test
    void createProduct() {
        ProductRequest request = new ProductRequest();
        request.setName("Test Product");
        request.setDescription("This is a test product.");
        Optional<Long> testReturn = Optional.of(2L);
        when(service.saveProduct(request.getName(), request.getDescription()))
                .thenReturn(testReturn);
        ResponseEntity<IdResponse> response = controller.createProduct(request);
        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
        IdResponse body = response.getBody();
        assertNotNull(body);
        assertEquals(2L, body.getId());
    }
}