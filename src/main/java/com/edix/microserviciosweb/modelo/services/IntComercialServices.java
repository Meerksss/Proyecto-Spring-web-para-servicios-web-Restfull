package com.edix.microserviciosweb.modelo.services;

import java.util.List;

import com.edix.microserviciosweb.modelo.entities.Comercial;

public interface IntComercialServices {

	//Creamos un método para listar de todos los comerciales
	List<Comercial> findAll();
	
	//Creamos una método para devolver un comercial por su idComercial
	Comercial findById(int idComercial);
	
	//Creamos un método para dar de alta un comercial
	Comercial altaComercial(Comercial comercial);
	
	Comercial modificarComercial(Comercial comercial);
	
	//Creamos un método para eliminar un comercial por su id
	boolean eliminarComercial(int idComercial);
	
	//Creamos un método para ver todos los datos de un Comercial
	Comercial verComercial(Comercial comercial);
	
	//Creamos un método para listar todos los comerciales que han atendido al cliente con ese idCliente
	List<Comercial> listaComercialesCliente(int idCliente);
	
	//Creamos un método para listar los comerciales y los pedidos gestionados por cada uno 
	List<Comercial> comercialesConPedidos();

}