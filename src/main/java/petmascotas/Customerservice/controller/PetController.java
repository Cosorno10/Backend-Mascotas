package petmascotas.Customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petmascotas.Customerservice.model.dto.PetDto;
import petmascotas.Customerservice.service.implementations.PetServiceImpl;

import java.util.ArrayList;
import java.util.List;

//http://localhost:8094/pet/add
//http://localhost:8094/pet/get-all
//http://localhost:8094/pet/

@RestController
@RequestMapping(path = "pet")
public class PetController {

	@Autowired
	private PetServiceImpl petService;

	@PostMapping
	public ResponseEntity add(@RequestBody PetDto petDto) throws Exception {
		return ResponseEntity.ok().body(petService.add(petDto));
	}

	@PutMapping
	public ResponseEntity modify(@RequestBody PetDto petDto) throws Exception {
		return ResponseEntity.ok().body(petService.modify(petDto));
	}

	@DeleteMapping
	public ResponseEntity delete(@RequestBody PetDto petDto) throws Exception {
		return ResponseEntity.ok().body(petService.delete(petDto));
	}

	@GetMapping
	public ResponseEntity get(@RequestParam(required = false) String type, @RequestParam(required = false, defaultValue = "-1") int status  ) throws Exception {
		System.out.println(status);
		return ResponseEntity.ok().body(petService.get(type, status));
	}


	@GetMapping(value = "/types")
	public ResponseEntity getTypes() throws Exception {
		List<String> types = new ArrayList<String>();
		types.add("Perro");
		types.add("Gato");
		types.add("Loro");
		types.add("Raton");
		types.add("Caballo");
		types.add("Conejos");
		types.add("Cerdo");

		return ResponseEntity.ok().body(types);
	}

	/*
	@GetMapping(value = "/type")
	public ResponseEntity getByType(@RequestBody PetDto petDto) throws Exception {
		return ResponseEntity.ok().body(petService.getByType(petDto.getType()));
	}
	*/

}
