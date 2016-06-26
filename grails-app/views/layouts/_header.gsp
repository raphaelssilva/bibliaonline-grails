
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>   
<span id="nomeSistema"><spring:message code="nome" /></span> 
<sec:authorize access="hasRole('ROLE_USER')">
	<span id="sair"><a href="/j_spring_security_logout">sair</a></span>
</sec:authorize>