<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="tab" %>
<ul class="nav nav-pills nav-stacked">
    <li <c:if test="${tab eq 'integralOrder' }">class="active"</c:if>><a href="<c:url value='/admin/integralOrder'/>">积分订单</a></li>
</ul>
