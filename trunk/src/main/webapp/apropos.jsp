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

	<div class="container">
		<div id="content">
			<div class="contact-sec">
				<div class="row">
					<div class="col-md-12">
						<div class="widget-title">
							<h3>Vous êtes sur la première plateforme de financement participatif dédiée aux associations</h3>
						</div>
						<div class="account-form">
							<p>Notre mission est d’offrir aux associations une solution de collecte accessible et adaptée. Notre plateforme est ouverte à toutes les associations déclarées en France.

Nous mettons à disposition des associations une palette d’outils de financement pour les aider à faire du numérique un levier pour mobiliser leurs publics et développer leurs projets. </p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script>
		$(function() {
			$(window).on('resize', function() {
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
