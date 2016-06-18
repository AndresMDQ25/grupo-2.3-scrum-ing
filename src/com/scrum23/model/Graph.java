package com.scrum23.model;

import org.jgrapht.DirectedGraph;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import java.util.Set;

/**
 * Created by Mariano on 17/6/2016.
 */
public class Graph {

    private DirectedGraph internalGraph;

    public Graph (){
        internalGraph = new DirectedAcyclicGraph(DefaultEdge.class);
    }

    public void addVertex(Vertex v){
        internalGraph.addVertex(v);
    }

    public void addEdge(Edge e){
        try {
            internalGraph.addEdge(e.getOrigin(), e.getDestiny(), e.getAtts());
        }
        catch (Exception ex){
            System.out.println("NO SE AGREGÓ ARCO: "+e.toString()+" POR GENERAR CICLO");
        }
    }

    public void removeEdge(Vertex o, Vertex d){
        internalGraph.removeEdge(o,d);
    }

    public void removeVertex(Vertex v) {
        if (internalGraph.containsVertex(v)) {
            internalGraph.removeVertex(v);
        }
    }

    @Override
    public String toString() {
        return internalGraph.toString();
    }
}
