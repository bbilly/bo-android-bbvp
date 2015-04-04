package com.baptistebilly;

import java.util.List;

import com.baptistebilly.model.Message;
import com.baptistebilly.model.Utilisateur;
import com.baptistebilly.operation.OperationUtilisateur;

public class Application {
	
	public static void main(String[] args){ 

		Utilisateur u = new Utilisateur();
		u.setLogin("antoine");
		u.setPassword("test");
		
	    OperationUtilisateur o = new OperationUtilisateur();
	    List<Utilisateur> users = o.getUtilisateurs();
	    for(Utilisateur us : users) {
	    	System.out.println(us.getLogin()+" "+us.getPassword());
	    }
	    Message m = new Message();
	    m.setAuteur("toto");
	    m.setMessage("fdfdfdj é&ç' ");
	    System.out.println(o.envoyerMessage(m));
	   }
	
	}
