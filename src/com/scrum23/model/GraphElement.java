package com.scrum23.model;

import java.util.Hashtable;

/**
 * Created by Mariano on 17/6/2016.
 */
public abstract class GraphElement {

    protected Hashtable<String, Attribute> atts;

    public boolean addAttribute(Attribute a){
        if(atts.containsKey(a.getName()))
            return false;
        atts.put(a.getName(),a);
        return true;
    }

    public Hashtable getAtts(){return atts;}
}
