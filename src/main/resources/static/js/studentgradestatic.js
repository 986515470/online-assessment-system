var res=[];
$.ajax({
        url: "getALLPlayData",
        async: false,
        cache: false,
        type: "get",
        dataType: "json",
        success:function(response){
          res[9]=response[0].j;
          res[8]=response[0].i;
          res[7]=response[0].g;
          res[6]=response[0].h;
          res[5]=response[0].f;
          res[4]=response[0].e;
          res[3]=response[0].d;
          res[2]=response[0].c;
          res[1]=response[0].b;
          res[0]=response[0].a;

        }
})
//[{"a":2,"c":0,"b":0,"d":0,"e":0,"f":1,"h":0,"g":0,"i":0,"j":0}]
  var dom = document.getElementById("container");
                          var myChart = echarts.init(dom);
                          var app = {};
                          option = null;
                          option = {
                              title: {
                                  text: '学生成绩分数段占比统计',
                                  subtext: '所有成绩',
                                  left: 'center'
                              },
                              tooltip: {
                                  trigger: 'item',
                                  formatter: '{a} <br/>{b} : {c} ({d}%)'
                              },
                              legend: {
                                  orient: 'vertical',
                                  left: 'left',
                                  data: ['60-63段', '64-67段', '68-71段', '72-75段', '76-79段',
                                               '80-83段', '84-87段', '88-91段', '92-95段', '96-100段']
                              },
                              series: [
                                  {
                                      name: '访问来源',
                                      type: 'pie',
                                      radius: '55%',
                                      center: ['50%', '60%'],
                                      data: [
                                          {value: res[9], name: '60-63段'},
                                          {value: res[8], name: '64-67段'},
                                          {value: res[7], name: '68-71段'},
                                          {value: res[6],name: '72-75段'},
                                          {value: res[5], name: '76-79段'},
                                          {value: res[4], name: '80-83段'},
                                          {value: res[3], name: '84-87段'},
                                          {value: res[2], name: '88-91段'},
                                          {value: res[1],name: '92-95段'},
                                          {value: res[0], name: '96-100段'}
                                      ],
                                      emphasis: {
                                          itemStyle: {
                                              shadowBlur: 10,
                                              shadowOffsetX: 0,
                                              shadowColor: 'rgba(0, 0, 0, 0.5)'
                                          }
                                      }
                                  }
                              ]
                          };
                          ;
                          if (option && typeof option === "object") {
                              myChart.setOption(option, true);
                          }

window.onload = function()
{

        LoadPro();



}




        function LoadPro()
{
         $('.layui-table').empty();

            $.ajax({
                url: "getUserSession",
                async: false,
                cache: false,
                type: "get",
                dataType: "json",
                success: function (data) {

                   var head="";
                    head=head+'<thead>';
                    head=head+'<tr>';
                    head=head+'<th>ID</th>';
                    head=head+'<th>学生姓名</th>';
                    head=head+'<th>学生一卡通</th>';
                    head=head+'<th>学生专业班级</th>';
                    head=head+'<th>提交时间</th>';
                    head=head+'<th>批改时间</th>';
                    head=head+'<th>考核方向</th>';
                    head=head+'<th>状态</th>';
                    head=head+'<th>成绩</th>';
                    head=head+'<th>查看</th>';
                    head=head+'<th>考核人</th>';
                    head=head+'</thead>';
                $('.layui-table').append(head);
                  $.each(data,function(i,n){
                     head="";
                      head=head+'<tbody>';
                      head=head+'<tr>';
                      head=head+'<td>'+n.id+'</td>';
                      head=head+'<td>'+n.name+'</td>';
                      head=head+'<td>'+n.username+'</td>';
                      head=head+'<td>'+n.classes+'</td>';
                      head=head+'<td>'+n.posttime+'</td>';
                      if(n.time==null)
              	        head=head+'<td>未批改</td>';
              	      else
              	        head=head+'<td>'+n.time+'</td>';
                      head=head+'<td>'+n.fangxiang+'</td>';
                      head=head+'<td>任务已提交</td>';
                      if(n.score==null)
                       head=head+'<td>未批改</td>';
                       else
                         head=head+'<td>'+n.score+'</td>';
                       head=head+'<td><a href="'+n.href+'" download="'+n.href+'">'+n.projectname+'</a></td>';
                       if(n.fangxiang=='前端')
                            head=head+'<td>张跃甲</td>';
                         else  if(n.fangxiang=='后端')
                           head=head+'<td>王成宇</td>';
                         else  head=head+'<td>林秋良</td>';
                      head=head+'</tbody>';
                   $('.layui-table').append(head);

                    })
                }


                })

 }













