package com.scrum23.GUI;
import javax.swing.*;

import org.jgraph.JGraph;
import org.jgrapht.ext.JGraphModelAdapter;

public class GraphPanel extends JFrame{
    private static final long serialVersionUID = 1L;
    JGraph graph;
    JScrollPane panel;

    public GraphPanel(org.jgrapht.Graph g){
        this.graph = new JGraph(new JGraphModelAdapter( g ));
        graph.setConnectable(false);
        graph.setEdgeLabelsMovable(false);
        graph.setEditable(false);
        graph.setDropEnabled(false);
        this.panel = new JScrollPane(this.graph);
        //panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setMinimumSize(new Dimension(800, 600));
        //panel.pack();
        //frame.setVisible(true);
    }
    
    public JScrollPane getPanel() {
        return this.panel;
    }

    public void Update(){

    }
}