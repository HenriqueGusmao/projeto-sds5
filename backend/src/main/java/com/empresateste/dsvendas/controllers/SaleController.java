package com.empresateste.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresateste.dsvendas.SaleService;
import com.empresateste.dsvendas.dto.SaleDTO;
import com.empresateste.dsvendas.dto.SaleSuccessDTO;
import com.empresateste.dsvendas.dto.SaleSumDTO;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	//metodo para representar um endpoint que vai chamar esse caminho no navegador
	//busca paginada
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> page = service.findAll(pageable);
		return ResponseEntity.ok(page);
	}
	
	//busca agrupada pela quantidade vendida por vender
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		List<SaleSumDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	
	//busca agrupada 
		@GetMapping(value = "/success-by-seller")
		public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
			List<SaleSuccessDTO> list = service.successGroupedBySeller();
			return ResponseEntity.ok(list);
		}
}
