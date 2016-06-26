<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<ul id="nav">
	<li><a href="/admin">Home</a></li>
	<li><a href="/admin">Cadastro</a>
		<ul>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="/admin/user/">Usuario</a></li>
			</sec:authorize>
			<li><a href="/admin/biblia/">Biblia</a></li>
		</ul></li>
	<li><a hidden="/j_spring_security_logout">Sair</a></li>
</ul>
<style>
</style>
<script type="text/javascript">
	$("#nav").kendoMenu({
	    direction: "bottom left"
	});
</script>

<%-- 
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<p><a href="/admin/user/list">Usuario</a></p>
</sec:authorize> --%>