<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Composez votre menu</title>
</head>
<body>
<jsp:include page="entete.jsp"></jsp:include>
	<form action="traitemantCommande" method="post">
		<div>
			<label for="emporter">A emporter</label> <input type="radio"
				name="type" value="false"> <label for="sur place">Sur
				place</label> <input type="radio" name="type" value="true"> <br>

			<label>Votre Burger </label> <select name="BURGER">
				<c:forEach var="burger" items="${burgers}">
					<option value="${burger.id}">${burger.nom}(${burger.prix}
						€)</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<label>Votre accompagnement</label> <select name="ACCOMPAGNEMENT">
				<c:forEach var="accompagnement" items="${accompagnements}">
					<option value="${accompagnement.id}">${accompagnement.nom}
						(${accompagnement.prix} €)</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<label>Votre boisson</label> <select name="BOISSON">
				<c:forEach var="boisson" items="${boissons}">
					<option value="${boisson.id}">${boisson.nom}</option>
					<label>${boisson.prix} Euros</label>
				</c:forEach>
			</select>
		</div>
		<div>
			<label>Votre Sauce :</label>
			<c:forEach var="sauce" items="${sauces}">
				<input type="checkbox" name="SAUCE" value="${sauce.nom}">${sauce.nom}
		</c:forEach>

		</div>
		<div>
			<label>Avez-vous des précisions :</label>
			<textarea name="REMARQUE" placeholder="Remarques"></textarea>
			<br>
		</div>
		<div>
			<label>Numéro CB :</label>
			<textarea name="NUM_CB" placeholder="Numéro_CB"></textarea>
		</div>
		<div>
			<label>Mois expiration</label> <select name="MOIS">
				<c:forEach items="${mois}" var="mois" varStatus="compteur">
					<option value="${compteur.count}">${mois}</option>
				</c:forEach>
			</select>
			<br>
		</div>
		<div>
			<label>Année expiration</label> <select name="ANNEE">
				<c:forEach items="${annees}" var="annees" varStatus="compteur">
					<option value="${compteur.count}">${annees}</option>
				</c:forEach>
			</select>
			<br>
			<label>Code crypto</label>
			<textarea name="CODE" placeholder="***"></textarea>
		</div>
		<div>
			<input type="submit" value="commande" name="commande">
		</div>
	</form>

<jsp:include page="piedDePage.jsp"/>
</body>
</html>