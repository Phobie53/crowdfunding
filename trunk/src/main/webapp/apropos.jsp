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
							<h3>A Propos</h3>
						</div>
						<div class="account-form">Et eodem impetu Domitianum
							praecipitem per scalas itidem funibus constrinxerunt, eosque
							coniunctos per ampla spatia civitatis acri raptavere discursu.
							iamque artuum et membrorum divulsa conpage superscandentes
							corpora mortuorum ad ultimam truncata deformitatem velut
							exsaturati mox abiecerunt in flumen. Alii summum decus in
							carruchis solito altioribus et ambitioso vestium cultu ponentes
							sudant sub ponderibus lacernarum, quas in collis insertas
							cingulis ipsis adnectunt nimia subtegminum tenuitate perflabiles,
							expandentes eas crebris agitationibus <br><br>maximeque sinistra, ut
							longiores fimbriae tunicaeque perspicue luceant varietate
							liciorum effigiatae in species animalium multiformes. Nec vox
							accusatoris ulla licet subditicii in his malorum quaerebatur
							acervis ut saltem specie tenus crimina praescriptis legum
							committerentur, quod aliquotiens <br><br>fecere principes saevi: sed
							quicquid Caesaris implacabilitati sedisset, id velut fas iusque
							perpensum confestim urgebatur impleri.</div>
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
