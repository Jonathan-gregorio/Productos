package com.example.demo.service;

import java.util.List;

import com.example.demo.model.productoModel;

public interface productoService {

	public productoModel  save(productoModel producto);
	public void delete(Integer idProducto);
	public productoModel findById(Integer idProducto);
	public List<productoModel> findAll();
		
}
