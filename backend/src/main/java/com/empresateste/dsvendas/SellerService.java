package com.empresateste.dsvendas;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresateste.dsvendas.dto.SellerDTO;
import com.empresateste.dsvendas.entities.Seller;
import com.empresateste.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
//Classe/Camada de Serviço
	
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll() {
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
