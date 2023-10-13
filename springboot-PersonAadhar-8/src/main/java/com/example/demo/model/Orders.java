package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderid;
	@NotNull(message = "trackingid is must")
	private String trackingid;
	@NotNull(message = "please provide Shipping Address")
	private String shippingaaddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="person_id")
	private Person person;
	
	@OneToMany(mappedBy = "orders")
	private List<Products> products=new ArrayList<>();
	
	
	public long getOrderid() {
		return orderid;
	}
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	public String getTrackingid() {
		return trackingid;
	}
	public void setTrackingid(String trackingid) {
		this.trackingid = trackingid;
	}
	public String getShippingaaddress() {
		return shippingaaddress;
	}
	public void setShippingaaddress(String shippingaaddress) {
		this.shippingaaddress = shippingaaddress;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
