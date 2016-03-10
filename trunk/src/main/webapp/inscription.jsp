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
    <body class="imageBackground">
    	<s:include value="/menu.jsp"></s:include>
        <div class="container">
            <div id="content">
                <div class="contact-sec inscription">
                    <div class="row">
                        <div class="col-md-12 col-xs-12 col-sm-12">	
                            <div class="widget-title">
                                <h3>Inscription</h3>
                            </div>
                            <div class="account-form">
                                <form class="ng-pristine ng-valid" id="formConnexion">
                                    <div class="row">
                                        <div class="feild col-md-12 col-xs-12 col-sm-12">
                                            <input type="text" placeholder="Nom" class="nameConnexion">
                                        </div>
                                        <div class="feild col-md-12 col-xs-12 col-sm-12">
                                            <input type="text" placeholder="Prenom" class="nameConnexion">
                                        </div>
                                        <div class="feild col-md-12 col-xs-12 col-sm-12">
                                            <input type="text" placeholder="Lieu" class="nameConnexion">
                                        </div>
                                        <div class="feild col-md-12 col-xs-12 col-sm-12">
                                            <input type="text" placeholder="Mail" class="nameConnexion">
                                        </div>
                                        <div class="feild col-md-12 col-xs-12 col-sm-12">
                                            <input type="password" placeholder="Mot de passe">
                                        </div>
                                        <div class="feild col-md-12 col-xs-12 col-sm-12 center">
                                            <input type="submit" value="Inscription" class="connexionButton">
                                        </div>
                                    </div>
                                </form>
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
            });
        </script>
    </body>
</html>
