package com.dvsuperior.dsvendas.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvsuperior.dsvendas.dto.SaleDTO;
import com.dvsuperior.dsvendas.dto.SaleSucessDTO;
import com.dvsuperior.dsvendas.dto.SaleSumDTO;
import com.dvsuperior.dsvendas.entities.Sale;
import com.dvsuperior.dsvendas.repositories.SaleRepository;
import com.dvsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageble){
		sellerRepository.findAll();
		Page<Sale> list = saleRepository.findAll(pageble);
		return list.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBy(){
		return saleRepository.amountGroupedBy();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSucessDTO> sucessGroupedBy(){
		return saleRepository.sucessGroupedBy();
	}
}
