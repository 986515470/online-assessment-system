window.onload = function()
{

        LoadPro();

          $("#btn").click(function(){
             $("div.layui-table:empty").remove();
                    LoadSearchPro();
                })

}
 function LoadSearchPro(){
                   var name=document.getElementById("name").value;
                   var fangxiang=document.getElementById("fangxiang").value;

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
                                   head=head+'<th>ID</th>';
                                   head=head+'<th>学生姓名</th>            ';
                                   head=head+'<th>学生一卡通</th>';
                                   head=head+'<th>学生专业班级</th>';
                                   head=head+'<th>提交时间</th> ';
                                   head=head+'<th>批改时间</th>';
                                   head=head+'<th>考核方向</th>';
                                   head=head+'<th>状态</th>';
                                   head=head+'<th>成绩</th>';
                                   head=head+'</thead>';
                                 $('.layui-table').append(head);
                 				  $.each(data,function(i,n){
                                      if(n.time!=null){
                                        head="";
                                         head=head+'<tbody>';
                                         head=head+'<tr>';
                                         head=head+'<td>'+n.id+'</td>';
                                         head=head+'<td>'+n.name+'</td>';
                                         head=head+'<td>'+n.username+'</td>';
                                         head=head+'<td>'+n.classes+'</td>';
                                         head=head+'<td>'+n.posttime+'</td>';
                                        head=head+'<td>'+n.time+'</td>';
                                         head=head+'<td>'+n.fangxiang+'</td>';
                                         head=head+'<td>任务已提交</td>';
                                         head=head+'<td>'+n.score+'</td>';
                                         head=head+'</tbody>';
                                          $('.layui-table').append(head);
                                         }
                                     })
                 					 }
                                    })


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
                    head=head+'<th>学生姓名</th>            ';
                    head=head+'<th>学生一卡通</th>';
                    head=head+'<th>学生专业班级</th>';
                    head=head+'<th>提交时间</th> ';
                    head=head+'<th>批改时间</th>';
                    head=head+'<th>考核方向</th>';
                    head=head+'<th>状态</th>';
                    head=head+'<th>成绩</th>';
                    head=head+'</thead>';
                $('.layui-table').append(head);
				  $.each(data,function(i,n){
				  if(n.time!=null){
                     head="";
                      head=head+'<tbody>';
                      head=head+'<tr>';
                      head=head+'<td>'+n.id+'</td>';
                      head=head+'<td>'+n.name+'</td>';
                      head=head+'<td>'+n.username+'</td>';
                      head=head+'<td>'+n.classes+'</td>';
                      head=head+'<td>'+n.posttime+'</td>';
              	      head=head+'<td>'+n.time+'</td>';
                      head=head+'<td>'+n.fangxiang+'</td>';
                      head=head+'<td>任务已提交</td>';
                      head=head+'<td>'+n.score+'</td>';
                      head=head+'</tbody>';
                   $('.layui-table').append(head);
                   }
                    })
					 }
                   })

                 }









