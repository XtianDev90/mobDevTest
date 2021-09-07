package cl.mobdev.ejercicio.service;

import java.io.IOException;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import cl.mobdev.ejercicio.model.CharacterSchema;
import cl.mobdev.ejercicio.model.Location;
import cl.mobdev.ejercicio.model.LocationSchema;
import cl.mobdev.ejercicio.service.interfaces.ServicesApi;

@Service
public class CharacterServiceApi implements ServicesApi {
	
	/**
	 * Metodo para obtener el esquema del personaje consultado po id
	 */
	public CharacterSchema getCharacterById(Integer idCharacter) {
		CharacterSchema character = new CharacterSchema();
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		Request request = new Request.Builder()
		  .url("https://rickandmortyapi.com/api/character/" + idCharacter)
		  .method("GET", null)
		  .build();
		
		try {
			Response response = client.newCall(request).execute();
			String responseBody = response.body().string();
			// Gson
	        GsonBuilder builder = new GsonBuilder();
	        Gson gson = builder.create();;
	        character = gson.fromJson(responseBody, CharacterSchema.class);
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return character;
		
	}
	
	/**
	 * Metodo para obtener la informacion de Location a traves de la url entregada por Location del esquema del personaje
	 */
	public LocationSchema getLocationById(Location location) {
		LocationSchema locationResponse = new LocationSchema();
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		Request request = new Request.Builder()
		  .url(location.getUrl().toString())
		  .method("GET", null)
		  .build();
		
		try {
			Response response = client.newCall(request).execute();
			String responseBody = response.body().string();
			// Gson
	        GsonBuilder builder = new GsonBuilder();
	        Gson gson = builder.create();;
	        locationResponse = gson.fromJson(responseBody, LocationSchema.class);
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return locationResponse;
		
	}
}
