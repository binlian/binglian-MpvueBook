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
    	 <div class="col-md-12">
            <form id="articleForm" role="form" novalidate="novalidate">
                <input type="hidden" name="categories" id="categories" />
                <input type="hidden" name="cid" id="cid" value="" />
                <input type="hidden" name="status" id="status" value="publish" />
                <input type="hidden" name="allowComment" id="allowComment" value="true" />
                <input type="hidden" name="allowPing" id="allowPing" value="true" />
                <input type="hidden" name="allowFeed" id="allowFeed" value="true" />
                <input type="hidden" name="content" id="content-editor" />

                <div class="form-group col-md-6" style="padding: 0 10px 0 0;">
                    <input id="bookTitle" type="text" class="form-control" placeholder="书籍名称" name="title" required="required" aria-required="true"/>
                </div>


                <div class="form-group col-md-6" style="padding: 0 10px 0 0;">
                    <input id="bookAuthor" name="tags" id="tags" type="text" class="form-control" placeholder="书籍作者"  />
                </div>

                <div class="form-group col-md-6" style="padding: 0 10px 0 0;">
                    <input id="bookDesc" name="tags" id="tags" type="text" class="form-control" placeholder="书籍描述"  />
                </div>
                <div class="form-group col-md-6" style="padding: 0 10px 0 0;">
                    <input id="bookImg" name="tags" id="tags" type="text" class="form-control" placeholder="书籍图片地址"  />
                </div>
                
            </form>
        </div>
        <button id="submit" class="btn btn-primary btn-lg pull-right">添加书籍</button>
    </div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © 冰怜书屋
  </div>
</div>
<script src="../../js/layui.js"></script>
<script src="../../js/comm.js"></script>
<script>
//JavaScript代码区域

$(function(){
	$('#submit').bind("click",function(){
		var book={};
		book.bookTitle=document.getElementById('bookTitle').value;
		book.bookAuthor=document.getElementById('bookAuthor').value;
		book.bookDesc=document.getElementById('bookDesc').value;
		book.bookImg=document.getElementById('bookImg').value;
		
		$.ajax({
			url:comm.ServerUrl+'admin/book/add',
			type:'POST',
			data:JSON.stringify(book),
	 		contentType:'application/json',
	 		dataType : 'json',
			success:function(data){
				console.log(data);
				
			}
		})
	})
})
</script>
</body>
</html>