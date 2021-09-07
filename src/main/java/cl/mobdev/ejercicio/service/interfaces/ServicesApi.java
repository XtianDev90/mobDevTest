package cl.mobdev.ejercicio.service.interfaces;

import org.springframework.stereotype.Service;

import cl.mobdev.ejercicio.model.CharacterSchema;
import cl.mobdev.ejercicio.model.Location;
import cl.mobdev.ejercicio.model.LocationSchema;

@Service
public interface ServicesApi {
	
	CharacterSchema getCharacterById(Integer idCharacter);
	
	LocationSchema getLocationById(Location location);
}
