package com.baptistebilly.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class CsvFile {
	
	private final static char SEPARATOR = ';';
    private static final String NEW_LINE_SEPARATOR = "\n";

	private List<String> lines;
	private List<String[] > data;


    public static String getResourcePath(String fileName) {
       final File f = new File("");
       final String dossierPath = f.getAbsolutePath() + File.separator + fileName;
       return dossierPath;
   }

   public static File getResource(String fileName) {
       final String completeFileName = fileName;
       File file = new File(completeFileName);
       return file;
   }
   
   public List<String> readFile(File file) throws IOException {

       List<String> result = new ArrayList<String>();

       FileReader fr = new FileReader(file);
       BufferedReader br = new BufferedReader(fr);

       for (String line = br.readLine(); line != null; line = br.readLine()) {
           result.add(line);
       }

       br.close();
       fr.close();

       return result;
   }
   
   public List<String[]> getData(File file) throws IOException{
	   lines = this.readFile(file);

       data = new ArrayList<String[] >(lines.size());
       String sep = new Character(SEPARATOR).toString();
       for (String line : lines) {
           String[] oneData = line.split(sep);
           data.add(oneData);
       }
       return data;
   }

   public boolean writeMessageCsv(String filename, Message m) {
	   FileWriter fileWriter = null;
	  
	   try {
			fileWriter = new FileWriter(filename,true);
			fileWriter.append(m.getAuteur());
			fileWriter.append(SEPARATOR);
			fileWriter.append(m.getMessage());
			fileWriter.append(NEW_LINE_SEPARATOR);
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
				return true;
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
               e.printStackTrace();
			}
			
		}
	   return false;
	   
   }
   
   public boolean writeUtilisateurCsv(String filename, Utilisateur u) {
	   FileWriter fileWriter = null;
	  
	   try {
			fileWriter = new FileWriter(filename,true);
			fileWriter.append(u.getLogin());
			fileWriter.append(SEPARATOR);
			fileWriter.append(u.getPassword());
			fileWriter.append(NEW_LINE_SEPARATOR);
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
				return true;
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
               e.printStackTrace();
			}
			
		}
	   return false;
	   
   }
}