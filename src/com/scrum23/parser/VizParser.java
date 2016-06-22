package com.scrum23.parser;

import com.scrum23.importer.Importer;
import com.scrum23.exporter.Exporter;
import com.scrum23.model.Graph;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VizParser implements ParserAbstract {

	@Override
	public boolean _export(Graph graph, String path) {
		return (new Exporter()._export(graph,path));
	}

	@Override
	public Graph _import(String path) {
            try {
                return (new Importer()._import(path));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VizParser.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
	}

}
