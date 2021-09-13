package cl.mobdev.ejercicio.out;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

//El nombre de la clase podria ser mas especifico, Character por ejemplo
public class RootSchema {

	private int id;
	private String name;
	private String status;
	private String species;
	private String type;
	//Considerar usar opciones de serializacion de jackson como JsonProperty, o spring.jackson.property-naming-strategy para serializar como snake case
	private int episode_count;
	private Origin origin;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getEpisode_count() {
		return episode_count;
	}
	public void setEpisode_count(int episode_count) {
		this.episode_count = episode_count;
	}
	public Origin getOrigin() {
		return origin;
	}
	public void setOrigin(Origin origin) {
		this.origin = origin;
	}
	
}
