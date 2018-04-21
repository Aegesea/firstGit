<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<#--freemarker的循环-->
    <#list car as item>
        ${item.name}:${item.num}
    </#list>
</body>
</html>