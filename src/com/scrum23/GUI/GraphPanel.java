package com.scrum23.GUI;
import javax.swing.*;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import org.jgraph.JGraph;
import org.jgrapht.ext.JGraphModelAdapter;

import java.awt.*;

public class GraphPanel extends JFrame{
    private static final long serialVersionUID = 1L;
    JGraph internal;
    JFrame frame;

    public GraphPanel(org.jgrapht.Graph g){
        this.internal = new JGraph(new JGraphModelAdapter( g ));
        this.frame = new JFrame();
        frame.getContentPane().add(new JScrollPane(this.internal));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.pack();
        frame.setVisible(true);
    }

    public void Update(){

    }
}