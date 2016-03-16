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
	<link rel="stylesheet" href="css/datepicker.css" type="text/css" />
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
					<li class="selected"><a href="creationProjet">Création
							projet</a></li>
				</ul>
			</div>
			<div class="col-md-9 col-sm-9 col-xs-12 box  account-form">
				<s:form method="post" action="saveProjet" cssClass="" theme="simple">
					<p class="titre">1 - Information sur le projet</p>
					<div class="form-group">
						<label for="inputNom">Nom du projet</label> 
						<s:textfield name="projet.nom" cssClass="form-control" id="inputNom" label="Nom"/>
					</div>

					<div class="form-group">
						<label for="inpuDateFinCompagne">Date fin de la campagne</label> 
						<s:textfield name="projet.dateFinCompagne" cssClass="form-control" id="inpuDateFinCompagne" label="DateFinCompagne" />
					</div>

					<div class="form-group">
						<label for="exampleObjectif">Objectif (en euro)</label> 
						<s:textfield name="projet.objectif" cssClass="form-control datepicker" id="inpuObjectif" label="Objectif" />
					</div>

					<div class="form-group">
						<label for="parojetPresentation">Description</label>
						<s:textarea name="projet.presentation" label="Presentation" />
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Image</label> 
						<s:file name="projet.image" label="Image"/>
					</div>
					
					<div class="form-group">
						<label for="projetCategorie">Catégorie</label> 
						<s:select label="Categorie" list="categorieTypes" cssClass="form-control" listKey="categorieId" listValue="type"
				           	name="projet.categorie" />
					</div>
					
					
					<p class="titre">2 - Ajouter des récompenses</p>
					<p class="addRecompense">
						<i class="icon-plus"></i> Ajouter une récompenses
					</p>
					<ul class="listeRecompense">
					</ul>
					<div class="feild center">
						<s:submit value="Créer projet" cssClass="connexionButton" />
					</div>
				</s:form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.datepicker.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script>
		$(function() {
			$( "#datepicker" ).datepicker({
					inline: true,
					showOtherMonths: true,
					dateFormat: 'dd/mm/yy',
					altField: "#datepicker",
				    closeText: 'Fermer',
				    prevText: 'Précédent',
				    nextText: 'Suivant',
				    currentText: 'Aujourd\'hui',
				    monthNames: ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'],
				    monthNamesShort: ['Janv.', 'Févr.', 'Mars', 'Avril', 'Mai', 'Juin', 'Juil.', 'Août', 'Sept.', 'Oct.', 'Nov.', 'Déc.'],
				    dayNames: ['Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'],
				    dayNamesShort: ['Dim.', 'Lun.', 'Mar.', 'Mer.', 'Jeu.', 'Ven.', 'Sam.'],
				    dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
				    weekHeader: 'Sem.'
				}).datepicker('widget').wrap('<div class="ll-skin-melon"/>');
			
			var nbElement = $('.listeRecompense li').length;
			$('.addRecompense')
					.click(
							function() {
								nbElement++;
								$('.listeRecompense')
										.prepend(
												'<li><i class="icon-close"></i>'
														+ '<div class="form-group">'
														+ '<label for="exampleInputEmail1">Montant (si montant inférieur à la somme)</label>'
														+ '<input type="text" class="form-control" name="recompense_montant_'+nbElement+'" >'
														+ '</div>'
														+ '<div class="form-group">'
														+ '<label for="exampleInputEmail1">Description</label>'
														+ '<input type="text" class="form-control" name="recompense_description_'+nbElement+'" >'
														+ '</div></li>');
							});

			$('.listeRecompense').on('click', '.icon-close', function() {
				$(this).parent().remove();
			});

		});
	</script>
</body>
</html>
