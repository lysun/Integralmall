<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="tab" %>
<ul class="nav nav-pills nav-stacked">
    <li <c:if test="${tab eq 'shop' }">class="active"</c:if>><a href="<c:url value='/admin/shop'/>">商家信息</a></li>
    <li <c:if test="${tab eq 'tag' }">class="active"</c:if>><a href="<c:url value='/admin/tag'/>">商家标签信息</a></li>
</ul>
