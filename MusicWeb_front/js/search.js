
if ($(sessionScope.user != null)) {
    $(".login-before").addClass("hidden");
    $(".login-after").removeClass("hidden");
}

$("#out").click(function () {
    var flag = window.confirm("確定要離開?");
    if (flag) {

        window.location.href = "user?oper=out";
    }
});

if ($(homep.li == 1)) {
    $('.nav-tabs li:eq(1) a').tab('show');
} else {
    $('.nav-tabs li:eq(2) a').tab('show');
}

if ($(searchp.searchPageDetail == null)) {
    $(".noResult").removeClass("hidden");
    $(".page").addClass("hidden");
}

if ($(searchp.currentPage == 1)) {
    $(".page>ul>li:eq(0)").addClass("disabled");
    $(".page>ul>li:eq(0)>a").attr("href", "javascript:;");
}
if ($(searchp.currentPage) == $(searchp.totlePage)) {
    $(".page>ul>li:eq(1)").addClass("disabled");
    $(".page>ul>li:eq(1)>a").attr("href", "javascript:;");
}
