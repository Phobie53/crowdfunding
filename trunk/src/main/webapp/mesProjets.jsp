<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>TODO supply a title</title>
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
					<li class="selected"><a href="mesProjets">Mes Projets</a></li>
					<li><a href="creationProjet">Création projet</a></li>
				</ul>
			</div>
			<div class="col-md-9 col-sm-9 col-xs-12 box projetPopulaireTitre">
				<div class="boxItems">
				<s:iterator value="mesProjets" var="projet">
					<div class="col-md-4 item">
						<div class="image">
							<a href="modifierProjet?id=<s:property value="#projet.projetId" />">
								<div>
									<div class="monImage"
										style="background-image: url('<s:property value="#projet.image" />')"></div>
									<div class="hover">
										<p class="sub-title"><s:property value="#projet.nom" /></p>
									</div>
								</div>
							</a>
						</div>
						<div class="detail">
						
							<a href="modifierProjet?id=<s:property value="#projet.projetId" />" class="modifierProjet">Modifier
								projet</a>
						</div>
					</div>
					</s:iterator>
					
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
