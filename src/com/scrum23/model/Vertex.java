package com.scrum23.model;

import java.util.Hashtable;

/**
 * Created by Mariano on 17/6/2016.
 */
public class Vertex extends GraphElement{

    public Vertex(){
        super.atts=new Hashtable();
    }

    @Override
    public String toString() {
        return atts.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Vertex))return false;
        Vertex otherVertex = (Vertex)other;
        if(this.getAtts().equals(otherVertex.getAtts())) return true;
        return false;
    }
}
