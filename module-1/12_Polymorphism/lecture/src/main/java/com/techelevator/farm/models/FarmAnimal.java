package com.techelevator.farm.models;

public class FarmAnimal implements Singable {
	private String name;
	private String sound;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	// interface function implementation - getName
	public String getName() {
		return name;
	}

	// interface function implementation - getSound
	public String getSound() {
		return sound;
	}

}
