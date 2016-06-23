package com.scrum23.exporter;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class DrawGraph {
	
	public static void generatePDF(String path) {
		
			File dir_actual = new File(".");
			try {
				String dir = dir_actual.getCanonicalPath();
				
				//directorios de los archivos				
				String dir_exe = dir + "\\graphviz\\release\\bin\\dot.exe"; // directorio del ejecutable
				String dir_entrada = path;
				String dir_salida = path + ".pdf"; //directorio de salida del grafo
				System.out.println(" 1" + dir_salida);
				
				String param_formato = "-Tpdf";		//formato de salida
				String param = "-o";	//por defecto
				
				//creacion de los comandos por consola
				
				String[] cmd = new String[5];{
				
				cmd[0] = dir_exe;		//ruta ejecutable
			    cmd[1] = param_formato; 	//formato de salida
			    cmd[2] = dir_entrada;		//ruta txt del grafo
			    cmd[3] = param;		//por defecto
			    cmd[4] = dir_salida;	//ruta de salida del grafo
				}
				
				//ejecucion del comando
			    
			    Runtime.getRuntime().exec( cmd );
			    JOptionPane.showMessageDialog(null, "Se ha generado un archivo pdf en el directorio especificado");
			} catch(Exception e) {
			       e.printStackTrace();
			}

	}
}