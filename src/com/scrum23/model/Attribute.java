package com.scrum23.model;

/**
 * Created by Mariano on 17/6/2016.
 */
public class Attribute {
    private String name;
    private String value;

    public Attribute(String n, String v){
        name=n;
        value=v;
    }

    public void setName(String n){
        name=n;
    }

    public void setValue(String v){
        value=v;
    }

    public String getName(){return name;}

    public String getValue(){return value;}

    @Override
    public String toString() {
        return name+" = "+value;
    }

    public void removeAttribute() {

    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Vertex))return false;
        Attribute otherVertex = (Attribute) other;
        if((this.getName().equals(otherVertex.getName())) && (this.getValue().equals(((Attribute) other).getValue()))) return true;
        return false;
    }
}
