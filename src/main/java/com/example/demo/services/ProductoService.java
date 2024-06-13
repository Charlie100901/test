package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.model.dto.ProductoDTO;
import com.example.demo.repositories.IProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private IProductoRepository iProductoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductoDTO> getAllProductos(){
        List<Producto> productos = iProductoRepository.findAll();
        return productos.stream()
        .map(producto -> modelMapper.map(producto, ProductoDTO.class))
        .collect(Collectors.toList());
    }

}
