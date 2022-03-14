window.onload = function()
{
        LoadSTu();
//        alert("载入意见完成！");
}

        function LoadSTu(){
            $.ajax({
                url: "findAllStudents",
                async: false,
                cache: false,
                type: "get",
                dataType: "json",
                success: function (data) {
				  $.each(data,function(i,n){			
                  var head="";
                       head=head+'<tbody>';
                                 head=head+'<c:forEach items="${sessionScope.showAdminList}" var="adm" varStatus="status">';
                                 head=head+'<tr>';
                                 head=head+'<td>'+n.id+'</td>';
                                 head=head+'<td>'+n.name+'</td>';
                                 head=head+'<td>'+n.username+'</td>';
                                 head=head+'<td>'+n.classes+'</td>';
                                 head=head+'<td>'+n.time+'</td>';
                                 head=head+'<td>'+n.fangxiang+'</td>';
                                 head=head+'<td class="td-status">';
                                 head=head+'<span class="layui-btn layui-btn-normal layui-btn-mini">正常</span>';
                                 head=head+'</td>';
                                 head=head+'<td class="td-manage">';
                                 head=head+'<a onclick="" href="javascript:;"  title=+"启用">';
                                 head=head+'<i class="layui-icon">&#xe601;</i>';
                                 head=head+'</a>';
                                 head=head+'<a title="编辑"  onclick="" href="javascript:;">';
                                 head=head+'<i class="layui-icon">&#xe642;</i>';
                                 head=head+'</a>';
                                 head=head+'<a title="删除" onclick="" href="javascript:;">';
                                 head=head+'<i class="layui-icon">&#xe640;</i>';
                                 head=head+'</a>';
                                 head=head+'</td>';
                                 head=head+'</tr>';
                                 head=head+'</c:forEach>';
                                 head=head+'</tbody>';
                   $('.layui-table').append(head);
                    })
				 }
                })
               }

       
//layui自启动
layui.use('layer', function(){
  $('.demo').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});

 /*用户-停用*/
 function admin_stop(obj,id){
    layer.confirm('确认要冻结吗？',function(index){
    if($(obj).attr('title')=='启用'){
      $("#adminsendOrder").attr("action","${pageContext.request.contextPath}/AdminServlet?action=freezeAdm&admin_id="+id +"&statue=0").submit();
      layer.msg('已冻结!',{icon: 5,time:1000});
    }else{
      $("#adminsendOrder").attr("action","${pageContext.request.contextPath}/AdminServlet?action=freezeAdm&admin_id="+id+"&statue=1").submit();
      layer.msg('正常!',{icon: 5,time:1000});
    }
    });
   }

//用户自定义相关函数
function admin_delete(obj,getid){
	layer.confirm('确定删除？', {btn: ['确定','取消']},
	 function(){
        //发送删除的请求
        $("#adminsendOrder").attr("action","${pageContext.request.contextPath}/AdminServlet?action=delAdmData&admin_id="+getid).submit();
        layer.msg('已经删除', {icon: 1});
      }, function(){
        layer.msg('取消删除', {});
      });
}


//信息编辑
function adminInfo_edit(obj,getid){
     layer.open({
       type: 2,
       area: ['700px', '450px'],
       fixed: false, //不固定
       shadeClose: true,
       maxmin: true,
       //跳出相对路劲，目前是在根目录下面
       content: '${pageContext.request.contextPath}/AdminServlet?action=editAdmQuery&admin_id='+getid,
       end: function(){
		// 如果是通过单击关闭按钮关闭弹出层，父画面没有此表单
		if($("#subform").length === 1){
			$("#subform").submit();
		}
	    }
    });
}

//信息搜索
function searchByInfo(){
  var getAdminRole = $("#adminRole").val();
  var getAdminName = $("#adminName").val();
  var form = document.getElementById("searchByInfo");
  form.onsubmit = function(form){
  if (getAdminRole == "" && getAdminName == ""){
	  layer.msg('至少填写一个查询信息', {icon: 0.5});
	  return false;
   }else{
      $("#searchByInfo").attr("action","${pageContext.request.contextPath}/AdminServlet?action=searchByCondition").submit();
  }
  }
}


//--------------------mysql数据库分页显示操作---------------------------------
//首页
function admin_getFirstPage(obj,currentPage){
   $("#adminsendOrder").attr("action","${pageContext.request.contextPath}/AdminServlet?action=showAdmData&currentPage=1").submit();
}
//上一页
function admin_getPriverPage(dataCount,currentPage){
   if(currentPage==1){
      layer.msg('已是首页', {icon: 0.5});
   }else{
   $("#adminsendOrder").attr("action","${pageContext.request.contextPath}/AdminServlet?action=showAdmData&currentPage="+(currentPage-1)).submit();
  }
}
//下一页(注意，这里每页是10条记录)
function admin_getNextPage(dataCount,currentPage){
   var endPage=Number(dataCount)/Number(10);
   if(currentPage>=endPage){
      layer.msg('已是尾页', {icon: 0.5});
   }else{
    var nextPage=Number(currentPage)+Number(1);
    $("#adminsendOrder").attr("action","${pageContext.request.contextPath}/AdminServlet?action=showAdmData&currentPage="+nextPage).submit();
   }
}
//尾页
function admin_getLastPAge(obj,dataCount){
    var laetPage= Math.ceil(dataCount/10);
    $("#adminsendOrder").attr("action","${pageContext.request.contextPath}/AdminServlet?action=showAdmData&currentPage="+laetPage).submit();
}








