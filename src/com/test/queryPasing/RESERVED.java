package com.test.queryPasing;

public enum RESERVED {
	SELECT("select"),
	FROM("from"),
	WHERE("where"),
	ORDER("order by"),
	ASC("asc"),
	DESC("desc"),
	AND("and"),
	LIKE("like")
	
	;
	private String name;
	private RESERVED(String name) {
		this.name = name;
	}
}
