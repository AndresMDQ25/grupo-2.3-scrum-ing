package com.scrum23.model;

import org.jgrapht.DirectedGraph;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

/**
 * Created by Mariano on 17/6/2016.
 */
public class Graph {

    private DirectedGraph internalGraph;

    public Graph (){
        internalGraph = new DefaultDirectedGraph<Vertex,DefaultEdge>(DefaultEdge.class);
    }

    public void addVertex(Vertex v){
        internalGraph.addVertex(v);
    }

    public void addEdge(Edge e){
        internalGraph.addEdge(e.getOrigin(),e.getDestiny(), e.getAtts());
    }


    @Override
    public String toString() {
        return internalGraph.toString();
    }
}
