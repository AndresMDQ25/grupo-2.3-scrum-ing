package com.scrum23;

import com.scrum23.model.Attribute;
import com.scrum23.model.Edge;
import com.scrum23.model.Vertex;
import com.scrum23.model.Graph;
import com.scrum23.GUI.GraphPanel;


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
        v2.removeAttribute("area");

        //CREO VÉRTICE 3 CON SUS RESPECTIVOS ATRIBUTOS
        Vertex v3 = new Vertex();
        v3.addAttribute(new Attribute("nombre","OPD"));
        v3.addAttribute(new Attribute("area","asd"));

        //LOS RELACIONO A LOS ARCOS Y LE AGREGO UN ATRIBUTO
        Edge e1 = new Edge(v1,v2);
        e1.addAttribute(new Attribute("relacion","mulos"));
        Edge e2 = new Edge(v2,v3);
        e2.addAttribute(new Attribute("relacion","dk"));



        //CREO UN GRAFO AL CUAL LE AGREGO LOS ELEMENTOS CORRESPONDIENTES
        Graph g = new Graph();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);

        g.addEdge(e1);
        g.addEdge(e2);
        g.removeEdge(v1, v2);

        g.display();

        //IMPRIMO EL GRAFO
        System.out.println(g.toString());

    }
}
