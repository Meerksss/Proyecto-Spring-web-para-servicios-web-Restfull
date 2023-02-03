package com.edix.microserviciosweb.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.microserviciosweb.modelo.entities.Comercial;
import com.edix.microserviciosweb.modelo.entities.Pedido;
import com.edix.microserviciosweb.modelo.services.IntComercialServices;
import com.edix.microserviciosweb.modelo.services.IntPedidoServices;

import ch.qos.logback.core.model.Model;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comercial")
public class ComercialController {

	@Autowired
	private IntComercialServices cservices;

	@Autowired
	private IntPedidoServices pservices;

	@GetMapping("/todos")
	public List<Comercial> buscarTodas() {
		return cservices.findAll();
	}

	/**
	 * El @RequestBody dice: Lo que me va a llegar es un json, me lo pasas a un
	 * objeto de esta clase. El objeto que me llega me va a llegar con el id del
	 * comercial y los demás atributos.
	 * 
	 * @return Devuelve el comercial dado de alta.
	 */
	@PostMapping("/alta")
	public Comercial darAltaComercial(@RequestBody Comercial comercial) {
		return cservices.altaComercial(comercial);
	}

	/**
	 * Como es una modificación, hay que poner @PutMapping. Esté método nos permite
	 * modificar un comercial.
	 * 
	 * @param comercial
	 * @return
	 */
	@PutMapping("/modificar")
	public Comercial modificarComercial(@RequestBody Comercial comercial) {
		return cservices.modificarComercial(comercial);
	}

	/**
	 * Los métodos de eliminar hay que devolver un boolean, pero con el JSON es
	 * complicado que el cliente lo entienda. También puede devolver un String, para
	 * que el cliente sepa si se ha eliminado o no.
	 * 
	 * @param comercial
	 * @param idComercial
	 * @return
	 */
	@DeleteMapping("/eliminar/{id}")
	public String darBajaComercial(@RequestBody Comercial comercial, @PathVariable("id") int idComercial) {
		if (cservices.eliminarComercial(idComercial))
			return "Comercial eliminado correctamente.";
		else
			return "¡ERROR! El comercial introducido no existe";
	}

	/**
	 * Lós métodos get nos devuelven siempre un valor. En este caso este método nos
	 * devuelve el comercial que coincida con el idComercial que hemos introducido
	 * por parámetro.
	 * 
	 * @param model
	 * @param idComercial
	 * @return
	 */
	@GetMapping("/uno/{id}")
	public Comercial visualizarComercial(Model model, @PathVariable("id") int idComercial) {
		return cservices.findById(idComercial);
	}

	/**
	 * Método Get nos devuelve un listado de pedidos gestionados por el comercial
	 * que coincidea con el id introducido por parámetros.
	 * 
	 * @param idCliente
	 * @return
	 */
	@GetMapping("/bycliente/{id}")
	public List<Comercial> porComercial(@PathVariable("id") int idCliente) {
		return cservices.listaComercialesCliente(idCliente);
	}

	/*
	 * Método Get que nos devuelve un listado de comerciales que hayan tenido algún
	 * pedido.
	 */
	@GetMapping("/conpedidos")
	public List<Comercial> conPedidos() {
		return this.cservices.comercialesConPedidos();
	}

	@GetMapping("/pedidos/{id}")
	public List<Pedido> verPorComercial(@PathVariable("id") int idComercial) {
		return this.pservices.pedidosDeComercial(idComercial);
	}
}
