package com.scrum23.importer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.alexmerz.graphviz.ParseException;
import com.alexmerz.graphviz.Parser;
import com.alexmerz.graphviz.objects.Node;
import com.scrum23.io.FileOperations;
import com.scrum23.model.Attribute;
import com.scrum23.model.Edge;
import com.scrum23.model.Graph;
import com.scrum23.model.GraphElement;
import com.scrum23.model.Vertex;

public class Importer {

	private Graph graph;
	public Parser parser;
	
	public Importer() {
		graph = new Graph();
		parser = new Parser();
	}
	
	public void identifyAttributes(String label, GraphElement element ) {
		if (label != null) {
			ReaderAttribute buffer = new ReaderAttribute(label);
			while (!buffer.eof()) {
				Attribute atr = buffer.nextAttribute();
				element.addAttribute(atr);		
			}
		}
	}
	
	public void identifyNodes(Parser parser) {
		List<Node> nodes = parser.getGraphs().get(0).getNodes(false);
		for (Node n: nodes) {	
			Vertex vertex = new Vertex();			
			identifyAttributes(n.getAttribute("label"),vertex);
			graph.addVertex((Vertex)vertex);
			Id id = new Id(); id.setId(Integer.toString(vertex.getId())); n.setId(id);
		}
	}
	
	public void identifyArcs(Parser parser) {
		for (com.alexmerz.graphviz.objects.Edge e: parser.getGraphs().get(0).getEdges()) {	
			Vertex origin = graph.getInstance(e.getSource().getNode().getId().getId());
			Vertex destiny = graph.getInstance(e.getTarget().getNode().getId().getId());
			GraphElement edge = new Edge(origin,destiny);
			identifyAttributes(e.getAttribute("label"),edge);
			graph.addEdge((Edge)edge);
		}
	}
	
	public Graph _import (String path) throws FileNotFoundException {
		try {
			FileReader fr = new FileReader(path);
			parser.parse(fr);
			identifyNodes(parser);		
			identifyArcs(parser);
		} catch (ParseException e) {e.printStackTrace();}	
		return graph;
	}
}
