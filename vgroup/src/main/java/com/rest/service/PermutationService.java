package com.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.Permutation;
import com.rest.repository.PermutationRepository;

@Service
public class PermutationService {
	private static Logger logger = LoggerFactory.getLogger(PermutationService.class);

	@Autowired
	private PermutationRepository permutationRepository;

	private List<String> permutationListData = new ArrayList<>();

	String result = "";

	public void createPermutation(Permutation permutation) {

		logger.info("Inside createPermutation method of PermutationService");
		String input1 = permutation.getInput1();
		List<String> list = permutationList(input1, result);
		list.forEach(System.out::println);
		permutation.setPermutations(list);
		permutationRepository.save(permutation);
		logger.info("Permutations saved...");
		logger.info("Exit from createPermutation method of PermutationService");
	}

	public List<String> findAllPermutationsById(Long id) {
		Optional<Permutation> permutation = permutationRepository.findById(id);
		return permutation.get().getPermutations();
	}

	public List<Permutation> findAllPermutations() {

		return permutationRepository.findAll();
	}

	private List<String> permutationList(String input1, String result) {

		if (input1.length() == 0) {
			System.out.print(result + " ");
			permutationListData.add(result);
		}

		for (int i = 0; i < input1.length(); i++) {

			// ith character of str
			char ch = input1.charAt(i);

			// Rest of the string after excluding
			// the ith character
			String ros = input1.substring(0, i) + input1.substring(i + 1);

			// Recurvise call
			permutationList(ros, result + ch);
		}
		return permutationListData;
	}
}
