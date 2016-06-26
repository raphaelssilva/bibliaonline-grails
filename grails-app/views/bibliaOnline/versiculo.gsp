<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<style type="text/css">
.textoVersiculo{
	padding: 20px
}

.textoVersiculo p {
	font-size: 30px;
	padding: 30px;
}

.textoVersiculo h2 {
	font-size: 30px;
	padding: 0px 30px 0px 0px;
	text-align: right;
}


</style>
</head>
<body>
	<div class="textoVersiculo">
		<p>${versiculo.numero} ${versiculo.texto}</p>
		<h2>${versiculo.livro.nome} ${versiculo.capitulo}:${versiculo.numero}</h2>
	</div>
</body>
</html>