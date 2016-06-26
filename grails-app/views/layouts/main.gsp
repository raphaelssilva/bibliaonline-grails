<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style type="text/css">
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
		}
		.head{
			background-image:url(${resource(dir: 'images', file: 'b_top.png')});
		}	
		
		</style>
		<title>Biblia +</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="${resource(dir: 'css/kendoui', file: 'kendo.default.min.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css/kendoui', file: 'kendo.common.min.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css/kendoui', file: 'kendo.bootstrap.min.css')}"	type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'home.css')}"	type="text/css">
		<g:javascript library="jquery"/>
		<g:layoutHead />
		<r:layoutResources />
		<%--<crumbs:resources/>
	--%></head>
	<body>
		<div class="head" id="head">
			<div class="top central" id="top">
				<div id="logo-mini">
					<img src="${resource(dir: 'images', file: 'logo-biblia-online.png')}" height="30">
				</div>
				<div class="horizontalcssmenu"
					style="float: right; position: static;">
					<%--<sec:authorize access="hasRole('ROLE_USER')">
						<g:render template="menu" />
					</sec:authorize>
				--%></div>
			</div>
		</div>
		<div class="body" id="body">
			<div class="corpo central" id="corpo">
				<div id="conteudo">
					<p style="padding: 0px 0px 0px 30px"> 
						<b><g:if test="${params.biblia}"><g:link controller="${params.biblia}">${params.biblia.toUpperCase()}</g:link></g:if>
						<g:if test="${params.livro}"> > <g:link controller="${params.biblia}" action="${params.livro}">${params.livro.toUpperCase()}</g:link></g:if> 
						<g:if test="${params.capitulo}"> > <g:link controller="${params.biblia}" action="${params.livro}" id="${params.capitulo}">${params.capitulo}</g:link></g:if> 
						<g:if test="${params.versiculo}"> > ${params.versiculo}</g:if>  </b>
					</p>
					<g:layoutBody />
					<g:render template="biblia" contextPath="/layouts"/>
				</div>
			</div>
		</div>
		<div id="base" class="base">
			<div id="rodape" class="rodape central">
				<%--<g:render template="footer" contextPath="/layouts"/>
			--%></div>
		</div>
		<g:javascript library="application" />
		<r:layoutResources />
		<script type="text/javascript" src="${resource(dir: 'js/kendoui', file: 'kendo.all.min.js')}"></script>
		<script type="text/javascript" src="${resource(dir: 'js/kendoui', file: 'jquery.min.js')}"></script>
		<script type="text/javascript" src="${resource(dir: 'js', file: 'application.js')}"></script> 
	</body>
</html>