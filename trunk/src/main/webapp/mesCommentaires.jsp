<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>My-Cause | Mes Projets</title>
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
					<li><a href="mesDons">Mes Dons</a></li>
					<li class="selected"><a href="mesCommentaires">Mes
							Commentaires</a></li>
					<li><a href="creationProjet">Création projet</a></li>
				</ul>
			</div>
			<div class="col-md-9 col-sm-9 col-xs-12 box projetPopulaireTitre">
				<div class="boxItems">
					<s:if test="mesCommentaires.isEmpty()">
						<p class="center padding50">Vous n'avez aucun commentaires</p>
					</s:if>
					<s:iterator value="mesCommentaires" var="commentaire">
						<div class="commentaire">
							<div class="timeline">
								<s:if
									test="mesCommentaires != null && mesCommentaires.size() > 0">
									<s:iterator var="commentaire" value="mesCommentaires">
										<div class="timeline-item">
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
