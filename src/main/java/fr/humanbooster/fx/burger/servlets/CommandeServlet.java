package fr.humanbooster.fx.burger.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.burger.business.Commande;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(value = {"/MerciCommande"})
public class CommandeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final List<Commande> commandes = new ArrayList<>();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(new Date() + " : nouvelle requête HTTP dont la méthode est GET");
		req.setAttribute("commandes", commandes);

		req.getRequestDispatcher("WEB-INF/MerciCommande.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String commande =req.getParameter("COMMANDE");
		req.getRequestDispatcher("Votre commande" + commande).forward(req, resp);
	}
	
	







}
