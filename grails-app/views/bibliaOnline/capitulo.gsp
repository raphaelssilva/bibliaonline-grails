<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<style type="text/css">
.numeroCapituloMini {
	float: left;
}

.numeroCapituloMini a span {
	font-size: 14px;
	margin: 0px 4px 0px 4px;
	position: relative;
}

.textoVersiculo{
	margin: 0px 20px 0px 20px ;
}

.textoVersiculo p {
	font-size: 19px;
}

.versiculos{
	float: left;
}


</style>
</head>
<body>
<div class="versiculos">
    <g:each in="${versiculos}" var="versiculo">
        <div class="textoVersiculo">
            <p>
                <sub>${versiculo.numero}</sub>
                ${versiculo.texto}
            </p>
        </div>
    </g:each>
</div>
<div class="numeroCapituloMini">
    <h3>Clique em um versiculo:</h3>
    <g:each in="${versiculos}" var="versiculo">
        <g:link absolute="true" url="/${params.biblia}/${params.livro}/${params.capitulo}/${versiculo.numero}">
            <span> ${versiculo.numero>9?versiculo.numero:("0"+versiculo.numero)}</span>
        </g:link>
    </g:each>
</div>
</body>
</html>