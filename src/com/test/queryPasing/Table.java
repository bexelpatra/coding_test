package com.test.queryPasing;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Table {

	private String name;
	private List<Search> conditions;
	private List<Order> order;
	
	public Table(String name) {
		super();
		this.name = name;
		this.conditions = new ArrayList<>();
		this.order = new ArrayList<>();
	}
	
}
