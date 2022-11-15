<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<center>
    <table border="1" rules="all">
        <tr bgcolor="#00ffff" align="center">
            <th>处方类型</th>
            <th>病种</th>
            <th>备注</th>
            <th>患者id</th>
        </tr>

        <#list list as r>
            <tr align="center">
                <td>${r.type}</td>
                <td>${r.diagnose}</td>
                <td>${r.remark}</td>
                <td>${r.userid}</td>
            </tr>
        </#list>
    </table>
</center>
</body>
</html>