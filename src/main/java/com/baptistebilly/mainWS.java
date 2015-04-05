package com.baptistebilly;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.baptistebilly.model.Message;
import com.baptistebilly.model.Utilisateur;
import com.baptistebilly.operation.OperationUtilisateur;

@Path("/")
public class mainWS {
	
	OperationUtilisateur op = new OperationUtilisateur();
	
	 @GET
	 @Path("connect/{pseudo}/{password}")
	 @Produces(MediaType.TEXT_PLAIN)
	 public boolean connexion(@PathParam("pseudo") String pseudo, @PathParam("password") String password) {
		Utilisateur u = new Utilisateur();
		u.setLogin(pseudo);
		u.setPassword(password);
		return op.connexionUtilisateur(u);
	}
	 
	@GET
	@Path("messages")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return op.getMessages();
	}
	

	 @GET
	 @Path("envoyer/{pseudo}/{password}/{message}")
	 @Produces(MediaType.TEXT_PLAIN)
	 public boolean envoyerMessage(@PathParam("pseudo") String pseudo, @PathParam("password") String password, @PathParam("message") String message) {
		 Utilisateur u = new Utilisateur();
		 u.setLogin(pseudo);
		 u.setPassword(password);
		 if(op.connexionUtilisateur(u)) {
			 Message m = new Message();
			 m.setAuteur(pseudo);
			 m.setMessage(message);
			 return op.envoyerMessage(m);
		 }
		 else
			 return false;
	 }
	 
	 @POST
	 @Path("enregistrer")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Produces(MediaType.APPLICATION_JSON)
	 public boolean creerUtilisateur(@FormParam("login") String login, @FormParam("password") String password) {
		Utilisateur u = new Utilisateur();
		u.setLogin(login);
		u.setPassword(password);
		return op.ajoutUtilisateur(u);
	 }
}