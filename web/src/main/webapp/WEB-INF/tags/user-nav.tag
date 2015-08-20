<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="tab" %>
<ul class="nav nav-pills nav-stacked">
    <li <c:if test="${tab eq 'user' }">class="active"</c:if>><a href="<c:url value='/admin/user'/>">用户</a></li>
</ul>
