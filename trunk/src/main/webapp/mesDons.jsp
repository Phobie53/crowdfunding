<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>My-Cause | Mes Dons</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="css/simple-line-icons.css" type="text/css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
	<link rel="stylesheet" href="css/style.css" type="text/css" />
	<link
		href='https://fonts.googleapis.com/css?family=Raleway|Roboto|Source+Sans+Pro:200'
		rel='stylesheet' type='text/css'>
</head>
<body class="imageBackground">
	<s:include value="/menu.jsp"></s:include>

	<div class="container boxSettingUser">
		<div class="row">
			<div class="col-md-3 col-sm-3 col-xs-12 menu">
				<ul>
					<li><a href="monCompte">Mon Compte</a></li>
					<li><a href="mesProjets">Mes Projets</a></li>
					<li class="selected"><a href="mesDons">Mes Dons</a></li>
					<li><a href="mesCommentaires">Mes Commentaires</a></li>
					<li><a href="creationProjet">Création projet</a></li>
				</ul>
			</div>
			<div class="col-md-9 col-sm-9 col-xs-12 box projetPopulaireTitre">
				<div class="boxItems">
					<s:if test="mesDons.isEmpty()">
						<p class="center padding50">Vous n'avez fait aucun don</p>
					</s:if>
					<s:else>
						<div class="row">
							<div class="col-md-3"><strong>Nom</strong></div>
							<div class="col-md-3"><strong>Montant</strong></div>
							<div class="col-md-3"><strong>Date</strong></div>
						</div>
						<s:iterator value="mesDons" var="don">
							<a href="projet?id=<s:property value="#don.projet.projetId" />">
							<div class="row">
								<div class="col-md-3"><s:property value="#don.projet.nom" /></div>
								<div class="col-md-3"><s:property value="#don.montant" />€</div>
								<div class="col-md-3"><s:property value="#don.date" /></div>
							</div>
						</a>
					</s:iterator>
					</s:else>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script>
		
	</script>
</body>
</html>