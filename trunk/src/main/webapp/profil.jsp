<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>My-Cause | A propos</title>
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

	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2 col-sm-12 col-xs-12">
				<div class="utilisateur">
					<div class="bleu">
						<img src="<s:property value="utilisateur.image" />" />
					</div>
					<div class="content">
						<p><strong>Nom : </strong> <s:property value="utilisateur.nom" /></p>
						<p><strong>Prenom : </strong> <s:property value="utilisateur.prenom" /></p>
						<p><strong>Nombre de don : </strong> <s:property value="utilisateur.don.size()" /></p>
						<p><strong>Nombre de commentaire : </strong> <s:property value="utilisateur.commentaire.size()" /></p>
						<p><strong>Nombre de projet : </strong> <s:property value="utilisateur.projet.size()" /></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script>
		$(function() {
			$(window).on('resize', function() {
				var heigth = window.innerHeight;
				if (heigth < 500) {
					heigth = 400;
				}
				$('.slide-header').css('height', heigth);
			});
			$(window).trigger('resize');
		});
	</script>
</body>
</html>

