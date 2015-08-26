<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="tab" %>
<ul class="nav nav-pills nav-stacked">
    <li <c:if test="${tab eq 'user' }">class="active"</c:if>><a href="<c:url value='/admin/user'/>">用户列表</a></li>
    <li <c:if test="${tab eq 'role' }">class="active"</c:if>><a href="<c:url value='/admin/role'/>">角色列表</a></li>
    <li <c:if test="${tab eq 'perm' }">class="active"</c:if>><a href="<c:url value='/admin/perm'/>">权限列表</a></li>
</ul>
