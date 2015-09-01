<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="tab" %>
<ul class="nav nav-pills nav-stacked">
   <c:forEach items="${subMenu}" var="submenu"> 
	<li <c:if test="${tab eq submenu.tab }">class="active"</c:if>><a href="<c:url value='${submenu.url }'/>">${submenu.name }</a></li>
	</c:forEach>
</ul>
