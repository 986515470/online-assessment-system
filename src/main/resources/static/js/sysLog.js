window.onload = function()
{

        LoadPro();

}

        function LoadPro(){
         $('.layui-table').empty();

            $.ajax({
                url: "findAllProjects",
                async: false,
                cache: false,
                type: "get",
                dataType: "json",
                success: function (data) {
                   var head="";
                    head=head+'<thead>';
                    head=head+'<tr>';
                    head=head+'<th>ID</th>';
                    head=head+'<th>项目名称</th>    ';
               	    head=head+'<th>文件大小</th>';
               	    head=head+'<th>提交时间</th> ';
                    head=head+'<th>学生姓名</th>';
                    head=head+'<th>班级</th>';
               	    head=head+'<th>一卡通号</th>';
               	    head=head+'<th>考核方向</th>';
               	    head=head+'<th>考核人</th>';
                    head=head+'<th>批改时间</th>';
                    head=head+'</thead>';
                $('.layui-table').append(head);
				  $.each(data,function(i,n){

                     head="";
                      head=head+'<tbody>';
                      head=head+'<tr>';
                      head=head+'<td>'+n.id+'</td>';
                      head=head+'<td>'+n.projectname+'</td>';
                      head=head+'<td>'+n.size+'</td>';
                       head=head+'<td>'+n.posttime+'</td>';
                      head=head+'<td>'+n.name+'</td>';
                      head=head+'<td>'+n.classes+'</td>';
                      head=head+'<td>'+n.username+'</td>';
                      head=head+'<td>'+n.fangxiang+'</td>';
                      if(n.fangxiang=='前端')
                         head=head+'<td>张跃甲</td>';
                      else  if(n.fangxiang=='后端')
                        head=head+'<td>王成宇</td>';
                      else  head=head+'<td>林秋良</td>';
                      if(n.time==null)
                      head=head+'<td>未批改</td>';
                      else
                      head=head+'<td>'+n.time+'</td>';

                      head=head+'</tbody>';
                   $('.layui-table').append(head);


                    })
					 }
                   })

                 }









