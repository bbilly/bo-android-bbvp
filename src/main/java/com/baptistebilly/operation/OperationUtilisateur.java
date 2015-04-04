package com.baptistebilly.operation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.baptistebilly.model.CsvFile;
import com.baptistebilly.model.Message;
import com.baptistebilly.model.Utilisateur;

public class OperationUtilisateur {
	
	private static final String file_users = "C:/Users/Baptiste/git/bo-android-bbvp/bo-android-bbvp/src/main/java/com/baptistebilly/util/utilisateurs.csv";
	private static final String message_users = "C:/Users/Baptiste/git/bo-android-bbvp/bo-android-bbvp/src/main/java/com/baptistebilly/util/messages.csv";
	
	
	public boolean connexionUtilisateur(Utilisateur u) {
		for(Utilisateur a : this.getUtilisateurs()) {
			if(a.getLogin().equals(u.getLogin()) && a.getPassword().equals(u.getPassword()))
				return true;
		}
		return false;
	}
	
	public List<Utilisateur> getUtilisateurs() {
		File f = CsvFile.getResource(file_users);
		CsvFile csv = new CsvFile();
		List<Utilisateur> res = new ArrayList<Utilisateur>();
		try {
			List<String[]> users = csv.getData(f);
			for(String[] user : users) {
				Utilisateur u = new Utilisateur();
				u.setLogin(user[0]);
				u.setPassword(user[1]);
				res.add(u);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;		
	}
	
	public List<Message> getMessages() {
		File f = CsvFile.getResource(message_users);
		CsvFile csv = new CsvFile();
		List<Message> res = new ArrayList<Message>();
		List<String[]> messages;
		try {
			messages = csv.getData(f);
			for(String[] message : messages) {
				Message m = new Message();
				m.setMessage(message[1]);
				m.setAuteur(message[0]);
				res.add(m);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}
	
	public boolean envoyerMessage(Message m) {
		CsvFile csv = new CsvFile();
		return csv.writeCsv(message_users, m);
		
	}

}
