package com.scrum23.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

import org.apache.commons.io.FileUtils;

public class FileOperations {

	public File openFile() {
		JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccione un archivo");        
        int flag = chooser.showOpenDialog(null);
        if(flag==JFileChooser.APPROVE_OPTION){
            try {
                return (chooser.getSelectedFile());
            } catch (Exception e) {e.printStackTrace();}                 
        }
        return null;
	}
	
	public String readFile(File file) {
		String result = new String();
		if (file != null && file.canRead())
			try {
				result = FileUtils.readFileToString(file, "UTF-8");
			} catch (IOException e) {e.printStackTrace();}
		return result;
	}
	
	public void saveFile(String path, String content) {
		try {
			FileWriter file = new FileWriter(path);
			file.write(content + "\r\n");
			file.close();
		} catch (IOException e) {e.printStackTrace();}
	}
	
}

