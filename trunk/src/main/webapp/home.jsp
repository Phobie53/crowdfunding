<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page pageEncoding="UTF-8" %>
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
        <link href='https://fonts.googleapis.com/css?family=Raleway|Roboto|Source+Sans+Pro:200' rel='stylesheet' type='text/css'>
    </head>
    <body>
    	<s:include value="/menu.jsp"></s:include>
    	
        <div class="slide-header">
            <div class="row">
                <div class="container">
                    <div class="boxChiffre">
                        <h1 class="titre">Contribuer à la création de projet</h1>
                        <div class="col-md-3 col-sm-3 col-xs-12 item">
                            <div style="bottom:19px" class="element">
                                <div class="info">
                                    <div class="title">100 156 €</div>
                                    <div class="desc">Don total</div>
                                </div>
                                <div class="dotted-line"></div>
                                <div class="icon-facts">
                                    <div><i class="fa fa-circle-thin" ></i></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-3 col-xs-12 item">
                            <div style="bottom:18px" class="element">
                                <div class="info">
                                    <div class="title">432</div>
                                    <div class="desc">Nombre de projet</div>
                                </div>
                                <div class="dotted-line"></div>
                                <div class="icon-facts">
                                    <div><i class="fa fa-circle-thin" ></i></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-3 col-xs-12 item">
                            <div style="bottom:72px" class="element">
                                <div class="info">
                                    <div class="title">5 600</div>
                                    <div class="desc">Contributeurs</div>
                                </div>
                                <div class="dotted-line"></div>
                                <div class="icon-facts">
                                    <div><i class="fa fa-circle-thin" ></i></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-3 col-xs-12 item">
                            <div style="bottom:1px" class="element">
                                <div class="info">
                                    <div class="title">192</div>
                                    <div class="desc">Nombre d'objectif atteint</div>
                                </div>
                                <div class="dotted-line"></div>
                                <div class="icon-facts">
                                    <div><i class="fa fa-circle-thin" ></i></div>
                                </div>
                            </div>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                </div>
            </div>
            <div class="bg-svg">
                <svg viewBox="0 0 900 140" preserveAspectRatio="none">
                <path class="fill-color fill-color1" stroke-width="0" d="M40,90 Q 190,10 340,90 t300,0 t300,0 t300,0 l0,90 l-1200,0" />
                <path class="fill-color fill-color2" stroke-width="0" d="M-230,80 Q -80,0 70,80 t300,0 t300,0 t300,0 t300,0 l0,80 l-1500,0" />
                </svg>
            </div>
        </div>
        <div class="populaire">
            <div class="row">
                <div class="container">
                    <div class="col-md-12 text">
                        COCO est le premier site de collecte de fonds dédié aux associations. Simple et sécurisé, COCO permet à toutes les associations françaises de gérer leurs adhésions, leurs dons et leurs événements. Entièrement gratuite, notre plateforme reverse 100% des montants collectés aux associations.
                    </div>
                    <div class="projetPopulaireTitre">
                        <div class="col-md-12">
                            <h2>Projets Populaires</h2>
                            <div>
                                <div class="boxItems">
                                    <s:iterator value="lesProjets" var="projet">
										<div class="col-md-4 item">
											<div class="image">
												<a href="projet?id=<s:property value="#projet.projetId" />">
													<div>
														<div class="monImage"
															style="background-image: url('<s:property value="#projet.image" />')"></div>
														<div class="hover">
															<s:set var="total" value="0" />
															<s:iterator  var="don" value="#projet.dons">
															  <s:set var="total" value="%{#total+#don.montant}" />         
															</s:iterator>
															<p><s:property value="%{#total * 100 / #projet.objectif  }" />%</p>
															<p class="sub-title">Objectif</p>
														</div>
													</div>
												</a>
											</div>
											<div class="detail">
												<h3>
													<a href="projet?id=<s:property value="#projet.projetId" />"><s:property value="#projet.nom" /></a>
												</h3>
												<div class="icons">
													<span class="entry"> <i class="fa fa-tags"></i> <a
														href="lesProjets?categorie=<s:property value="#projet.categorie.categorieId" />"><s:property value="#projet.categorie.type" /></a>
													</span> <span class="entry"> <i class="fa fa-money"></i>
														Objectif: <strong><s:property value="#projet.objectif" /> €</strong>
													</span>
												</div>
												<p class="descriptioProjet"><s:property value="#projet.presentation.substring(0,150)" /> ...</p>
											</div>
										</div>
									</s:iterator>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="carte">
            <a href="#" class="buttonCreationProjet">Créer son projet</a>
        </div>
        <div class="video">
            <video poster="image/video.png" onclick="this.play();" muted="muted">
                <source src="video/video2.mp4" type="video/mp4" />
            </video>
        </div>
        <script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script>
                $(function () {
                    $(window).on('resize', function () {
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
