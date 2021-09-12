package fr.humanbooster.fx.burger.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.burger.business.Accompagnement;
import fr.humanbooster.fx.burger.business.Boisson;
import fr.humanbooster.fx.burger.business.Burger;
import fr.humanbooster.fx.burger.business.Commande;
import fr.humanbooster.fx.burger.business.Sauce;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * La classe IndexServlet hérite de la classe HttpServlet Toutes nos servlets
 * doivent hériter de cette super classe
 * 
 * Une servlet est une classe Java capable de traiter une requête HTTP et de
 * formuler une réponse
 * 
 */
// Annotation pour configurer la servlet dans Tomcat
// La servlet écoute sur l'url /index

@WebServlet(urlPatterns = { "/index", "/commande", "/traitemantCommande" }, loadOnStartup = 1)
public class IndexServlet extends HttpServlet {

	private static List<Integer> annees = new ArrayList<>();
	private static final List<String> mois = new ArrayList<>();
	private static final List<Burger> burgers = new ArrayList<>();
	private static final List<Accompagnement> accompagnements = new ArrayList<>();
	private static final List<Sauce> sauces = new ArrayList<>();
	private static final List<Boisson> boissons = new ArrayList<>();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		Calendar cal = Calendar.getInstance();
		int anneeEnCours = cal.get(Calendar.YEAR);

		for (int i = 0; i < 4; i++) {
			annees.add(anneeEnCours + i);
		}

		mois.add("Janvier");
		mois.add("Fevrier");
		mois.add("Mars");
		mois.add("Avril");
		mois.add("Mai");
		mois.add("Juin");
		mois.add("Juillet");
		mois.add("Aout");
		mois.add("Septembre");
		mois.add("Octobre");
		mois.add("Novembre");
		mois.add("Decembre");

		burgers.add(new Burger("Burger Guacamole", 6.5f));
		burgers.add(new Burger("Quarter-Pounder", 5.1f));
		burgers.add(new Burger("BBQ-Burger", 7f));
		burgers.add(new Burger("Cheeseburger", 2f));

		accompagnements.add(new Accompagnement("Salade", 5.5f));
		accompagnements.add(new Accompagnement("Frite", 4.5f));
		accompagnements.add(new Accompagnement("Nuggets", 4.5f));

		boissons.add(new Boisson("Badoit", 8.9f));
		boissons.add(new Boisson("Bière", 12.9f));
		boissons.add(new Boisson("Coca", 5.1f));
		boissons.add(new Boisson("Eau", 2.2f));

		sauces.add(new Sauce("Ketchup"));
		sauces.add(new Sauce("Mayonnaise"));
		sauces.add(new Sauce("Barbecue"));

	}

	private List<Sauce> getSauces(String[] sauceNom) {
		List<Sauce> sauceSelected = new ArrayList<Sauce>();

		for (Sauce sauce : sauces) {
			for (String sauce2 : sauceNom)
				if (sauce.getNom().equals(sauce2)) {
					sauceSelected.add(sauce);
				}
		}
		return sauceSelected;
	}

	private Burger getBurger(Long idBurger) {
		for (Burger burger : burgers) {
			if (burger.getId().equals(idBurger)) {
				return burger;
			}
		}
		return null;
	}

	private Accompagnement getAccompagnement(Long idAccompagnement) {
		for (Accompagnement accompagnement : accompagnements) {
			if (accompagnement.getId().equals(idAccompagnement)) {
				return accompagnement;
			}
		}
		return null;
	}

	private Boisson getBoisson(Long idBoisson) {
		Boisson boisson1 = new Boisson();
		for (Boisson boisson : boissons) {
			if (boisson.getId().equals(idBoisson)) {
				return boisson;
			}
		}
		return null;
	}

	/**
	 * Cette méthode traite une requête HTTP vers l'url /index et dont la méthode
	 * est GET
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Date() + " : nouvelle requête HTTP dont la méthode est GET");
		// request.setAttribute("mois", mois);
		// On enrichit l'objet request avec la liste des burgers
		// Cette liste sera envoyée à la vue

		request.setAttribute("burgers", burgers);
		request.setAttribute("accompagnements", accompagnements);
		request.setAttribute("sauces", sauces);
		request.setAttribute("boissons", boissons);
		request.setAttribute("mois", mois);
		request.setAttribute("annees", annees);
		

		// On fait suivre à la vue index.jsp
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Commande commande = new Commande();
		float prixTotal;

		Long idBurger = Long.parseLong(req.getParameter("BURGER"));
		Burger burgerSelected = getBurger(idBurger);
		
		Long idAccompagnement = Long.parseLong(req.getParameter("ACCOMPAGNEMENT"));
		Accompagnement accSelected = getAccompagnement(idAccompagnement);
		
		Long idBoisson = Long.parseLong(req.getParameter("BOISSON"));
		Boisson boissonSelected = getBoisson(idBoisson);
		
		Boolean type = Boolean.parseBoolean(req.getParameter("TYPE"));
		
		Byte moisS = Byte.parseByte(req.getParameter("MOIS"))  ;
		req.setAttribute("mois", mois.get(moisS));
		
		
		Integer anneesS = Integer.parseInt(req.getParameter("ANNEE"));
		req.setAttribute("annees", annees.get(anneesS));
		
		commande.setSauces(getSauces(req.getParameterValues("SAUCE")));
		commande.setBurger(burgerSelected);
		commande.setAccompagnement(accSelected);
		commande.setBoisson(boissonSelected);
		commande.setRemarque(req.getParameter("REMARQUE"));
		commande.setSurPlace(type);
		commande.setNumeroCB(req.getParameter("Numéro_CB"));
		commande.setMois(moisS);
		commande.setAnnee(anneesS);
		commande.setRemarque(req.getParameter("CODE"));
		
		prixTotal = burgerSelected.getPrix() + boissonSelected.getPrix();
		
		System.out.println(commande);
		
		
		req.setAttribute("commande", commande);
		req.setAttribute("prixTotal", prixTotal );
		
		req.getRequestDispatcher("WEB-INF/MerciCommande.jsp").forward(req, resp);
		

	}

}