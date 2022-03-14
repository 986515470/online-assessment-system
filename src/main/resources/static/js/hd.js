window.onload = function()
{
        LoadSTu();
//        alert("载入意见完成！");
}

        function LoadSTu(){
            $.ajax({
                url: "findHDPlay",
                async: false,
                cache: false,
                type: "get",
                dataType: "json",
                success: function (data) {
                   $(".layui-table").empty();
                   var head="";
                   head=head+'<thead>';
                   head=head+'<tr>';
                   head=head+'<th>ID</th>';
                   head=head+'<th>学生姓名</th>';
                   head=head+'<th>&nbsp;&nbsp;&nbsp;&nbsp;学号</th>';
                   head=head+'<th>班级</th>      ';
                   head=head+'<th>学习方向</th> ';
                   head=head+'<th>注册时间</th> ';
                   head=head+'<th>平均成绩</th>   ';
                   head=head+'<th>状态</th> ';
                   head=head+'<th>操作</th>';
                   head=head+'</thead>';
                   head=head+' <tbody>';
                     $('.layui-table').append(head);
				  $.each(data,function(i,n){
                   if(n.fangxiang=="后端"){
                   head="";
                       head=head+'<tr>';
                       head=head+'<td>'+n.id+'</td>';
                       head=head+'<td>'+n.name+'</td>';
                       head=head+'<td>'+n.username+'</td>';
                       head=head+'<td>'+n.classes+'</td>';
                       head=head+'<td>'+n.fangxiang+'</td>';
                       head=head+'<td>'+n.time+'</td>';
                       head=head+'<td>'+n.score+'</td>';
                       head=head+'<td>正常</td> 	  ';
                       head=head+'<td class="td-manage">';
                       head=head+'<a title="编辑"  onclick="" href="javascript:;">';
                       head=head+'<i class="layui-icon">&#xe642;</i>';
                       head=head+'</a>';
                       head=head+'<a title="删除" onclick="" href="javascript:;">';
                       head=head+'<i class="layui-icon">&#xe640;</i>';
                       head=head+'</a>';
                       head=head+'</td>';
                       head=head+'</tr>';
                        head=head+' </tbody>';
                        $('.layui-table').append(head);
                               }

                    })
}

                   })


 }






