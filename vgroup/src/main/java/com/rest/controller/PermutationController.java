package com.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Permutation;
import com.rest.service.PermutationService;

@RestController
@Validated
@RequestMapping("/rest/security")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PermutationController {
	
	@Autowired
	private PermutationService permutationService;
	
	private static final Logger logger = LoggerFactory.getLogger(PermutationController.class);
	
	@PostMapping("/permutation")
	public ResponseEntity createPermutation(@Valid @RequestBody Permutation permutation) {
		
		logger.info("Inside createPermutation method of Permutation controller");
		String input1 = permutation.getInput1();
		System.out.println("Input1 : "+input1);
		permutationService.createPermutation(permutation);
		logger.info("Exit from createPermutation method of Permutation controller");
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/permutation/{id}")
	public ResponseEntity findPermutationById(@PathVariable("id") Long id){
		
		logger.info("Inside findPermutationById method of Permutation controller");
		List<String> permutations = permutationService.findAllPermutationsById(id);
		permutations.forEach(System.out::println);
		logger.info("Exit from findPermutation method of Permutation controller");
		
		return ResponseEntity.accepted().body(permutations);
	}
	@GetMapping("/permutations")
	public ResponseEntity findAllPermutations(){
		
		logger.info("Inside findAllPermutation method of Permutation controller");
		List<Permutation> permutations = permutationService.findAllPermutations();
		permutations.forEach(System.out::println);
		logger.info("Exit from findAllPermutation method of Permutation controller");
		
		return ResponseEntity.accepted().body(permutations);
	}
}
