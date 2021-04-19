package com.spring.foodchain.animal.vo;

import org.springframework.stereotype.Component;

@Component("roleVO")
public class roleVO {
	private String animal;
	private int rank;
	private String place;
	private int sky_ok;
	
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getSky_ok() {
		return sky_ok;
	}
	public void setSky_ok(int sky_ok) {
		this.sky_ok = sky_ok;
	}
}
