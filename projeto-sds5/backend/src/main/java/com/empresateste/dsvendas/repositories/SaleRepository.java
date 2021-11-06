package com.empresateste.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresateste.dsvendas.dto.SaleSuccessDTO;
import com.empresateste.dsvendas.dto.SaleSumDTO;
import com.empresateste.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	//Camada de acesso aos dados

	@Query("SELECT new com.empresateste.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.empresateste.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
}
