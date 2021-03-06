package com.scrum23.model;

import com.scrum23.GUI.GraphPanel;
import java.util.ArrayList;
import org.jgrapht.DirectedGraph;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import java.util.Set;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Created by Mariano on 17/6/2016.
 */
public class Graph {

    private DirectedGraph internalGraph;
    private int count = 1;

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
            internalGraph.addEdge(e.getOrigin(), e.getDestiny(), e);
        }
        catch (Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Relación inválida: El grafo debe ser acíclico", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void removeEdge(Vertex o, Vertex d, Edge e){
        internalGraph.removeEdge(o,d);
        internalGraph.removeEdge(e);
    }

    public void removeVertex(Vertex v) {
        if (internalGraph.containsVertex(v)) {
            internalGraph.removeVertex(v);
        }
    }

    public GraphPanel getDisplay() {
        GraphPanel display = new GraphPanel(internalGraph);
        return display;
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
	
	 public Vertex getInstance(String id) {
    	for (Vertex v: this.getAllVertex())
    		if (Integer.toString(v.getId()).equals(id))
    			return v;
    	return null;
    }

    public ArrayList<Integer> getVertexIds() {
        ArrayList<Integer> currentList = new ArrayList<>();
        Set<Vertex> allVertex = this.getAllVertex();
        for (Vertex v : allVertex) {
            currentList.add(v.getId());
        }
        return currentList;
    }

    public Vertex getVertexById(int id) {
        Set<Vertex> allVertex = this.getAllVertex();
        for (Vertex v : allVertex) {
            if (v.getId() == id)
                return v;
        }
        return null;
    }

    public Edge getEdgeById(int edgeId) {
        Set<Edge> allEdges = this.getAllEdges();
        for (Edge e : allEdges) {
            if (e.getId() == edgeId)
                return e;
        }
        return null;
    }

    private Set<Edge> getAllEdges() {
        return internalGraph.edgeSet();
    }

    public void replaceEdge(Edge newEdge, Edge toEdit) {
        if (newEdge != null) {
            int id = toEdit.getId();
            this.removeEdge(toEdit.getOrigin(), toEdit.getDestiny(), toEdit);
            newEdge.setId(id);
            this.addEdge(newEdge);
        }
    }
}
