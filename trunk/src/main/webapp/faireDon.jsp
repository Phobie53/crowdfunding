<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>My-Cause | Faire Don</title>
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
						<div class="account-form">
							<s:form theme="simple" action="saveDon" id="formDon"
								method="post" cssClass="faireDon center">
								<div class="chiffreDon">
									ID projet : <span><s:property value="idProjet" /></span>
								</div>
								<div class="chiffreDon">
									Montant <span><s:property value="montant" /> €</span>
								</div>

								<div class="form-group">
									<label for="inputNom">N° de la carte</label> <input type="text"
										class="form-control" id="nCarte"/>
								</div>
								<div class="form-group">
									<label for="inputNom">Expire fin :</label> <input type="text"
										class="form-control" placeholder="mm/yy" id="expireFin"/>
								</div>
								<div class="form-group">
									<label for="inputNom">Cryptogramme visuel :</label> <input
										type="text" class="form-control" id="crypto" />
								</div>
								<s:hidden name="idProjet" value="%{idProjet}" />
								<s:hidden name="montant" value="%{montant}" />
								<s:submit value="Faire don" cssClass="buttonDon" />

							</s:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function(){
			
			$('#formDon').submit(function(){
            	var nbError = 0;            	
            	if($('#crypto').val() == ''){
            		$('#crypto').addClass('obligatoire');
            		nbError++;
            	}else{
            		$('#crypto').removeClass('obligatoire');
            	}
            	
            	if($('#expireFin').val() == ''){
            		$('#expireFin').addClass('obligatoire');
            		nbError++;
            	}else{
            		$('#expireFin').removeClass('obligatoire');
            	}
            	
            	if($('#nCarte').val() == ''){
            		$('#nCarte').addClass('obligatoire');
            		nbError++;
            	}else{
            		$('#nCarte').removeClass('obligatoire');
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
