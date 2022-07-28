package com.example.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dao.productoDao;
import com.example.demo.model.productoModel;

@Service
public class productoServiceImplement implements productoService{

	@Autowired
	private productoDao ProductoDao;
		
	
	@Override
	@Transactional(readOnly = false)
	public productoModel save(productoModel producto) {
		// TODO Auto-generated method stub
		return ProductoDao.save(producto);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer idProducto) {
		// TODO Auto-generated method stub
		ProductoDao.deleteById(idProducto);
		
		
	}

	@Override
	@Transactional(readOnly = true)
	public productoModel findById(Integer idProducto) {
		// TODO Auto-generated method stub
		return ProductoDao.findById(idProducto).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<productoModel> findAll() {
		// TODO Auto-generated method stub
		return (List<productoModel>) ProductoDao.findAll();
	}

}
