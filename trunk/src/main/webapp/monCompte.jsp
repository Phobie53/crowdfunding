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
					<li class="selected"><a href="monCompte">Mon Compte</a></li>
					<li><a href="mesProjets">Mes Projets</a></li>
					<li><a href="creationProjet">Création projet</a></li>
				</ul>
			</div>
			<div class="col-md-9 col-sm-9 col-xs-12 box account-form">
				<form class="">
					<div class="form-group">
						<label for="exampleInputEmail1">Nom</label> <input type="text"
							class="form-control" id="exampleInputEmail1" placeholder="Nom"
							value="CaSS">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Prenom</label> <input type="text"
							class="form-control" id="exampleInputEmail1" placeholder="Prenom"
							value="Adrien">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Email</label> <input type="text"
							disabled="disabled" class="form-control" id="exampleInputEmail1"
							placeholder="Email" value="girly49@hotmail.com">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Changer mot de passe</label> <input
							type="password" class="form-control" id="exampleInputEmail1"
							placeholder="Password">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Image</label>
						<!-- GESTION EN JAVASCRIPT DE CETTE INPUT -->
						<input type="hidden" class="form-control" id="inputImage"
							placeholder="image">
						<ul class="listeImage">
							<li class="selected"><img src="image/avatar/avatar1.png" /></li>
							<li><img src="image/avatar/avatar2.png" /></li>
							<li><img src="image/avatar/avatar3.png" /></li>
							<li><img src="image/avatar/avatar4.png" /></li>
							<li><img src="image/avatar/avatar5.png" /></li>
							<li><img src="image/avatar/avatar6.png" /></li>
						</ul>
					</div>

					<div class="feild center">
						<input type="submit" value="Modifier" class="connexionButton">
					</div>

				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script>
		$(function() {

			$('.listeImage li').click(function() {
				$('.listeImage li').removeClass('selected');
				$(this).addClass('selected');
				$('#inputImage').val($(this).find('img').attr('src'));
			});
		});
	</script>
</body>
</html>