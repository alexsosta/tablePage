<#import "parts/common.ftl" as c>
<@c.page>
<form action="/" method="post" enctype="multipart/form-data">
    <input name="file" type="file" >
    <button type="submit">Import</button>
</form>
<a href="/usedforms" class="button">Формы, которые использовал пользователь</a>
<a href="/notfinished" class="button">пользователи не дошедшие до конца</a>
<a href="/top5" class="button">ТОП – 5 самых используемых форм</a>
<table>
    <thead>
    <tr>
        <th>ssoid</th>
        <th>ts</th>
        <th>grp</th>
        <th>type</th>
        <th>subtype</th>
        <th>url</th>
        <th>orgid</th>
        <th>formid</th>
        <th>code</th>
        <th>ltpa</th>
        <th>sudirresponse</th>
        <th>ymdh</th>
    </tr>
    </thead>
    <tbody>
    <#list sessions as session>
    <tr>
        <td>${session.ssoid?ifExists}</td>
        <td>${session.ts?ifExists}</td>
        <td>${session.grp?ifExists}</td>
        <td>${session.type?ifExists}</td>
        <td>${session.subtype?ifExists}</td>
        <td>${session.url?ifExists}</td>
        <td>${session.orgid?ifExists}</td>
        <td>${session.formid?ifExists}</td>
        <td>${session.code?ifExists}</td>
        <td>${session.ltpa?ifExists}</td>
        <td>${session.sudirresponse?ifExists}</td>
        <td>${session.ymdh?ifExists}</td>
    </tr>
    <#else>
    Empty
    </#list>
    </tbody>
</table>
</@c.page>