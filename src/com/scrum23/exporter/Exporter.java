package com.scrum23.exporter;

import java.io.File;
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
	private Hashtable<String, Attribute> atts;
	
	public boolean _export(Graph graph, String path){
		
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
		atts = v.getAtts();
		String vertex_declaration = "Node" + v.getId() + "[label = \""; 
		for(Object name_att : atts.keySet()){
			vertex_declaration += name_att + ":" + atts.get(name_att) + " ; ";
		}
		vertex_declaration = vertex_declaration.substring(0, vertex_declaration.length()-3) + "\"];" + "\r\n";
		
		return vertex_declaration;
	}
	
	public String getEdge(Edge e){
		//Node1 -> Node2 [label = "feedback"];
		atts = e.getAtts();
		String edge_declaration = "Node" + e.getOrigin().getId() + " -> " + "Node" + e.getDestiny().getId() + " [label = \"";
		for(Object name_att : atts.keySet()){
			edge_declaration += name_att + ":" + atts.get(name_att) + " ;\r\n";
		}
		edge_declaration = edge_declaration.substring(0, edge_declaration.length()-4) + "\"];" + "\r\n";
		
		
		return edge_declaration;
	}
	

	/*  PARA TESTEAR!!!!!
	public static void main(String[] args) {
		
		Graph g = new Graph();
		Vertex v1 = new Vertex();
		v1.addAttribute(new Attribute("Nombre","OPD"));
		v1.addAttribute(new Attribute("nivel", "3"));
		Vertex v2 = new Vertex();
		v2.addAttribute(new Attribute("Nombre","OPF"));
		Edge e = new Edge(v1,v2);
		e.addAttribute(new Attribute("Feedback","positivooooo"));
	    g.addVertex(v1);
	    g.addVertex(v2);
	    g.addEdge(e);
	    Exporter exp = new Exporter();
	    exp._export(g, "C:\\Users\\fravega1\\Desktop\\graph.txt"); ------- cambiar ruta
	    */
	}
}

