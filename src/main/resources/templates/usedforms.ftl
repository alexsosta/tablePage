<#import "parts/common.ftl" as c>
<@c.page>
<a href="/" class="button">Назад</a>
<a href="/top5" class="button">ТОП – 5 самых используемых форм</a>
<a href="/notfinished" class="button">пользователи не дошедшие до конца</a>
<h3>Формы, которые использовал пользователь</h3>
<table>
    <thead>
    <tr>
        <th>ssoid</th>
        <th>forms</th>
    </thead>
    <tbody>
    <#list usedforms as usedform>
    <tr>
        <td>${usedform.user?ifExists}</td>
        <td>${usedform.forms?ifExists}</td>
    </tr>
    <#else>
    Empty
    </#list>
    </tbody>
</table>
</@c.page>