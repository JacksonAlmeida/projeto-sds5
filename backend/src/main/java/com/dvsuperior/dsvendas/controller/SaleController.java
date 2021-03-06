package com.dvsuperior.dsvendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvsuperior.dsvendas.dto.SaleDTO;
import com.dvsuperior.dsvendas.dto.SaleSucessDTO;
import com.dvsuperior.dsvendas.dto.SaleSumDTO;
import com.dvsuperior.dsvendas.servicies.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> listDTO = saleService.findAll(pageable);
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBy(){
		List<SaleSumDTO> listDTO = saleService.amountGroupedBy();
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "sucess-by-seller")
	public ResponseEntity<List<SaleSucessDTO>> sucessGroupedBy(){
		List<SaleSucessDTO> listDTO = saleService.sucessGroupedBy();
		return ResponseEntity.ok().body(listDTO);
	}
}
