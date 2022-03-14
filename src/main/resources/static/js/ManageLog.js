
//$(function(){
//    LoadPro();//预加载ajax
//   $(".layui-btn").click(function(){
//            LoadSearchPro();
//        })
//});
 function LoadSearchPro(){
                   var name=document.getElementById("name").value;
                   var fangxiang=document.getElementById("fangxiang").value;
                          $('.layui-table').empty();
                          var shuju={"name":name,"fangxiang":fangxiang};
                             $.ajax({
                                 url: "findProjectsByFangxiang",
                                 async: false,
                                 cache: false,
                                 type: "get",
                                 dataType: "json",
                                 data:shuju,
                                 success: function (data) {
                                    var head="";
                                  head=head+'<thead>';
                                 head=head+'<tr>';
                                 head=head+'	<th>ID</th>';
                                 head=head+'	<th>项目名称</th>';
                                 head=head+'	<th>文件大小</th>';
                                 head=head+'	<th>提交时间</th>';
                                 head=head+'	<th>学生姓名</th>';
                                 head=head+'	<th>班级</th>';
                                 head=head+'	<th>一卡通号</th>';
                                 head=head+'	<th>考核方向</th>';
                                 head=head+'	<th>考核人</th>';
                                 head=head+'	<th>批改时间</th>';
                                 head=head+'	<th>分数</th>';
                                 head=head+'	<th>打分</th>';
                                 head=head+'<tr/>';
                                 head=head+'</thead>';
                                 $('.layui-table').append(head);
                 				  $.each(data,function(i,n){

                                      head="";
                                      head=head+'<tbody id="tb">';
                                      head=head+'<tr>';
                                      head=head+'<td>'+n.id+'</td>';
                                      head=head+'<td><a href="'+n.href+'" download="'+n.href+'">'+n.projectname+'</a></td>';
                                      head=head+'<td>'+n.size+'</td>';
                                      head=head+'<td>'+n.posttime+'</td>';
                                      head=head+'<td>'+n.name+' </td>';
                                      head=head+'<td>'+n.classes+'</td>';
                                      head=head+'<td>'+n.username+'</td>';
                                      head=head+'<td>'+n.fangxiang+'</td>';
                                      if(n.fangxiang=='前端')
                                         head=head+'<td>张跃甲</td>';
                                      else  if(n.fangxiang=='后端')
                                        head=head+'<td>王成宇</td>';
                                      else  head=head+'<td>林秋良</td>';

                                      if(n.time==null)
                                        head=head+'<td></td>';
                                      else
                                         head=head+'<td>'+n.time+'</td>';

                                      if(n.score==null)
                                        head=head+'<td></td>';
                                      else
                                        head=head+'<td>'+n.score+'</td>';

                                      head=head+'<td class="td-manage">';
                                      head=head+'	<a title="打分"  onclick="EditScore('+n.id+')" href="javascript:;">';
                                      head=head+'		<i class="layui-icon">&#xe609;</i>';
                                      head=head+'	</a>                   ';
                                      head=head+'</td>';
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

//信息编辑
function EditScore(id){
     window.localStorage.setItem('id',id);
     layer.open({
       type: 2,
       area: ['400px', '180px'],
       fixed: false, //不固定
       shadeClose: true,
       maxmin: true,
       //跳出相对路劲，目前是在根目录下面
       content: 'EditScore.html',
       end: function(){
		// 如果是通过单击关闭按钮关闭弹出层，父画面没有此表单
		if($("#subform").length === 1){
			$("#subform").submit();
		}
	    }
    });
}
function EditScore0(id){
     window.localStorage.setItem('id',id);
     layer.open({
       type: 2,
       area: ['400px', '180px'],
       fixed: false, //不固定
       shadeClose: true,
       maxmin: true,
       //跳出相对路劲，目前是在根目录下面
       content: 'EditScore0.html',
       end: function(){
		// 如果是通过单击关闭按钮关闭弹出层，父画面没有此表单
		if($("#subform").length === 1){
			$("#subform").submit();
		}
	    }
    });
}
function EditScore1(id){
     window.localStorage.setItem('id',id);
     layer.open({
       type: 2,
       area: ['400px', '180px'],
       fixed: false, //不固定
       shadeClose: true,
       maxmin: true,
       //跳出相对路劲，目前是在根目录下面
       content: 'EditScore1.html',
       end: function(){
		// 如果是通过单击关闭按钮关闭弹出层，父画面没有此表单
		if($("#subform").length === 1){
			$("#subform").submit();
		}
	    }
    });
}
function EditScore2(id){
     window.localStorage.setItem('id',id);
     layer.open({
       type: 2,
       area: ['400px', '180px'],
       fixed: false, //不固定
       shadeClose: true,
       maxmin: true,
       //跳出相对路劲，目前是在根目录下面
       content: 'EditScore2.html',
       end: function(){
		// 如果是通过单击关闭按钮关闭弹出层，父画面没有此表单
		if($("#subform").length === 1){
			$("#subform").submit();
		}
	    }
    });
}


  function getJsonLength(json){
                 var jsonLength=0;
                 for (var i in json) {
                     jsonLength++;
                 }
                 return jsonLength;
             }









