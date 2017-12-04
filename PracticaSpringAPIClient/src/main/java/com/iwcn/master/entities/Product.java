package com.iwcn.master.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Product {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public void setYearLot(int yearLot) {
		this.yearLot = yearLot;
	}
	public void setMonthLot(int monthLot) {
		this.monthLot = monthLot;
	}
	public void setDayLot(int dayLot) {
		this.dayLot = dayLot;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String name;
	float price;
	String description;
	String size;
	String origin;
	int yearLot;
	int monthLot;
	int dayLot;
	protected Product() {}
	public long getId() {return this.id;}
	public void setId(long id) { this.id = id; }
	public Product(String name, float price, String description, String size, String origin, 
			int yearLot, int monthLot, int dayLot) {
		this.name=name;
		this.price=price;
		this.description=description;
		this.size=size;
		this.origin=origin;
		this.yearLot=yearLot;
		this.monthLot=monthLot;
		this.dayLot=dayLot;
	}
	
	public int getYearLot() {
		return yearLot;
	}
	public int getMonthLot() {
		return monthLot;
	}
	public int getDayLot() {
		return dayLot;
	}
	public String writeLot() {
		return ""+this.dayLot+"-"+this.monthLot+"-"+this.yearLot;
		}
}
