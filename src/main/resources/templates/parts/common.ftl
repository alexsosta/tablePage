<#macro page>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TablePage</title>
    <style>
        table {border: solid 1px black;}
        td {border: solid 1px black;}
        th { border: solid 1px black; }
        .button {
            display: block;
            width: 200px;
            height: 25px;
            text-align: center;
            color: black;
            font-weight: bold;
            display: inline;
            margin: 10px 10px 10px 10px;
            padding: 3px;
        }
    </style>
</head>
<body>
<#nested>
</body>
</html>
</#macro>