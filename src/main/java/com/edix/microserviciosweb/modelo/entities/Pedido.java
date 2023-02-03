package com.edix.microserviciosweb.modelo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="pedidos")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="ID_PEDIDO")
	private int idPedido;
	
	private double total;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="ID_COMERCIAL")
	private Comercial comercial;
	
	public Pedido(int idPedido, double total, Date fecha, Cliente cliente, Comercial comercial) {
		super();
		this.idPedido = idPedido;
		this.total = total;
		this.fecha = fecha;
		this.cliente = cliente;
		this.comercial = comercial;
	}

	public Pedido() {
		super();
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getIdCliente() {
		return cliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.cliente = idCliente;
	}

	public Comercial getIdComercial() {
		return comercial;
	}

	public void setIdComercial(Comercial idComercial) {
		this.comercial = idComercial;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", total=" + total + ", fecha=" + fecha + ", idCliente=" + cliente
				+ ", idComercial=" + comercial + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return idPedido == other.idPedido;
	}	
	
}
