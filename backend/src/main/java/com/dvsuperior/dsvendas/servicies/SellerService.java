package com.dvsuperior.dsvendas.servicies;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvsuperior.dsvendas.dto.SellerDTO;
import com.dvsuperior.dsvendas.entities.Seller;
import com.dvsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	public List<SellerDTO> findAll(){
		List<Seller> list = sellerRepository.findAll();
		return list.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
