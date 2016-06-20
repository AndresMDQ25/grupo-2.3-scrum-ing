package com.scrum23.model;

import com.scrum23.GUI.GraphPanel;
import org.jgrapht.DirectedGraph;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import java.util.Set;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Created by Mariano on 17/6/2016.
 */
public class Graph {

    private DirectedGraph internalGraph;
    private int count = 0;

    public Graph (){
        internalGraph = new DirectedAcyclicGraph(DefaultEdge.class);
    }

    public void addVertex(Vertex v){
        v.setId(count);
        internalGraph.addVertex(v);
        count++;
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

    public JScrollPane getDisplay() {
        GraphPanel test = new GraphPanel(internalGraph);
        //test.getPanel().setVisible(true);
        return test.getPanel();
    }

    @Override
    public String toString() {
        return internalGraph.toString();
    }
    public Set<Vertex> getAllVertex(){
        return internalGraph.vertexSet();
    }
    
    public Set<Edge> getOutgoingEdgesOf(Vertex v) {
        return internalGraph.outgoingEdgesOf(v);
    }
}
