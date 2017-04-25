$(function () {
    $(".toggle-brand").click(function(){
        var width = $(window).width();
        if($(".sidebar").is(":hidden")) {
            $("#page-wrapper").animate({"margin-left": width < 768 ? "100%" : "250px"}, 100, function(){
                $(".sidebar").width(width < 768 ? "100%" : "250px");
                $(".sidebar").css("top", width < 768 ? "100px" : "50px");
                if(width < 768) {
                    $("#page-wrapper").hide();
                }else{
                    $("#page-footer").show();
                }
                $(".sidebar").show();
            });
        } else  {
            $(".sidebar").hide();
            if(width < 768) {
                $("#page-wrapper").show();
            }else{
                $("#page-footer").hide();
            }
            $("#page-wrapper").animate({"margin-left": width < 768 ? "-20px" : "0"}, 100);
        }
    });
});

function renderMenus(urlPrefix, menus, defaultShowMenuId) {
    if (menus && menus.length > 0) {
        for (var i in menus) {
            var menu = menus[i];
            if (!menu['parent']) {
                var breadcrumb = [];
                breadcrumb.push({menuName: menu['menuName'], menuUrl: menu['menuUrl'], menuNameDes: menu['menuNameDes']});
                renderMenu($("#side-menu"), menu, 1, menus, breadcrumb, urlPrefix, defaultShowMenuId);
            }
        }
    }
    $('#side-menu').metisMenu({toggle: false});
}

function renderMenu(dom, menu, level, menus, breadcrumb, urlPrefix, defaultShowMenuId) {
    var menuId = menu['id'];
    var menuName = menu['menuName'];
    var menuNameDes = menu['menuNameDes'];
    var menuUrl = menu['menuUrl'];
    var menuIcon = menu['icon'];
    var isExpand = menu['isExpand'];
    var menuItem = $("<li></li>");
    if (isExpand)  menuItem.addClass('active');
    var menuTitleItem = $("<a href='javascript:void(0)'></a>");
    if (level > 1) {
        menuItem.css("border-bottom", "none");
        menuTitleItem.css("padding-left", ((level - 1) * 37) + 'px');
    }
    if (menuIcon) {
        var menuIconItem = $("<i></i>");
        menuIconItem.addClass("fa " + menuIcon + " fa-fw");
        menuTitleItem.append(menuIconItem).append("&nbsp;");
    }
    if (menuName) {
        menuTitleItem.append(menuName);
    }
    if (menuUrl) {
        menuItem.click(function () {
            showPage(breadcrumb, menuNameDes, menuUrl, urlPrefix);
        });
    }
    if(menuId == defaultShowMenuId) menuTitleItem.attr("default", true);
    var isSetChildren = false;
    var childrenDom = $('<ul class="nav"></ul>');
    for (var j in menus) {
        var tempMenu = menus[j];
        if (!tempMenu['parent']) continue;
        var parentId = tempMenu['parentId'];
        if (menuId && menuId == parentId) {
            if (!isSetChildren) {
                menuTitleItem.append('<span class="fa arrow"></span>');
                isSetChildren = true;
            }
            breadcrumb.push({menuName: tempMenu['menuName'], menuUrl: tempMenu['menuUrl'], menuNameDes: tempMenu['menuNameDes']});
            renderMenu(childrenDom, tempMenu, level + 1, menus, $.my_clone(breadcrumb), urlPrefix, defaultShowMenuId);
            breadcrumb.pop();
        }
    }
    menuItem.append(menuTitleItem);
    if (isSetChildren) menuItem.append(childrenDom);
    $(dom).append(menuItem);
}

function showPage(breadcrumb, title, url, urlPrefix) {
    if (url) {
        if($(window).width() < 768){
            if($(".sidebar").is(":visible")) {
                $(".sidebar").hide();
                $("#page-wrapper").show();
                $("#page-wrapper").animate({"margin-left":"-20px"}, 100);
            }
        }
        $.showPageloading();
        if (url.indexOf("/") != 0) url = "/" + url;
        $("#content").load(urlPrefix + url, {inModal: "true"}, function (html, status) {
            if ('error' == status) {
                $.MessagePusher.showMsg({message: '未能找到菜单地址，请重试！', type: 'error'});
                $("#title").html("");
                $("#content").html($("<div class='row'></div>").html(html));
            } else {
                $("#title").removeClass("hidden");
                $(".breadcrumb").html("");
                if(breadcrumb && $.isArray(breadcrumb)){
                    for(var i in breadcrumb){
                        var obj = breadcrumb[i];
                        var menuName = obj['menuName'];
                        var menuUrl = obj['menuUrl'];
                        var menuNameDes = obj['menuNameDes'];
                        obj.breadcrumb = breadcrumb.slice(0, parseInt(i) + 1);
                        if(menuName){
                            var li = $("<li></li>");
                            if(i == (breadcrumb.length - 1)){
                                li.addClass("active");
                                li.append(menuName);
                            }else{
                                var a = $("<a href='javascript:void(0)'></a>");
                                a.html(menuName);
                                a.data("params", obj);
                                if(menuUrl){
                                    a.click(function(){
                                        var params = $(this).data("params");
                                        showPage(params.breadcrumb, params.menuNameDes, params.menuUrl, urlPrefix);
                                    });
                                }
                                li.append(a);
                            }
                            $(".breadcrumb").append(li);
                        }
                    }
                }
                if (title) $("#title span").html(title);
            }
            $.hidePageloading();
        });
    }
}

//Loads the correct sidebar on window load,
//collapses the sidebar on window resize.
// Sets the min-height of #page-wrapper to window size
$(function () {
    var isDoing = false;
    $(window).bind("load resize", function () {
        var topOffset = 50;
        var width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
        if (width < 768) {
            //$('div.navbar-collapse').addClass('collapse');
            topOffset = 100; // 2-row-menu
            if(!isDoing) {
                isDoing = true;
                $("#page-wrapper").show();
                $(".sidebar").hide();
                $("#page-wrapper").animate({"margin-left": "-20px"}, 100);
                isDoing = false;
            }
        } else {
            if(!isDoing) {
                isDoing = true;
                if($(".sidebar").is(":visible") && $(".sidebar").width() > 250) $(".sidebar").hide();
                $("#page-wrapper").show();
                $("#page-wrapper").animate({"margin-left": "250px"}, 100, function(){
                    $(".sidebar").width(250);
                    $(".sidebar").css("top", "50px");
                    $(".sidebar").show();
                    isDoing = false;
                });
            }
        }
        var height = ((this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height) - 1;
        if(!(!!window.ActiveXObject || "ActiveXObject" in window)) height = height - topOffset;
        if (height < 1) height = 1;
        if (height > topOffset) {
            $("#page-wrapper").css("min-height", (height) + "px");
        }
        $(".sidebar").css({height: document.body.clientHeight - $("nav").height() + 2, overflow: "auto"});
    });

    var url = window.location;
    var element = $('ul.nav a').filter(function () {
        return this.href == url || url.href.indexOf(this.href) == 0;
    }).addClass('active').parent().parent().addClass('in').parent();
    if (element.is('li')) {
        element.addClass('active');
    }
});