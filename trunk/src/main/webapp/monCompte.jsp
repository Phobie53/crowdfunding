<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>My-Cause | Projet</title>
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
					<li><a href="mesDons">Mes Dons</a></li>
					<li><a href="mesCommentaires">Mes Commentaires</a></li>
					<li><a href="creationProjet">Création projet</a></li>
				</ul>
			</div>
			<div class="col-md-9 col-sm-9 col-xs-12 box account-form">
	            <s:form theme="simple" action="modifierUtilisateur" cssClass="ng-pristine ng-valid" id="formConnexion" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Nom<span class="obligatoireText">*</span></label> 
						<s:textfield name="utilisateur.nom" label="Nom" placeholder="Nom" cssClass="form-control" />
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Prenom<span class="obligatoireText">*</span></label>
						<s:textfield name="utilisateur.prenom" label="Prenom" placeholder="Prénom" cssClass="form-control" />
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Email<span class="obligatoireText">*</span></label>
						<s:textfield name="utilisateur.email" label="Email" placeholder="Email" cssClass="form-control" />
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Changer mot de passe</label>
						<s:textfield type="password" name="passwordConnexion" placeholder="Mot de passe" cssClass="form-control" />
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Image<span class="obligatoireText">*</span></label>
						<!-- GESTION EN JAVASCRIPT DE CETTE INPUT -->
						<s:textfield type="hidden" id="inputImage" name="utilisateur.image" label="Image" cssClass="form-control" />

						<ul class="listeImage">
							<li id="image/avatar/avatar1.png"><img src="image/avatar/avatar1.png" /></li>
							<li id="image/avatar/avatar2.png"><img src="image/avatar/avatar2.png" /></li>
							<li id="image/avatar/avatar3.png"><img src="image/avatar/avatar3.png" /></li>
							<li id="image/avatar/avatar4.png"><img src="image/avatar/avatar4.png" /></li>
							<li id="image/avatar/avatar5.png"><img src="image/avatar/avatar5.png" /></li>
							<li id="image/avatar/avatar6.png"><img src="image/avatar/avatar6.png" /></li>
						</ul>
					</div>

					<div class="feild center">
						<input type="submit" value="Modifier" class="connexionButton">
					</div>

				</s:form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script>
		$(function() {
			var id_li_to_check = $('#inputImage').val();
			document.getElementById(id_li_to_check).className += " selected";

			$('.listeImage li').click(function() {
				$('.listeImage li').removeClass('selected');
				$(this).addClass('selected');
				$('#inputImage').val($(this).find('img').attr('src'));
			});
			
			$('#formConnexion').submit(function(){
            	var nbError = 0;            	
            	if($('#formConnexion_utilisateur_email').val() == ''){
            		$('#formConnexion_utilisateur_email').addClass('obligatoire');
            		nbError++;
            	}else{
            		$('#formConnexion_utilisateur_email').removeClass('obligatoire');
            	}
            	
            	if($('#formConnexion_utilisateur_prenom').val() == ''){
            		$('#formConnexion_utilisateur_prenom').addClass('obligatoire');
            		nbError++;
            	}else{
            		$('#formConnexion_utilisateur_prenom').removeClass('obligatoire');
            	}
            	
            	if($('#formConnexion_utilisateur_nom').val() == ''){
            		$('#formConnexion_utilisateur_nom').addClass('obligatoire');
            		nbError++;
            	}else{
            		$('#formConnexion_utilisateur_nom').removeClass('obligatoire');
            	}
            	
            	if(nbError > 0){ 
            		$('html, body').animate({
            			scrollTop: 0
            		}, 'slow');
            		return false;
            	}
            	
            });
		});
	</script>
</body>
</html>