<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<aside class="main-sidebar">
 <!-- sidebar: style can be found in sidebar.less -->
 <section class="sidebar">
   <!-- Sidebar user panel (optional) -->
   <div class="user-panel">
     <div class="pull-left image">
       <img src="${me.userImg}" class="img-circle">
     </div>
     <div class="pull-left info">
       <p>${me.userName}</p>
       <!-- Status -->
       <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
     </div>
   </div>

   <!-- Sidebar Menu -->
   <ul class="sidebar-menu">
     <!-- Optionally, you can add icons to the links -->
     <li class="header">菜单导航</li>

     <c:if test="${treeMenus != null}">
        <c:forEach items="${treeMenus}" var="vo">

            <li class="treeview <c:if test="${res != null } && ${vo.sysMenu.id==res}"> active </c:if> ">
                <a href="#"><i class="fa ${(vo.sysMenu.icon)}"></i>
                    <span>${(vo.sysMenu.menuName)}</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <c:forEach items="${vo.children}" var="ch" >
                        <li>
                            <a href="${(ch.sysMenu.url)}?res=${(vo.sysMenu.id)}&cur=${(ch.sysMenu.id)}"
                               style="<c:if test="${cur != null } && ${ch.sysMenu.id==cur}"> color: white </c:if>">
                                <i class="fa ${(ch.sysMenu.icon)}"></i> ${(ch.sysMenu.menuName)}
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </li>

        </c:forEach>

     </c:if>
   </ul><!-- /.sidebar-menu -->
 </section>
 <!-- /.sidebar -->
</aside>