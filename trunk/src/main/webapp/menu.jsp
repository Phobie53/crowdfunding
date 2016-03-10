<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page pageEncoding="UTF-8"%>
<s:set name="pageCurrent" value="#context['struts.actionMapping'].name"/>

<div class="header">
	<div role="navigation" class="navbar navbar-default">
		<div class="container">
			<div class="row">
				<div class="col-md-2">
					<h1 class="logo">
						<a href="home"> LOGO </a>
					</h1>
				</div>
				<div class="col-md-10 col-xs-12">
					<div class="menu-default nav-collapse">
						<s:if test="%{#pageCurrent == 'connexion' || #pageCurrent == 'inscription'}"><div class="button_donate selected"></s:if><s:else><div class="button_donate"></s:else>
							<a href="connexion"> <span
								data-hover="Connexion / Inscription">Connexion / Inscription</span>
							</a>
						</div>
						<div class="menu-container">
							<ul id="menu-main-menu" class="iw-nav-menu">
								<s:if test="%{#pageCurrent == 'home'}"><li class="selected"></s:if><s:else><li></s:else>
								<a href="home"><strong>Home</strong></a></li>
								
								<s:if test="%{#pageCurrent == 'lesProjets' || #pageCurrent == 'projet'}"><li class="selected"></s:if><s:else><li></s:else>
								<a href="lesProjets"><strong>Les projets</strong></a></li>
								
								<s:if test="%{#pageCurrent == 'apropos'}"><li class="selected"></s:if><s:else><li></s:else>
								<a href="apropos"><strong>A propos</strong></a></li>
								
								<s:if test="%{#pageCurrent == 'contact'}"><li class="selected"></s:if><s:else><li></s:else>
								<a href="contact"><strong>Contact</strong></a></li>
	
								<s:if test="%{#pageCurrent == 'connexion' || #pageCurrent == 'inscription'}"><li class="selected"></s:if><s:else><li></s:else>
								<a class="connexionInscription" href="connexion"><strong>Connexion / Inscription</strong></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>