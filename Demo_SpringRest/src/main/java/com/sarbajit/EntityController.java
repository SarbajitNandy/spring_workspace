package com.sarbajit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entity")
public class EntityController {
		
	@Autowired
	private EnRepo enRepo;
	
	
	@GetMapping(value="/{id}")
	public String fetchCustomer(@RequestParam("query") String query, @PathVariable("id") int id) {	
		System.out.println(id + query);
		return query;
	}
	
	@GetMapping(produces="application/json")
	public List<En> fetchCustomer(@RequestParam("query") String query) {	
		System.out.println("Without path variable");
		return enRepo.getAll();
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<En> fetchCustomer(@RequestBody En en) {
		System.out.println(en);
		
		if (en.getName()==null) {
			return ResponseEntity.badRequest().build();
		}
		return new ResponseEntity<>(en, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/{roll}")
	public En delete(@PathVariable("roll") int roll) throws Exception {
		return enRepo.delete(roll);
	}
}
