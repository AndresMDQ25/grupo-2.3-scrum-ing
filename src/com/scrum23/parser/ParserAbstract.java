package com.scrum23.parser;

import com.scrum23.model.Graph;

public interface ParserAbstract {

	public abstract boolean _export(Graph graph, String path);
	public abstract Graph _import(String path);
	
}
