<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>My-Cause | Connexion</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
        <link rel="stylesheet" href="css/simple-line-icons.css" type="text/css" />
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
        <link rel="stylesheet" href="css/style.css" type="text/css" />
        <link href='https://fonts.googleapis.com/css?family=Raleway|Roboto|Source+Sans+Pro:200' rel='stylesheet' type='text/css'>
    </head>
    <body class="imageBackground">
    	<s:include value="/menu.jsp"></s:include>
        <div class="container">
            <div id="content">
                <div class="contact-sec">
                    <div class="row">
                        <div class="col-md-12">	
                            <div class="widget-title">
                                <h3>Connexion</h3>
                            </div>
                            <div class="account-form">
                            
                            
	                            <s:form theme="simple" action="validerConnexion" cssClass="ng-pristine ng-valid" id="formConnexion" method="post">
                                    <div class="row">
                                        <div class="feild col-md-12">
											<s:textfield name="mailConnexion" label="mailConnexion" placeholder="Mail" cssClass="nameConnexion" />
                                        </div>
                                        <div class="feild col-md-12">
											<s:textfield type="password" name="passwordConnexion" label="passwordConnexion" placeholder="Password" cssClass="nameConnexion" />
                                        </div>
                                        <div class="feild col-md-12">
											<s:submit value="Se Connecter" cssClass="connexionButton" />
                                            <a href="inscription">Pas encore inscrit ?</a>
                                        </div>
                                    </div>
								</s:form>
                                
                                
                            </div>
                        </div>				
                    </div>
                </div>	
            </div>
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
                
                $('#formConnexion').submit(function(){
                	var nbError = 0;
                	if($('#formConnexion_mailConnexion').val() == ''){
                		$('#formConnexion_mailConnexion').addClass('obligatoire');
                		nbError++;
                	}else{
                		$('#formConnexion_mailConnexion').removeClass('obligatoire');
                	}
                	
                	if($('#formConnexion_passwordConnexion').val() == ''){
                		$('#formConnexion_passwordConnexion').addClass('obligatoire');
                		nbError++;
                	}else{
                		$('#formConnexion_passwordConnexion').removeClass('obligatoire');
                	}
                	
                	if(nbError > 0){ return false; }
                	
                });
            });
        </script>
    </body>
</html>
