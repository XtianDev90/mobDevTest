package cl.mobdev.ejercicio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.mobdev.ejercicio.model.CharacterSchema;
import cl.mobdev.ejercicio.service.interfaces.ServicesApi;

@SpringBootTest
class MobDevApplicationTests {
	@Autowired
	ServicesApi serviceApi;
	
	@Test
	void getCharacterById() {
		int idCharacter = 2;
		CharacterSchema character = serviceApi.getCharacterById(idCharacter);
		Assertions.assertEquals("Morty Smith", character.getName());
		Assertions.assertEquals("Alive", character.getStatus());
	}

}
