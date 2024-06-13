package com.example.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.model.dto.UsuarioDTO;
import com.example.demo.repositories.IUsuarioRepository;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<UsuarioDTO> getAllUsers(){
        List<Usuario> users = iUsuarioRepository.findAll();
        return users.stream()
                    .map(user -> modelMapper.map(user, UsuarioDTO.class))
                    .collect(Collectors.toList());

    }

    public UsuarioDTO getById(Long id){
        Usuario user = iUsuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("malo"));
        return modelMapper.map(user, UsuarioDTO.class);
        
    }
    

}
