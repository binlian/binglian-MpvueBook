<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>冰怜书屋后台</title>
  <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="../../css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">冰怜书屋后台</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          贤心
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">操作</a>
          <dl class="layui-nav-child">
            <dd><a href="/admin/index">添加书籍</a></dd>
            <dd><a href="/admin/book/list">书籍列表</a></dd>
          </dl>
        </li>
        
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
    	 <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>
                        ID
                    </th>
                    <th>
                        书籍标题
                    </th>
                    <th>
                        书籍作者
                    </th>
                    <th>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
					<#if BookList ??>
						<#list BookList.rows as book>
						<tr>
                            <td>${book.id}</td>
                            <td>${book.bookTitle}</td>
                            <td>${book.bookAuthor}</td>
                            <td>
								<a href="/admin/book/edit?id=${book.id}">编辑</a>
                                <a href="/admin/book/delete?id=${book.id}">删除</a>
                            </td>
                        </tr>
                        </#list>
                    <#else>
							<td>为空</td>
							<td>为空</td>
							<td>为空</td>
                    </#if>

                </tbody>
            </table>
        </div>
        <button onClick="window.open('/admin/category/add')" class="btn btn-primary btn-lg pull-right">
            添加书籍
        </button>
		<div class="col-md-12 column">
			<ul class="pagination pull-right">
				<li>
					 <a href="?page=${BookList.prePage}&size=10">上一页</a>
				</li>
				
				<li>
					 <a href="">${BookList.page}</a>
				</li>
				
				<li>
					 <a href="?page=${BookList.nextPage}&size=10">下一页</a>
				</li>
			</ul>
		</div>


    </div>
    </div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © 冰怜书屋
  </div>
</div>
<script src="../../js/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});



</script>
</body>
</html>