<#import "parts/common.ftl" as c>
<@c.page>
<a href="/" class="button">Назад</a>
<a href="/usedforms" class="button">Формы, которые использовал пользователь</a>
<a href="/top5" class="button">ТОП – 5 самых используемых форм</a>
<h3>пользователи не дошедшие до конца</h3>
<table>
    <thead>
    <tr>
        <th>ssoid</th>
        <th>subtype</th>
    </thead>
    <tbody>
    <#list sessions as session>
    <tr>
        <td>${session.ssoid?ifExists}</td>
        <td>${session.subtype?ifExists}</td>
    </tr>
    <#else>
    Empty
    </#list>
    </tbody>
</table>
</@c.page>