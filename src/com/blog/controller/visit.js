
var title = document.title;
var url = encodeURIComponent(document.location.href);
document.write("<script type=\"text/javascript\" src=\"http://"+document.domain+"/visit?uri=" + url + "&title=" + encodeURIComponent(title) + "\"></script>");

//不能用下面的方法 否则sessionID 每次都会变化  而且需要jquery   script 标签必须完整  如果写成 <script /> 则不会执行但也不报错
//$(document).ready(function () {
//    var title = document.title;
//    var url = encodeURIComponent(document.location.href);
//    $.get("http://service.kecq.com/visit?uri=" + url + "&title=" + encodeURIComponent(title), function (result) {

//    });
//})


