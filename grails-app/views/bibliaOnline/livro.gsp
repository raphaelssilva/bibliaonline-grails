<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<style type="text/css">
.numeroCapitulo {
	float: left;
	width: 100%
	
}

.numeroCapitulo a span {
	font-size: 30px;
	margin: 0px 30px 0px 30px;
	position: relative;
}
</style>
</head>
<body>
	<div class="numeroCapitulo">
		<h3>Clique em um capitulo:</h3>
		<g:each in="${capitulos}" var="capitulo">
			<g:link url="${params.livro}/${capitulo}">
				<span> ${capitulo>9?capitulo:("0"+capitulo)}</span>
			</g:link>
		</g:each>
	</div>
</body>
</html>
