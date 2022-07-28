package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.productoModel;
import com.example.demo.service.productoService;

@RestController
//@CrossOrigin(origins = {"ListaProd"})
@RequestMapping("/api")
public class productoController {

	@Autowired
	private productoService ProductoService;

	@PostMapping(value = "/productos", produces = "application/json")

	public productoModel save(@RequestBody productoModel ProductoModel) {
		return ProductoService.save(ProductoModel);
	}

	@CrossOrigin

	@GetMapping(value = "/productosLis", produces = "application/json")
	public List<productoModel> ProductoModel() {
		return ProductoService.findAll();
	}

	@CrossOrigin
	@GetMapping("/productosMos/{idProductos}")
	public productoModel mostrar(@PathVariable Integer idProductos) {
		return ProductoService.findById(idProductos);
	}

	@PutMapping("/productosUpdate/{idProductos}")
	public productoModel update(@RequestBody productoModel ProductoModel, @PathVariable Integer idProductos) {
		productoModel productoActual = ProductoService.findById(idProductos);

		productoActual.setName(ProductoModel.getName());
		productoActual.setDescription(ProductoModel.getDescription());
		productoActual.setAmount(ProductoModel.getAmount());

		return ProductoService.save(productoActual);
	}

	@DeleteMapping("/productosDelete/{idProductos}")
	public void delete(@PathVariable Integer idProductos) {
		ProductoService.delete(idProductos);
	}

}
