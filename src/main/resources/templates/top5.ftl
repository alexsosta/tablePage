<#import "parts/common.ftl" as c>
<@c.page>
<a href="/" class="button">Назад</a>
<a href="/usedforms" class="button">Формы, которые использовал пользователь</a>
<a href="/notfinished" class="button">пользователи не дошедшие до конца</a>
<h3>ТОП – 5 самых используемых форм</h3>
<table>
    <thead>
    <tr>
        <th>form</th>
        <th>count</th>
    </thead>
    <tbody>
    <#list top5 as top>
    <tr>
        <td>${top.grp?ifExists}</td>
        <td>${top.count?ifExists}</td>
    </tr>
    <#else>
    Empty
    </#list>
    </tbody>
</table>
</@c.page>