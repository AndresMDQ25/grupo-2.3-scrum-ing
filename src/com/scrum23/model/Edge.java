package com.scrum23.model;

import java.util.Hashtable;

/**
 * Created by Mariano on 17/6/2016.
 */
public class Edge extends GraphElement{
    private Vertex origin;
    private Vertex destiny;

    public Edge(Vertex o, Vertex d){
        super.atts=new Hashtable();
        origin = o;
        destiny = d;
    }

    public void setOrigin(Vertex v){
        origin=v;
    }

    public void setDestiny(Vertex v){
        destiny=v;
    }

    public Vertex getOrigin(){return origin;}

    public Vertex getDestiny(){return destiny;}

    @Override
    public String toString() {
        return origin.toString()+"->"+destiny.toString();
    }
}
