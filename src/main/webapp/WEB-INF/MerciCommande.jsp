<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Merci pour votre commande</title>
</head>
<body>



<label>Voici votre commande : </label> <br>
<c:choose>
<c:when test="${commande.surPlace = false }">A emporter</c:when>
<c:when test="${commande.surPlace = true }">Sur Place</c:when>
</c:choose> <br>
<label>Votre burger : </label>${commande.burger.nom}<br>
<label>Votre accompagnement :</label> ${commande.accompagnement.nom}<br>
<label>Votre boisson :</label>${commande.boisson.nom }<br>
<label>Votre sauce :</label>
<c:forEach var="sauce" items="${commande.sauces}">
${sauce.nom }<br>
</c:forEach>
<label>Remarques :</label> ${commande.remarque }<br>
<label>Le montant de votre commande est de  :</label> ${prixTotal}<label> €</label>






</body>
</html>