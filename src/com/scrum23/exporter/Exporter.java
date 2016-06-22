package com.scrum23.exporter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import com.scrum23.model.Attribute;
import com.scrum23.model.Edge;
import com.scrum23.model.Graph;
import com.scrum23.model.Vertex;

public class Exporter {
	
	private String vertex_declaration = new String("digraph G {\r\n");
	private String edge_declaration = new String();
	private String graph_txt = new String();
	
	public boolean _export(Graph graph, String path) {
		
		for(Vertex v : graph.getAllVertex()){
			vertex_declaration += getVertex(v);
			
			for(Edge e :graph.getOutgoingEdgesOf(v)){
				edge_declaration += getEdge(e);
			}
		}
		
		graph_txt = vertex_declaration + edge_declaration + "}";
	
	
		try {
			FileWriter file = new FileWriter(path);
			file.write(graph_txt + "\r\n");
			file.close();
		} catch (IOException e) {e.printStackTrace();}
		
		return true;
	
	}		
	
	public String getVertex(Vertex v){
		//Node1 [label = "nombre:OPD ; area:defin ; nivel:2"];
		Hashtable<String, Attribute> atts = v.getAtts();
		String vertex_declaration = "Node" + v.getId() + "[label = \""; 
		for(Object name_att : atts.keySet()){
			vertex_declaration += name_att + ":" + atts.get(name_att) + " ; ";
		}
		vertex_declaration = vertex_declaration.substring(0, vertex_declaration.length()-3) + "\"];" + "\r\n";
		
		return vertex_declaration;
	}
	
	public String getEdge(Edge e){
		//Node1 -> Node2 [label = "feedback"];
		Hashtable<String, Attribute> atts = e.getAtts();
		String edge_declaration = "Node" + e.getOrigin().getId() + " -> " + "Node" + e.getDestiny().getId() + " [label = \"";
		for(Object name_att : atts.keySet()){
			edge_declaration += name_att + ":" + atts.get(name_att) + " ;\r\n";
		}
		edge_declaration = edge_declaration.substring(0, edge_declaration.length()-4) + "\"];" + "\r\n";		
		
		return edge_declaration;
	}
}
