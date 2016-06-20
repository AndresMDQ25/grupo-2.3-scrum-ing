package com.scrum23.importer;

import com.scrum23.model.Attribute;

public class ReaderAttribute {

private StringBuffer buffer;
	
	public ReaderAttribute(String sb) {
		this.buffer = new StringBuffer(sb);
	}
	
	public boolean eof() {
		return buffer.length() == 0;
	}
	
	public String next() {
		String token = new String();
		char nextCharacter;
		while (!this.eof()) {
			nextCharacter = buffer.charAt(0);
			buffer.deleteCharAt(0);
			if (nextCharacter == ':' || nextCharacter == ';')
				return token;
			token += nextCharacter;
		}
		return token;
	}

	
	public Attribute nextAttribute() {
		
		String nameAttribute = next();
		String valueAttribute = next();
		if ( !nameAttribute.isEmpty() && !valueAttribute.isEmpty())
			return (new Attribute(nameAttribute,valueAttribute));
		return null;
	}
	
}
