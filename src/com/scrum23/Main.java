package com.scrum23;

import com.scrum23.model.Attribute;
import com.scrum23.model.Edge;
import com.scrum23.model.Vertex;
import com.scrum23.model.Graph;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import org.jgraph.JGraph;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;

public class Main {

    public static void main(String[] args) {

        //CREO VÉRTICE 1 CON SUS RESPECTIVOS ATRIBUTOS
        Vertex v1 = new Vertex();
        v1.addAttribute(new Attribute("nombre","CM"));
        v1.addAttribute(new Attribute("area","soporte"));

        //CREO VÉRTICE 2 CON SUS RESPECTIVOS ATRIBUTOS
        Vertex v2 = new Vertex();
        v2.addAttribute(new Attribute("nombre","PPQA"));
        v2.addAttribute(new Attribute("area","soporte"));

        //LOS RELACIONO CON UN ARCO Y LE AGREGO UN ATRIBUTO
        Edge e1 = new Edge(v1,v2);
        e1.addAttribute(new Attribute("relacion","mulos"));

        //CREO UN GRAFO AL CUAL LE AGREGO LOS ELEMENTOS CORRESPONDIENTES
        Graph g = new Graph();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addEdge(e1);

        //IMPRIMO EL GRAFO
        System.out.println(g.toString());

    }
}
