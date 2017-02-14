<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
        <script src="/asset/js/jquery-2.1.4.min.js"></script>
        <script src="/asset/js/jquery.jsonp.js"></script>
        <script type="text/javascript">
            $(function () {
                $("#confirm1").click(function(){
                    $.ajax({
                        url: "http://127.0.0.1:8080/json" ,
                        success: function(data) {
                            alert(data.username)
                        }
                    });
                })
                $("#confirm2").click(function(){
                    $.getJSON(
                        "http://127.0.0.1:8080/jsonp?jsoncallback=?",
                        {
                            clientData:"测试ajax跨域请求"
                        },
                        function(data) {
                            alert(data)
                            alert(data.username)

                        });
                })
                $("#confirm3").click(function(){
                    $.ajax({
                        url:'http://127.0.0.1:8080/jsonp2',
                        type: "get",
                        async: false,
                        dataType: "jsonp", //返回一个JsonP类型
                        jsonp: "callbackparam", //服务端用于接收callback调用的function名的参数
                        jsonpCallback: "success_jsonpCallback", //callback的function名称,服务端会把名称和data一起传递回来
                        success: function(json) {
                            alert(json);
                        },
                        error: function(){alert('Error');}
                    });
                })

                $("#confirm4").click(function(){
                    $.jsonp({
                        url:'http://127.0.0.1:8080/json2',
                        data: {
                            companyId : 45,
                            page: 1, // 控制页数，1 就显示第一页的内容，2 就显示第二页的内容
                            rows: 10  // 控制每页数据条数，此为10条
                        },
                        callbackParameter: "callback",
                        success: function(data) {

                            alert("处理数据的代码...");
                        },
                        error: function (xOptions, textStatus) {
                            alert("error");
                            alert(xOptions)
                        }
                    });
                })
                $("#confirm5").click(function(){
                    $.ajax({
                        url:'http://127.0.0.1:8080/jsonp3',
                        type: "get",
                        async: false,
                        dataType: "jsonp", //返回一个JsonP类型
                        success: function(json) {
                            alert(456);
                            alert(JSON.toString(json));
                        },
                        error: function(){alert('Error');}
                    });
                })
                $("#confirm6").click(function(){
                    $.ajax({
                        url:'http://127.0.0.1:8080/jsonp4',
                        type: "get",
                        async: false,
                        dataType: "jsonp", //返回一个JsonP类型
                        jsonp: "callbackparam", //服务端用于接收callback调用的function名的参数
                        jsonpCallback: "success_jsonpCallback", //callback的function名称,服务端会把名称和data一起传递回来
                        success: function(json) {
                            alert(json);
                        },
                        error: function(){alert('Error');}
                    });
                })
                $("#confirm7").click(function(){
                    $.ajax({
                        url:'http://127.0.0.1:8080/jsonp5',
                        type: "get",
                        async: false,
                        dataType: "jsonp", //返回一个JsonP类型
                        jsonp: "callbackparam", //服务端用于接收callback调用的function名的参数
                        jsonpCallback: "success_jsonpCallback", //callback的function名称,服务端会把名称和data一起传递回来
                        success: function(json) {
                            alert(json);
                        },
                        error: function(){alert('Error');}
                    });
                })
            });
            function jsonpCallBack(data){
                alert(123);
                alert(data.username);
            }

        </script>
    </head>
    <body>
        <#list users as user>
        username : ${user.username}<br/>
        password : ${user.password}
        </#list>
        <form name="search" method="get">
            <div class="mui-input-row mui-search input-search">
                <input type="search" id="search"   placeholder="请输入内容...">
            </div>
            <button type="button" id="confirm1" >Header跨域请求</button>
            <button type="button" id="confirm2" >Jsonp-1跨域请求</button>
            <button type="button" id="confirm3" >Jsonp-2跨域请求</button>
            <button type="button" id="confirm4" >Jsonp-3跨域请求</button>
            <button type="button" id="confirm5" >Jsonp-4跨域请求</button>
            <button type="button" id="confirm6" >Jsonp-5跨域请求</button>
            <button type="button" id="confirm7" >Jsonp-6跨域请求</button>
        </form>
    </body>
</html>  