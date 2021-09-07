package cl.mobdev.ejercicio.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.mobdev.ejercicio.exception.UnprocessableEntityException;
import cl.mobdev.ejercicio.model.CharacterSchema;
import cl.mobdev.ejercicio.model.LocationSchema;
import cl.mobdev.ejercicio.out.Origin;
import cl.mobdev.ejercicio.out.RootSchema;
import cl.mobdev.ejercicio.service.interfaces.ServicesApi;
import cl.mobdev.ejercicio.util.ApiValidatorImpl;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/mobdev/v1")
public class ModevRest {
	
	@Autowired
	ServicesApi serviceApi;
	
	@Autowired
	private ApiValidatorImpl validator;
	
	/**
	 * Metodo de prueba para validar la comunicacion
	 * @return
	 */
	@ApiOperation(value = "Metodo de prueba para validar la comunicacion.")
	@GetMapping(value="/ping")
	public ResponseEntity<String> ping(){
		return new ResponseEntity<>("Pong",HttpStatus.OK);
	}
	
	/**
	 * Metodo que busca un personaje particular con el id.
	 * @param idCharacter
	 * @return
	 * @throws UnprocessableEntityException
	 */
	@ApiOperation(value = "Consulta un personaje según el ID.")
	@GetMapping("/find/{idCharacter}")
	public ResponseEntity<RootSchema> getCharacterById(@PathVariable("idCharacter") Integer idCharacter) throws UnprocessableEntityException{
		RootSchema out = new RootSchema();
		
		this.validator.validatorId(idCharacter);
		CharacterSchema character = serviceApi.getCharacterById(idCharacter);
		
		LocationSchema locationRes = null;
		if(character != null) {
			locationRes = serviceApi.getLocationById(character.getLocation());
		}
		
		if(locationRes != null) {
			out = generarSalida(character, locationRes);
		}
		return new ResponseEntity<RootSchema>(out,HttpStatus.OK); 
	}
	
	/**
	 * Metodo para armar la salida de la inforamción según instrucciones.
	 * @param character
	 * @param locationRes
	 * @return
	 */
	public RootSchema generarSalida(CharacterSchema character, LocationSchema locationRes) {
		RootSchema out = new RootSchema();
		out.setId(character.getId());
		out.setName(character.getName());
		out.setStatus(character.getStatus());
		out.setSpecies(character.getSpecies());
		out.setType(character.getType());
		out.setEpisode_count(character.getEpisode().size());
		
		Origin origin = new Origin();
		origin.setName(character.getOrigin().getName());
		origin.setUrl(character.getOrigin().getUrl());
		origin.setDimension(locationRes.getDimension());
		origin.setResidents(locationRes.getResidents());
		
		out.setOrigin(origin);
		
		return out;
	}
}
