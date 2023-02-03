package com.edix.microserviciosweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.microserviciosweb.modelo.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	@Query("Select p from Pedido p where p.comercial.idComercial = ?1")
	public List<Pedido> pedidosDeComercial(int idComercial);

	// @Query(value = "select * from pedidos where id_comercial = ?;", nativeQuery = true)
	// List<Pedido> pedidosDeComercial(int idComercial);

}
