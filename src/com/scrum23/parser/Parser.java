package com.scrum23.parser;

public class Parser {

	static public ParserAbstract format(String description) {
		switch (description) {
			case "db" : 
				return new DbParser(); 
			case "viz": 
				return new VizParser();
			default:
				throw new IllegalArgumentException("Invalid specified format");
		}
	}
}
