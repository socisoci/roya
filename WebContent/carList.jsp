<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>二手车管理系统--所有二手车列表页面</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css">
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery.js"></script>
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>

	(function($){
		$(window).load(function(){
			
			$("a[rel='load-content']").click(function(e){
				e.preventDefault();
				var url=$(this).attr("href");
				$.get(url,function(data){
					$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
					//scroll-to appended content 
					$(".content").mCustomScrollbar("scrollTo","h2:last");
				});
			});
			
			$(".content").delegate("a[href='top']","click",function(e){
				e.preventDefault();
				$(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
			});
			
		});
	})(jQuery);
</script>
</head>
<body>
<!--header-->
<header>
 <h1><img src="images/admin_logo.png"/></h1>
 <ul class="rt_nav">
  <li><a href="http://www.deathghost.cn" target="_blank" class="website_icon">站点首页</a></li>
  <li><a href="#" class="clear_icon">清除缓存</a></li>
  <li><a href="#" class="admin_icon">DeathGhost</a></li>
  <li><a href="#" class="set_icon">账号设置</a></li>
  <li><a href="login.html" class="quit_icon">安全退出</a></li>
 </ul>
</header>
<!--aside nav-->
<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
 <h2><a href="index.html">首页</a></h2>
 <ul>
  <li>
   <dl>
    <dt>汽车</dt>
    <!--当前链接则添加class:active-->
    <dd><a href="CarServlet" class="active">汽车列表</a></dd>
      <dd><a href="product_detail.html">删除汽车</a></dd>
        <dd><a href="carAdd.jsp">增加汽车</a></dd>
      
   </dl>
  </li>
  <li>
   <dl>
    <dt>用户</dt>
    <dd><a href="order_list.html">用户列表</a></dd>
    <dd><a href="order_detail.html">用户信息</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>新闻</dt>
    <dd><a href="user_list.html">新闻列表</a></dd>
    <dd><a href="user_detail.html">添加新闻</a></dd>
    <dd><a href="user_rank.html">删除新闻</a></dd>
   </dl>
  </li>
  
  <li>
   <dl>
    <dt>中介</dt>
    <dd><a href="express_list.html">配送方式</a></dd>
    <dd><a href="pay_list.html">支付方式</a></dd>
   </dl>
  </li>
  
 </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">商品列表示例</h2>
       <a href="product_detail.html" class="fr top_rt_btn add_icon">添加商品</a>
      </div>
      <section class="mtb">
       <select class="select">
        <option>下拉菜单</option>
        <option>菜单1</option>
       </select>
       <input type="text" class="textbox textbox_225" placeholder="输入产品关键词或产品货号..."/>
       <input type="button" value="查询" class="group_btn"/>
      </section>
      <table class="table">
       <tr>
        <th>缩略图</th>
        <th>名字</th>
        <th>颜色</th>
        <th>公里数</th>
        <th>品牌</th>
        <th>图片</th>
        <th>操作</th>
       </tr>
       <% List<Car> cars=(List<Car>)request.getAttribute("cars"); 
       for(Car c:cars){
       %>
       
       
       <tr>
        <td class="center"><%=c.getname()%></td>
        <td class="center"><%=c.getyanse %></td>
        <td class="center"><%=c.getgonglishu%>KM</td>
        <td class="center"><%=c.getpingpai %></td>
        <td class="center"></td>
       
        <td class="center">
         <a href="http://www.deathghost.cn" title="预览" class="link_icon" target="_blank">&#118;</a>
         <a href="product_detail.html" title="编辑" class="link_icon">&#101;</a>
         <a href="javascript:if(window.confirm('您确认要删除这个车辆信息吗？')){location.href='CarServlet?method=delete=<%=c.getCharid()%>'}" title="删除" class="link_icon">&#100;</a>
        </td>
       </tr>
       <%} %>
      </table>
      <aside class="paging">
       <a>第一页</a>
       <a>1</a>
       <a>2</a>
       <a>3</a>
       <a>…</a>
       <a>1004</a>
       <a>最后一页</a>
      </aside>
 </div>
</section>
<% if(request.getAttribute("deleteResult")!=null){
	if(request.getAttribute("deleteResult").toString().equals("true")){
		
		%>
		<script type="text/javascript">
		alert('删除成功！')
		
		</script>
		
		<%
	}else{
		%>
		<script type="text/javascript">
		alert('删除失败！！')
		
		</script>
		<% 
			}	
	}%>

</body>
</html>
