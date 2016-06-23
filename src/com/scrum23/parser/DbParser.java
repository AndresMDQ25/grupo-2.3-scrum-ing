package com.scrum23.parser;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.scrum23.model.Attribute;
import com.scrum23.model.Edge;
import com.scrum23.model.Graph;
import com.scrum23.model.Vertex;
import com.scrum23.services.MongoService;
import org.bson.*;
import org.bson.types.ObjectId;
import org.w3c.dom.Attr;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

public class DbParser implements ParserAbstract {
	private MongoCollection<BsonDocument> dbCollection;
	private BsonDocument document = new BsonDocument();

	public DbParser(){
		this.dbCollection = MongoService.getInstance().getDb().getCollection("Grafos", BsonDocument.class);
	}

	@Override
	public boolean _export(Graph graph, String path) {
		document.append("name", new BsonString(path));

		BsonArray vertex = new BsonArray();
		BsonArray edges = new BsonArray();

		for(Vertex v : graph.getAllVertex()){
			vertex.asArray().add( _exportVertex(v) );

			for(Edge e :graph.getOutgoingEdgesOf(v)){
				edges.asArray().add( _exportEdge(e) );
			}
		}

		document.append("vertex",vertex).append("edges",edges);

		this.dbCollection.insertOne(document);

		return true;
	}

	@Override
	public Graph _import(String path) {
		// Return graph from db
		BsonDocument search = new BsonDocument("name",new BsonString(path));
		BsonDocument graph = this.dbCollection.find(search).first();

		// New graph to be returned by the function
		Graph imported = new Graph();

		// Vertex & Attributes
		BsonArray vertexArray = graph.getArray("vertex");
		// For each vertex object in the array of vertex
		for(BsonValue vertex : vertexArray.getValues()){
			BsonDocument vertexObject = (BsonDocument)vertex;
			// Get id
			BsonInt32 id = vertexObject.getInt32("id");
			Vertex v = new Vertex();
			v.setId(id.getValue());

			// Get attributes
			BsonDocument attributes = vertexObject.getDocument("attributes");
			for( String name : attributes.keySet() ){
				BsonString value = attributes.getString(name);
				Attribute att = new Attribute(name, value.getValue());
				v.addAttribute(att);
			}

			imported.addVertex(v);
		}

		// Edges & Attributes
		BsonArray edgeArray = graph.getArray("edges");
		// For each vertex object in the array of vertex
		for(BsonValue edge : edgeArray.getValues()){
			BsonDocument edgeObject = (BsonDocument)edge;
			// Get Id
			//
			// No necesitamos recuperar el id en este caso
			// BsonInt32 id = edgeObject.getInt32("id");

			// Get origin and destiny
			BsonInt32 from = edgeObject.getInt32("from");
			BsonInt32 to = edgeObject.getInt32("to");

			Vertex origin = imported.getVertexById(from.getValue());
			Vertex destiny = imported.getVertexById(to.getValue());

			Edge e = new Edge(origin, destiny);


			// Get attributes
			BsonDocument attributes = edgeObject.getDocument("attributes");
			for( String name : attributes.keySet() ){
				BsonString value = attributes.getString(name);
				Attribute att = new Attribute(name, value.getValue());
				e.addAttribute(att);
			}

			imported.addEdge(e);
		}


		return imported;
	}


	private BsonDocument _exportVertex(Vertex v){

		BsonDocument vertex = new BsonDocument();
		Hashtable<String,Attribute> hashAtts = v.getAtts();
		vertex.append("id", new BsonInt32(v.getId()));

		BsonDocument attributes = new BsonDocument();

		for(String name_att : hashAtts.keySet()){
			Attribute att = hashAtts.get(name_att);
			attributes.append(att.getName(), new BsonString(att.getValue()));
		}

		vertex.append("attributes",attributes);

		return vertex;
	}

	private BsonDocument _exportEdge(Edge e){

		BsonDocument edge = new BsonDocument();
		Hashtable<String,Attribute> hashAtts = e.getAtts();
		edge.append("id", new BsonInt32(e.getId()));
		edge.append("from", new BsonInt32(e.getOrigin().getId()));
		edge.append("to", new BsonInt32(e.getDestiny().getId()));

		BsonDocument attributes = new BsonDocument();

		for(String name_att : hashAtts.keySet()){
			Attribute att = hashAtts.get(name_att);
			attributes.append(att.getName(), new BsonString(att.getValue()));
		}

		edge.append("attributes",attributes);

		return edge;
	}

}
