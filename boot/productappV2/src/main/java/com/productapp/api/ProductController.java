package com.productapp.api;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.entity.Product;
import com.productapp.service.ProductService;

@RestController
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(path = "products", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping(path = "products/{id}")
	public Product findById(@PathVariable(name = "id") int id) {
		return productService.getById(id);
	}

	@GetMapping(path = "productsV2/{id}")
	public EntityModel<Product> findByIdLink(@PathVariable(name = "id") int id) {
		Link link = linkTo(methodOn(ProductController.class).findByIdLink(id)).withSelfRel();
		Product product = productService.getById(id);
		product.add(link);
		return EntityModel.of(product);
	}

	@GetMapping(path = "productsV2")
	public CollectionModel<Product> findAllV2() {
		List<Product> products = productService.findAll();
		for (Product product : products) {
			Link link = linkTo(methodOn(ProductController.class).findByIdLink(product.getId())).withSelfRel();
			product.add(link);
		}
		return CollectionModel.of(products);
	}

	@PostMapping(path = "products")
	public ResponseEntity<Product> addProduct(@RequestBody @Valid Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
	}

	@DeleteMapping(path = "products/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable(name = "id") int id) {
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping(path = "products/{id}")
	public Product updateProduct(@PathVariable(name = "id") int id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
}
