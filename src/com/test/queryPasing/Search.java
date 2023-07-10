package com.test.queryPasing;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Search {

	private String col;
	private String condition;
	private boolean required;
	
	
}
