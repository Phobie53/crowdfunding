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
<link rel="stylesheet" href="css/rangeSlider.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link
	href='https://fonts.googleapis.com/css?family=Raleway|Roboto|Source+Sans+Pro:200'
	rel='stylesheet' type='text/css'>
</head>
<body class="projetBodyFiche">

	<!-- GESTION DE LA PARTIE COUNT DON  -->
	<s:set var="total" value="0" />
	<s:if test="projet.dons != null && projet.dons.size() > 0">
		<s:iterator var="don" value="projet.dons">
			<s:set var="total" value="%{#total+#don.montant}" />
		</s:iterator>
	</s:if>
	<s:set var="pourcentage" value="%{#total * 100 / projet.objectif  }" />
	<s:if test="#pourcentage > 100">
		<s:set var="pourcentagePixel" value="100" />
	</s:if>
	<s:else>
		<s:set var="pourcentagePixel" value="#pourcentage" />
	</s:else>

	<s:include value="/menu.jsp"></s:include>

	<div class="boxHeaderProjet">
		<div class="row">
			<div class="container">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="boxTitre">
						<h1>
							<s:property value="projet.nom" />
						</h1>
						<div class="icons">
							<span class="entry"> <i class="fa fa-tags"></i> <a
								href="lesProjets?categorie=<s:property value="projet.categorie.categorieId" />"><s:property
										value="projet.categorie.type" /></a>
							</span>
						</div>
					</div>
					<button class="buttonFaireDonLien">Faire un don</button>
				</div>
			</div>
		</div>
	</div>
	<div class="blockInfoProjet">
		<div class="row">
			<div class="container">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="lesChiffreProjet">
						<span class="sommeActuelle"><s:property value="%{#total}" />
							€</span> <span class="jourRestant"><i class="icon-clock"></i> <s:property
								value="%{getDateEcart()}" /> <span class="luna">Jours<br>Restants
						</span></span>
					</div>
					<div class="progress">
						<div class="progress-bar progress-bar-info" role="progressbar"
							aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
							style="width: <s:property value="%{#pourcentagePixel}" />%">
							<s:property value="%{#pourcentage}" />
							%
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="project">
		<div class="row">
			<div class="container">
				<div class="col-md-8 col-sm-8 col-xs-12 description">
					<img src="<s:property value="projet.image" />" />
					<p>
						<s:property value="projet.presentation" />
					</p>
					<div class="tabs">
						<ul>
							<li role="presentation" data-value="commentaire" class="active"><a
								href="javascript:void(0);">Commentaire</a></li>
								
							<li role="presentation" data-value="contributeurs"><a
								href="javascript:void(0);">Contributeurs</a></li>
							<s:if test="getDateEcart() != 'Fini'">
								<li role="presentation" data-value="faireDon"><a
									href="javascript:void(0);">Faire un don</a></li>
							</s:if>
						</ul>
						<s:if test="getDateEcart() != 'Fini'">
							<div class="faireDon" style="display: none;">
								<s:form theme="simple" action="faireDon"
									cssClass="form-horizontal" method="post">
									<h2 class="center">Je souhaites faire un don</h2>
									<div class="inputRange">
										<s:textfield name="montant" label="montant" type="range"
											min="0" max="10000" data-rangeSlider="true" />
										<span class="valeurRange">0 €</span>
									</div>
									<div class="center">
										<s:hidden name="idProjet" value="%{projet.projetId}" />
										<s:submit value="Faire un don" cssClass="buttonDon" />
									</div>
								</s:form>
							</div>
						</s:if>
						<div class="commentaire">
							<div class="timeline">
								<s:if
									test="projet.commentaires != null && projet.commentaires.size() > 0">
									<s:iterator var="commentaire" value="projet.commentaires">
										<div class="timeline-item">
											<div class="timeline-badge">
												<img
													src="<s:property value="#commentaire.utilisateur.image" />"
													class="timeline-badge-userpic">
											</div>
											<div class="timeline-body">
												<div class="timeline-body-arrow"></div>
												<div class="timeline-body-head">
													<div class="timeline-body-head-caption">
														<span class="timeline-body-title font-blue-madison">
															<s:property value="#commentaire.utilisateur.prenom" /> <s:property
																value="#commentaire.utilisateur.nom" />
														</span> <span class="timeline-body-time font-grey-cascade">
															<s:property value="#commentaire.date" />
														</span>
													</div>

												</div>
												<div class="timeline-body-content">
													<span class="font-grey-cascade"><s:property
															value="#commentaire.description" /></span>
												</div>
											</div>
										</div>
									</s:iterator>
								</s:if>
							</div>
							<button class="ajouterCommentaire">Ajouter un
								commentaire</button>
						</div>
						<div class="contributeurs" >
						toto
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-4 col-xs-12">
					<div class="col-md-12 col-sm-12 col-xs-12 red topChiffre">
						<p class="chiffre">
							<s:property value="projet.dons.size()" />
						</p>
						<p class="sub-title">Nombre de donateur</p>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12 blue topChiffre">
						<p class="chiffre">
							<s:property value="projet.objectif" />
							€
						</p>
						<p class="sub-title">Objectif souhaité</p>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12 green topChiffre">
						<p class="chiffre">
							<s:property value="#pourcentage" />
							%
						</p>
						<p class="sub-title">Objectif atteint</p>
					</div>
					<ul class="recompense">
						<s:if
							test="projet.recompenses != null && projet.recompenses.size() > 0">
							<s:iterator var="recompense" value="projet.recompenses">
								<li class="color1">
									<p class="euro">
										<
										<s:property value="#recompense.montant" />
										€
									</p>
									<p class="description">
										<s:property value="#recompense.description" />
									</p>
								</li>
							</s:iterator>
						</s:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div aria-hidden="true" id="modalAddCommentaire" class="modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button aria-hidden="true" data-dismiss="modal" class="close"
						type="button"></button>
					<h4 class="modal-title">Ajouter un commentaire</h4>
				</div>
				<s:form theme="simple" action="saveCommentaire"
					cssClass="form-horizontal" method="post">
					<div class="modal-body">
						<s:textarea label="Commentaire" name="commentaire" id="textareaCommentaire" />
					</div>
					<div class="modal-footer">
						<s:hidden name="idProjet" value="%{projet.projetId}" />
						<button data-dismiss="modal" class="btn dark btn-outline" type="button">Fermer</button>
						<s:submit value="Ajouter" cssClass="btn green"  id="ajouterCommentaire" />
						
					</div>
				</s:form>

			</div>
		</div>
	</div>

	<script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/rangeSlider.js"></script>
	<script>
		$(function() {
			$('.tabs ul li').click(function() {
				if (!$(this).hasClass('active')) {
					$('.tabs > div').hide();
					$('.tabs > div.' + $(this).attr('data-value')).show();
					$('.tabs ul li').removeClass('active');
					$(this).addClass('active');
				}
			});

			$('.buttonFaireDonLien').click(function() {
				$('.tabs li[data-value="faireDon"]').click();
				$("html, body").animate({
					scrollTop : $('.tabs').offset().top
				}, 600);
			});

			$('.ajouterCommentaire').click(function() {
				$('#modalAddCommentaire').modal('show');
			});

			var selector = '[data-rangeSlider]';
			var elements = document.querySelectorAll(selector);
			// Example functionality to demonstrate a value feedback
			function valueOutput(element) {
				var value = element.value, output = element.parentNode
						.querySelectorAll('.valeurRange')[0];
				output.innerHTML = value + ' €';
			}
			Array.prototype.slice.call(
					document.querySelectorAll('input[type="range"]')).forEach(
					function(el) {
						el.addEventListener('input', function(e) {
							valueOutput(e.target);
						}, false);
					});
			rangeSlider.create(elements, {
				// Callback function
				onInit : function() {
				}
			});
		});
	</script>
</body>
</html>