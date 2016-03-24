<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>My-Cause | Modification Projet</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="css/simple-line-icons.css" type="text/css" />
	<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
	<link rel="stylesheet" href="css/datepicker.css" type="text/css" />
	<link rel="stylesheet" href="css/froala_editor.css">
	<link rel="stylesheet" href="css/froala_style.css">
	<link rel="stylesheet" href="css/plugins/code_view.css">
	<link rel="stylesheet" href="css/plugins/colors.css">
	<link rel="stylesheet" href="css/plugins/emoticons.css">
	<link rel="stylesheet" href="css/plugins/image_manager.css">
	<link rel="stylesheet" href="css/plugins/image.css">
	<link rel="stylesheet" href="css/plugins/line_breaker.css">
	<link rel="stylesheet" href="css/plugins/quick_insert.css">
	<link rel="stylesheet" href="css/plugins/table.css">
	<link rel="stylesheet" href="css/plugins/file.css">
	<link rel="stylesheet" href="css/plugins/char_counter.css">
	<link rel="stylesheet" href="css/plugins/video.css">
	<link rel="stylesheet" href="css/plugins/emoticons.css">
	<link rel="stylesheet" href="css/plugins/fullscreen.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css">
	
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
					<li><a href="mesDons">Mes Dons</a></li>
					<li><a href="creationProjet">Creation projet</a></li>
				</ul>
			</div>
			<div class="col-md-9 col-sm-9 col-xs-12 box  account-form">
				<s:form method="post" action="saveProjet" cssClass=""
					theme="simple" enctype="multipart/form-data">
					<p class="titre">1 - Information sur le projet</p>
					<div class="form-group">
						<label for="inputNom">Nom du projet<span class="obligatoireText">*</span></label>
						<s:textfield name="projet.nom" cssClass="form-control"
							id="inputNom" label="Nom" />
					</div>

					<div class="form-group">
						<label for="inpuDateFinCompagne">Date fin de la campagne<span class="obligatoireText">*</span></label>
						
						<s:textfield name="dateField" cssClass="form-control"
							id="inpuDateFinCompagne" label="DateFinCompagne" value="%{dateField}" autocomplete="off" />
					</div>

					<div class="form-group">
						<label for="exampleObjectif">Objectif (en euro)<span class="obligatoireText">*</span></label>
						<s:textfield name="projet.objectif"
							cssClass="form-control datepicker" id="inpuObjectif"
							label="Objectif" />
					</div>

					<div class="form-group">
						<label for="parojetPresentation">Description</label>
						<s:textarea escapeHtml="false" cssClass="boxEditionDescription" name="projet.presentation" label="Presentation" />
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Image</label>
						<s:file name="image" label="Image" />
					</div>
					
					<div class="form-group">
						<label for="projetCategorie">Catégorie<span class="obligatoireText">*</span></label> 
							<s:select label="categorieId" list="categorieTypes" cssClass="form-control" listKey="categorieId" listValue="type"
				           	name="categorieId" />
 					</div> 

					<p class="titre">2 - Ajouter des récompenses</p>
					<p class="addRecompense">
						<i class="icon-plus"></i> Ajouter une récompenses
					</p>
					<ul class="listeRecompense">
					<s:set name="i" value="0" />
						<s:iterator var="recompense" value="projet.recompenses">
							<li><i class="icon-close"></i>
								<div class="form-group">
									<label for="exampleInputEmail1">Montant (si montant
										inférieur à la somme)</label> <input type="text" class="form-control"
										value="<s:property value="%{#recompense.montant}"/>" name="recompense_montant_<s:property value="#i"/>">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Description</label> <input
										type="text" class="form-control"
										value="<s:property value="%{#recompense.description}"/>" name="recompense_description_<s:property value="#i"/>">
								</div></li>
								<s:set name="i" value="%{#i + 1}"/>
						</s:iterator>
					</ul>
					<div class="feild center">
						<s:hidden name="idProjet" value="%{projet.projetId}" />
						<s:submit value="Modifier le projet" cssClass="connexionButton" />
					</div>
				</s:form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.datepicker.js"></script>
	<script type="text/javascript" src="js/froala_editor.min.js"></script>
	<script type="text/javascript" src="js/plugins/align.min.js"></script>
	<script type="text/javascript" src="js/plugins/code_beautifier.min.js"></script>
	<script type="text/javascript" src="js/plugins/code_view.min.js"></script>
	<script type="text/javascript" src="js/plugins/colors.min.js"></script>
	<script type="text/javascript" src="js/plugins/emoticons.min.js"></script>
	<script type="text/javascript" src="js/plugins/draggable.min.js"></script>
	<script type="text/javascript" src="js/plugins/font_size.min.js"></script>
	<script type="text/javascript" src="js/plugins/font_family.min.js"></script>
	<script type="text/javascript" src="js/plugins/image.min.js"></script>
	<script type="text/javascript" src="js/plugins/image_manager.min.js"></script>
	<script type="text/javascript" src="js/plugins/line_breaker.min.js"></script>
	<script type="text/javascript" src="js/plugins/quick_insert.min.js"></script>
	<script type="text/javascript" src="js/plugins/link.min.js"></script>
	<script type="text/javascript" src="js/plugins/lists.min.js"></script>
	<script type="text/javascript" src="js/plugins/paragraph_format.min.js"></script>
	<script type="text/javascript" src="js/plugins/paragraph_style.min.js"></script>
	<script type="text/javascript" src="js/plugins/video.min.js"></script>
	<script type="text/javascript" src="js/plugins/table.min.js"></script>
	<script type="text/javascript" src="js/plugins/url.min.js"></script>
	<script type="text/javascript" src="js/plugins/emoticons.min.js"></script>
	<script type="text/javascript" src="js/plugins/file.min.js"></script>
	<script type="text/javascript" src="js/plugins/entities.min.js"></script>
	<script type="text/javascript" src="js/plugins/char_counter.min.js"></script>
	<script type="text/javascript" src="js/plugins/inline_style.min.js"></script>
	<script type="text/javascript" src="js/plugins/save.min.js"></script>
	<script type="text/javascript" src="js/plugins/fullscreen.min.js"></script>
	<script type="text/javascript" src="js/languages/fr.js"></script>
	<script>
		$(function() {
			$("#inpuDateFinCompagne").datepicker(
					{
						inline : true,
						showOtherMonths : true,
						dateFormat : 'dd/mm/yy',
						altField : "#datepicker",
						closeText : 'Fermer',
						prevText : 'Précédent',
						nextText : 'Suivant',
						currentText : 'Aujourd\'hui',
						monthNames : [ 'Janvier', 'Février', 'Mars', 'Avril',
								'Mai', 'Juin', 'Juillet', 'Août', 'Septembre',
								'Octobre', 'Novembre', 'Décembre' ],
						monthNamesShort : [ 'Janv.', 'Févr.', 'Mars', 'Avril',
								'Mai', 'Juin', 'Juil.', 'Août', 'Sept.',
								'Oct.', 'Nov.', 'Déc.' ],
						dayNames : [ 'Dimanche', 'Lundi', 'Mardi', 'Mercredi',
								'Jeudi', 'Vendredi', 'Samedi' ],
						dayNamesShort : [ 'Dim.', 'Lun.', 'Mar.', 'Mer.',
								'Jeu.', 'Ven.', 'Sam.' ],
						dayNamesMin : [ 'D', 'L', 'M', 'M', 'J', 'V', 'S' ],
						weekHeader : 'Sem.'
					}).datepicker('widget')
					.wrap('<div class="ll-skin-melon"/>');

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

			$('.boxEditionDescription').froalaEditor({
		        toolbarInline: true,
		        language: 'fr',
		        toolbarButtons: ['bold', 'italic', 'underline', 'strikeThrough', 'color', 'emoticons', '-', 'paragraphFormat', 'align', 'formatOL', 'formatUL', 'indent', 'outdent', '-', 'insertImage', 'insertLink', 'insertFile', 'insertVideo', 'undo', 'redo']
		     });
			
			$('#saveProjet').submit(function(){
            	var nbError = 0;            	
            	if($('#inputNom').val() == ''){
            		$('#inputNom').addClass('obligatoire');
            		nbError++;
            	}else{
            		$('#inputNom').removeClass('obligatoire');
            	}
            	
            	if($('#inpuDateFinCompagne').val() == ''){
            		$('#inpuDateFinCompagne').addClass('obligatoire');
            		nbError++;
            	}else{
            		$('#inpuDateFinCompagne').removeClass('obligatoire');
            	}
            	
            	if($('#inpuObjectif').val() == '' || (isNaN(parseFloat($('#inpuObjectif').val())) && !isFinite($('#inpuObjectif').val()))){
            		$('#inpuObjectif').addClass('obligatoire');
            		nbError++;
            	}else{
            		$('#inpuObjectif').removeClass('obligatoire');
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
