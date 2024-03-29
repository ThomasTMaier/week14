package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {

	@Autowired
private	PetStoreService petStoreService ;
//log.info("This is a log line");
	@PostMapping("/pet_store")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreData httpPostRequestMap(@RequestBody PetStoreData petStoreData) {
		log.info("Creating pet store ()", petStoreData);
		petStoreService.savePetStore(petStoreData);
		return petStoreData;
		
	}
	@PutMapping("/pet_store/{petStoreId}")
	public PetStoreData UpdatePetStore(@PathVariable Long petStoreId, @RequestBody PetStoreData petStoreData) {
		petStoreData.setPetStoreId(petStoreId);
		log.info("Updating PetStore {}", petStoreData);
		return petStoreService.savePetStore(petStoreData);
	}
}
