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
    <body class="projetBody">
    	<s:include value="/menu.jsp"></s:include>
        <div class="boxRecherche boxHeaderProjet">
            <div class="row">
                <div class="container">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <form method="GET" action="lesProjets">
                            <input type="hidden" name="categorie"  value="<s:property value="categorie" />" />
                            <input type="text" name="recherche" placeholder="Recherche ..." value="<s:property value="recherche" />" />
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="projetPopulaireTitre">
            <div class="row">
                <div class="container">
                    <div class="col-md-12">
                        <div class="boxItems">
                        	<s:if test="#projets">
                        		<p>Aucun résultat</p>
                        	</s:if>
							<s:else>
                             <s:iterator value="projets" var="projet">
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
													<p><s:property value="%{(#total/#projet.objectif)*100}" />%</p>
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
							</s:else>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </body>
</html>
