<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <center>
        <form action="../admin/findAllConnAndPage" method="post">
            <input type="hidden" name="pageNum">
            姓名:<input type="text" name="user_name" value="${patient.user_name!}"/><br>
            创建时间:<input type="date" name="create_time" value="${patient.create_time!}"/><br>
            <input type="submit" value="检索">
        </form>
        <table border="1" width="700px">
            <tr>
                <th>姓名</th>
                <th>手机号</th>
                <th>性别</th>
                <th>创建时间</th>
                <th>年龄</th>
                <th>操作</th>
            </tr>
            <#list page.list as a>
                <tr>
                    <td>${a.user_name!}</td>
                    <td>${a.user_phone!}</td>
                    <td>${a.user_sex!0='男'||1='女'}</td>
                    <td>${(a.create_time?datetime)}
                       </td>
                    <td>${a.user_age!}</td>
                    <td>
                        <input type="button" value="删除">
                        <input type="button" value="查看处方" onclick="findAll(${a.user_id})">
                    </td>
                </tr>
            </#list>
            <tr>
                <td colspan="130" style="text-align: center">
                    当前${page.pageNum}/${page.pages}页;共计${page.total}条记录;
                    <button onclick="paging(1)">首页</button>
                    <button onclick="paging(${page.prePage})">上一页</button>
                    <button onclick="paging(${page.nextPage})">下一页</button>
                    <button onclick="paging(${page.lastPage})">尾页</button>
                </td>
            </tr>
        </table>
    </center>
</body>
<script>
    function paging(pageNum) {
        if(pageNum==0){
            pageNum = 1;
        }
        document.getElementsByName("pageNum")[0].value = pageNum;
        document.forms[0].submit();
    }

    function findAll(id) {
        location.href = "../recipe/recipeController?id="+id;
    }
</script>
</html>