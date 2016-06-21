package exportar;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Draw_Graph {
	public static void main(String[] args) {
		try {
			File dir_actual = new File(".");
			try {
				String dir = dir_actual.getCanonicalPath();
				//System.out.print(dir);
				
				//directorios de los archivos				
				String dir_exe = dir + "\\graphviz\\release\\bin\\dot.exe"; // directorio del ejecutable
				String dir_entrada = dir + "\\graph.txt"; //directorio txt del grafo
				String dir_salida = dir + "\\graph.pdf"; //directorio de salida del grafo
				
				String param_formato = "-Tpdf";		//formato de salida
				String param = "-o";	//por defecto
				
				//creacion de los comandos por consola
				
				String[] cmd = new String[5];{
				
				cmd[0] = dir_exe;		//ruta ejecutable
			    cmd[1] = param_formato; 	//formato de salida
			    cmd[2] = dir_entrada;		//ruta txt del grafo
			    cmd[3] = param;		//por defecto
			    cmd[4] = dir_salida;	//ruta de salida dl grafo
				}
				
				//ejecucion del comando
			    
			    Runtime.getRuntime().exec( cmd );
			    
			  //abre el archivo 
			    try {
		            File objetofile = new File (dir +"\\graph.pdf");
		            Desktop.getDesktop().open(objetofile);
		   
			    }catch (IOException ex) {
		            System.out.println(ex);
			    }
				
				
			} catch(Exception e) {
			       e.printStackTrace();
			}

		    
		} catch (Exception ex) {
		      ex.printStackTrace();
	    } 	
	}
}
