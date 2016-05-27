<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
          .table{
              border-collapse: collapse;
          }
          .table td{
              padding: 5px 8px;
              border: 1px solid #999;
          }
    </style>
</head>
<body>
<h3>user infos</h3>
<table class="table">
<#list users as user>
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.age}</td>
    </tr>
</#list>
</table>
</body>
</html>