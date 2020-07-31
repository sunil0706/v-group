package com.rest.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table
public class Permutation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	@NotNull
	@Size(min = 2, max = 5)
	private String input1;
	@Column
	@NotNull
	@Size(min = 2, max = 6)
	private String input2;
	@Column
	@Size(min = 0, max = 4)
	private String input3;
	
	
	@ElementCollection
	@CollectionTable(name="permutation_all", joinColumns=@JoinColumn(name="permutation_id"))
	@Column(name="permutation")
	private List<String> permutations;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getInput1() {
		return input1;
	}
	public void setInput1(String input1) {
		this.input1 = input1;
	}
	public String getInput2() {
		return input2;
	}
	public void setInput2(String input2) {
		this.input2 = input2;
	}
	public String getInput3() {
		return input3;
	}
	public void setInput3(String input3) {
		this.input3 = input3;
	}
	public List<String> getPermutations() {
		return permutations;
	}
	public void setPermutations(List<String> permutations) {
		this.permutations = permutations;
	}
	
}
