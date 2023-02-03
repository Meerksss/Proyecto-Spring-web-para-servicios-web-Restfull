package com.edix.microserviciosweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.microserviciosweb.modelo.entities.Comercial;

public interface ComercialRepository extends JpaRepository<Comercial, Integer>{

	@Query( value = "select * from comerciales where id_comercial in" + "(select id_comercial from pedidos where id_cliente = ?)", nativeQuery = true )
    List<Comercial> listaComercialesCliente(int idCliente);
	
	@Query( value = "select * from comerciales where id_comercial in (select id_comercial from pedidos)", nativeQuery = true )
    List<Comercial> comercialesConPedidos();
	
}
