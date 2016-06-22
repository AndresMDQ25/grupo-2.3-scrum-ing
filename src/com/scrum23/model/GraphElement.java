package com.scrum23.model;

import java.util.Hashtable;

/**
 * Created by Mariano on 17/6/2016.
 */
public abstract class GraphElement {

    protected Hashtable<String, Attribute> atts;
    protected int id;

    public boolean addAttribute(Attribute a){
        if(atts.containsKey(a.getName()))
            return false;
        atts.put(a.getName(),a);
        return true;
    }

    public void removeAttribute(String name) {
        atts.remove(name);
    }

    public void removeAtts() {
        atts.clear();
    }

    public Hashtable getAtts() {
        return atts;
    }
    
    public int getId(){
        return id;
    }
}
