<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">修改密码</h4>
         </div>
         <div class="modal-body">
         <form role="form" class="form-horizontal" method="post">
           <div class="form-group">
               <label for="password" class="col-sm-2 control-label">新密码:</label>
               <div class="col-sm-8">
                   <input class="form-control" id="new_password" name="new_password" type="password" placeholder="please input password">
               </div>
           </div>
		   <div class="form-group">
               <label for="password" class="col-sm-2 control-label">确认密码:</label>
               <div class="col-sm-8">
                   <input class="form-control" id="confirm_password" name="confirm_password" type="password" placeholder="please input password">
               </div>
           </div>
           </form>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" class="btn btn-primary" onclick="changepassword('<c:url value="/passwordchange"/>')">确定</button>
         </div>
      </div>
   </div>
</div>