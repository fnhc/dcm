//﻿var jq = jQuery.noConflict();
/**
 * 增删改工具栏
 */
/*window.onerror = function() {
	return true;
};*/
var iframe;// iframe操作对象
var win;//窗口对象
var gridname="";//操作datagrid对象名称
//scott 20160426 JS异常报错
var windowapi;
var W;
try {
	windowapi = frameElement.api, W = windowapi.opener;//内容页中调用窗口实例对象接口
} catch (e) {
}


/**
 * 设置 window的 zIndex
 * @param flag true: 不增量(因为 tip提示经常使用 zIndex, 所以如果是 tip的话 ,则不增量)
 * @returns
 */
function getzIndex(flag) {
    return layer.zIndex ;

    // var zindexNumber = getCookie("ZINDEXNUMBER");
    // if (zindexNumber == null) {
    //     zindexNumber = 2010;
    //     setCookie("ZINDEXNUMBER", zindexNumber);
    //     //zindexNumber = 1980;
    // } else {
    //     if (zindexNumber < 2010) {
    //         zindexNumber = 2010;
    //     }
    //     var n = flag ? zindexNumber : parseInt(zindexNumber) + parseInt(10);
    //     setCookie("ZINDEXNUMBER", n);
    // }
    // return zindexNumber;
} 

/**
 * 添加事件打开窗口
 * @param title 编辑框标题
 * @param addurl//目标页面地址
 */
function add(title, addurl, gname, width, height) {
    // gridname = gname;
    var options = _getDefaultWinodwOptions(title , addurl , width, height) ;
    createWindow(options);
}

/**
 *
 * @param title
 * @param addurl
 * @param width
 * @param height
 */
function addWizardWin(title, addurl, width, height) {
    var wizardOptions = {
        btn: ['<i class="fa fa-chevron-left"></i> 上一步' , '<i class="fa fa-chevron-right"></i> 下一步' ,'<i class="fa fa-save"></i> 提交', '<i class="fa fa-close"></i> 取消'],
        success: _successLoad ,
        yes :_prevFunc,
        btn2 : _nextFunc,
        btn3: _submitForm
    };

    var defaultOptions = _getDefaultWinodwOptions(title , addurl , width, height) ;
    var options = $.extend(defaultOptions , wizardOptions);

    createWindow(options);
}

/**
 * 更新事件打开窗口
 * @param title 编辑框标题
 * @param url //目标页面地址
 * @param id//主键字段
 */
function update(title, url, id, width, height, isRestful) {

    if (id) {
        if(isRestful!='undefined'&&isRestful){
            url += '/'+id;
        }else{
            if (url.indexOf("?") == -1 ) {
                url += '?id='+id;
            } else {
                url += '&id='+id;
            }
        }
    }

    var options = _getDefaultWinodwOptions(title , url , width, height) ;

    createWindow(options);
}

/**
 * 如果页面是详细查看页面，无效化所有表单元素，只能进行查看
 */
//todo
// $(function(){
// 	if(location.href.indexOf("load=detail")!=-1){
// 		$(":input").attr("disabled","true");
// 	}
// });

/**
 * 查看详细事件打开窗口
 * @param title 查看框标题
 * @param url//目标页面地址
 * @param tableDom
 */
function detail(title,url, tableDom ,width,height) {
    var id = getTableSelectedIdArr(tableDom  , true , false) ;
    if (id && id.length === 0) {
    	return ;
	}

    url += '?id='+ id[0];

    var detailOptions = {
        btn: ['<i class="fa fa-close"></i> 取消'],
        yes :null
    };

    var defaultOptions = _getDefaultWinodwOptions(title , url , width, height) ;
    var options = $.extend(defaultOptions , detailOptions);

    createWindow(options);
}

/**
 * 多记录刪除请求
 * @param title
 * @param url
 * @param tableSelector
 * @return
 */
function deleteALLSelect(url, tableSelector) {
    var idArr = getTableSelectedIdArr(tableSelector);
    if (idArr.length > 0) {
        delObj(url, {idArr: idArr})
    } else {
        // tip("请选择需要删除的数据");
    }
}

/**
 * 返回id数组
 * @param tableDom
 * @param singleFlag
 * @param allowEmpty
 */
function getTableSelectedIdArr(tableDom, singleFlag, allowEmpty) {
    var idArr = [] ;
    var items = $(tableDom).data("bootstrap.table").getSelections();
    var checkedNum = items.length;
    if (allowEmpty && checkedNum == 0) {
        return idArr;
    }
    if (checkedNum == 0) {
        tip('请选择要进行操作的数据！');
        return idArr;
    }
    if (singleFlag && singleFlag == true) {
        if (checkedNum > 1) {
            tip('只能选择一条数据进行操作！');
            return idArr;
        }
    }

    for (var i in items) {
        var item = items[i];
        idArr.push(item['id']) ;
    }

    return idArr;
}

/**
 * 返回id以逗号分隔的字符串
 * @param tableDom
 * @param singleFlag
 * @param allowEmpty
 */
function getTableSelectedIds(tableDom, singleFlag, allowEmpty) {
	var ids = "";
	var idArr = getTableSelectedIdArr(tableDom , singleFlag , allowEmpty) ;
	if ($.isArray(idArr)) {
        ids = idArr.join(',') ;
	}

	return ids ;
}

/**
 * 删除调用函数
 * @param url
 * @param parameter
 */
function delObj(url,parameter) {
    createDialog('删除确认', '您『确定』删除当前选中的所有记录吗？', url, parameter);
}

// 删除调用函数
// function confuploadify(url, id) {
// 		$.dialog.setting.zIndex = getzIndex(true);
// 	$.dialog.confirm('确定删除吗', function(){
// 		deluploadify(url, id);
// 	}, function(){
// 	});
// }
/**
 * 执行删除附件
 * 
 * @param url
 * @param index
 */
// function deluploadify(url, id) {
// 	$.ajax({
// 		async : false,
// 		cache : false,
// 		type : 'POST',
// 		url : url,// 请求的action路径
// 		error : function() {// 请求失败处理函数
// 		},
// 		success : function(data) {
// 			var d = $.parseJSON(data);
// 			if (d.success) {
// 				$("#" + id).remove();// 移除SPAN
// 				m.remove(id);// 移除MAP对象内字符串
// 			}
//
// 		}
// 	});
// }

// 普通询问操作调用函数
function confirm(url, content,name) {
	createDialog('提示信息 ', content, url,name);
}

/**
 * 提示信息
 * @param msg
 * @param autoClose 是否自动关闭提示信息
 * @param time 自动关闭所需毫秒 , 默认为1200毫秒
 */
function tip(msg , autoClose , time) {
    var options = {title : '提示信息' , icon: 0 } ;
    if (autoClose) {
        if (time) {
            time = 1200 ;
        }
        options.time = time ;
    }
    layer.alert(msg, options);
}

/**
 * 成功操作提示信息
 * @param msg
 */
function successMsgTip(msg) {
    layer.msg(msg, {icon: 1, time: 1200});
}

/**
 * 错误消息提示
 * @param msg
 */
function errorMsgTip(msg) {
    layer.alert(msg, {title : '错误' , icon: 2});
}

/**
 * 创建添加或编辑窗口
 * @param options
 */
function createWindow(options) {
    var width = options.width ? options.width : 700;
    var height = options.height ? options.height : 400;
    if (width == "100%" || height == "100%") {
        width = window.top.document.body.offsetWidth;
        height = window.top.document.body.offsetHeight - 100;
    }

    var options = $.extend({
        zIndex: getzIndex(),
        opacity : 0.3,
        cache:false,
        type: 2,
        area: [width, height],
        offset:'200px',
        fixed: false, //不固定
        maxmin: false
    } , options);

    if(typeof(windowapi) == 'undefined'){
        layer.open(options);
    }else{
        $.extend(options , {
            parent:windowapi
        });
        W.layer.open(options);
    }
}

/**
 *
 * @param title
 * @param url
 * @param width
 * @param height
 * @returns {{title: *, width: *, height: *, content: *, btn: [string,string], success: _successLoad, yes: _submitForm}}
 * @private
 */
function _getDefaultWinodwOptions(title , url , width, height) {
    var options = {
        title:title,
        width : width ,
        height : height ,
        content: url ,
        btn: ['<i class="fa fa-save"></i> 提交', '<i class="fa fa-close"></i> 取消'],
        success: _successLoad ,
        yes :_submitForm
    };

    return options ;
}

var _successLoad = function(layero, index){
    var body = layer.getChildFrame('body', index);
    var form = body.find( "form:first" );

    form.validator({
        valid: function(form) {
            //todo
        }
    });
};

var _prevFunc = function (index, layero) {
    var iframeWin = window[layero.find('iframe')[0]['name']]; //
    if ($.isFunction(iframeWin.navigatePrev)) {
        iframeWin.navigatePrev();
    } else {
        errorMsgTip('未找到navigatePrev()方法');
    }

    return false;
} ;

var _nextFunc = function (index, layero) {
    var iframeWin = window[layero.find('iframe')[0]['name']]; //
    if ($.isFunction(iframeWin.navigateNext)) {
        iframeWin.navigateNext();
    } else {
        errorMsgTip('未找到navigateNext()方法');
    }

    return false;
} ;

var _submitForm = function(index, layero){
    var body = layer.getChildFrame('body', index);
    var form = body.find( "form:first" );

    // 检查表单
    if (form.isValid()) {
        //验证通过后，才能提交
        var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();

        //runBeforeSubmit: 提交之前，可重写此方法以获取额外参数设置与数据校验
        if ($.isFunction(iframeWin.runBeforeSubmit)) {
            if (!iframeWin.runBeforeSubmit(form)) {
                return ;
            }
        }

        // var me = this;
        // // 提交表单之前，hold住表单，防止重复提交
        // me.holdSubmit(true);

        var action = form.attr("action");
        var method = form.attr("method") || 'post';

        $.ajax({
            url: action,
            data: $(form).serialize(),
            type: method,
            success: function(response) {

                if (response.state) {
                    if ($.isFunction(iframeWin.runAfterSubmitSuccess)) {
                        iframeWin.runAfterSubmitSuccess(response);
                    }

                    parent.layer.close(index);
                    successMsgTip(response.msg) ;
                } else {
                    errorMsgTip(response.msg);
                }

                //todo
                if ($.isFunction(iframeWin.runAfterSubmit)) {
                    iframeWin.runAfterSubmit(response);
                }

                // 提交表单成功后，释放hold
                // me.holdSubmit(false);
            }
        });

    } else {
        tip("表单校验未通过，请检查输入。");
    }

};

/**
 * 创建上传页面窗口
 * 
 * @param title
 * @param addurl
 * @param saveurl
 */
// function openuploadwin(title, url,name,width, height) {
// 	gridname=name;
// 	$.dialog({
// 	    content: 'url:'+url,
// 		zIndex: getzIndex(),
// 	    cache:false,
// 	    button: [
// 	        {
// 	            name: "开始上传",
// 	            callback: function(){
// 	            	iframe = this.iframe.contentWindow;
// 					iframe.upload();
// 					return false;
// 	            },
// 	            focus: true
// 	        },
// 	        {
// 	            name: "取消上传",
// 	            callback: function(){
// 	            	iframe = this.iframe.contentWindow;
// 					iframe.cancel();
// 	            }
// 	        }
// 	    ]
// 	});
// }

/**
 * 创建查询页面窗口
 * 
 * @param title
 * @param addurl
 * @param saveurl
 */
// function opensearchdwin(title, url, width, height) {
// 	$.dialog({
// 		content: 'url:'+url,
// 		zIndex: getzIndex(),
// 		title : title,
// 		lock : true,
// 		height : height,
// 		cache:false,
// 		width : width,
// 		opacity : 0.3,
// 		button : [ {
// 			name : '查询',
// 			callback : function() {
// 				iframe = this.iframe.contentWindow;
// 				iframe.searchs();
// 			},
// 			focus : true
// 		}, {
// 			name : '取消',
// 			callback : function() {
//
// 			}
// 		} ]
// 	});
// }

/**
 * 创建询问窗口
 * @param title
 * @param content
 * @param url
 */
function createDialog(title, content, url, parameter) {
	// $.dialog.setting.zIndex = getzIndex(true);
    layer.confirm(content, {icon: 3, title:title}, function(index){
        doSubmit(url,parameter);
        layer.close(index);
    });

}

/**
 * 执行操作
 * @param url
 * @param index
 */
function doSubmit(url, parameter) {
	var paramsData = parameter;
	//把URL转换成POST参数防止URL参数超出范围的问题
	if(!paramsData){
		paramsData = new Object();
		if (url.indexOf("&") != -1) {
			var str = url.substr(url.indexOf("&")+1);
			url = url.substr(0,url.indexOf("&"));
			var strs = str.split("&");
			for(var i = 0; i < strs.length; i ++) {
				paramsData[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
			}
		}      
	}

	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		data : paramsData,
		url : url,// 请求的action路径
		error : function() {// 请求失败处理函数
		},
		success : function(result) {
			if (result.state) {
                reloadTable();
                var msg = result.msg;
                tip(msg);
			} else {
				tip(result.msg);
			}
		}
	});
	
	
}

// function opensubwin(title, url, saveurl, okbutton, closebutton) {
// 	$.dialog({
// 		content: 'url:'+url,
// 		zIndex: getzIndex(),
// 		title : title,
// 		lock : true,
// 		opacity : 0.3,
// 		button : [ {
// 			name : okbutton,
// 			callback : function() {
// 				iframe = this.iframe.contentWindow;
// 				win = frameElement.api.opener;// 来源页面
// 				$('#btn_sub', iframe.document).click();
// 				return false;
// 			}
// 		}, {
// 			name : closebutton,
// 			callback : function() {
// 			}
// 		} ]
//
// 	});
// }

// function openauditwin(title, url, saveurl, okbutton, backbutton, closebutton) {
// 	$.dialog({
// 		content: 'url:'+url,
// 		zIndex: getzIndex(),
// 		title : title,
// 		lock : true,
// 		opacity : 0.3,
// 		button : [ {
// 			name : okbutton,
// 			callback : function() {
// 				iframe = this.iframe.contentWindow;
// 				win = $.dialog.open.origin;// 来源页面
// 				$('#btn_sub', iframe.document).click();
// 				return false;
// 			}
// 		}, {
// 			name : backbutton,
// 			callback : function() {
// 				iframe = this.iframe.contentWindow;
// 				win = frameElement.api.opener;// 来源页面
// 				$('#formobj', iframe.document).form('submit', {
// 					url : saveurl + "&code=exit",
// 					onSubmit : function() {
// 						$('#code').val('exit');
// 					},
// 					success : function(r) {
// 						$.dialog.tips('操作成功', 2);
// 						win.location.reload();
// 					}
// 				});
//
// 			}
// 		}, {
// 			name : closebutton,
// 			callback : function() {
// 			}
// 		} ]
//
// 	});
// }

/**
 * 获取Cookie值
 * @param c_name
 * @returns {string}
 */
function getCookie(c_name) {
	if (document.cookie.length > 0) {
		c_start = document.cookie.indexOf(c_name + "=")
		if (c_start != -1) {
			c_start = c_start + c_name.length + 1
			c_end = document.cookie.indexOf(";", c_start)
			if (c_end == -1)
				c_end = document.cookie.length
			return unescape(document.cookie.substring(c_start, c_end))
		}
	}
	return ""
}

/**
 * 设置 cookie
 * @param c_name
 * @param value
 * @param expiredays
 */
function setCookie(c_name, value, expiredays){
	var exdate=new Date();
	exdate.setDate(exdate.getDate() + expiredays);
	document.cookie=c_name+ "=" + escape(value) + ((expiredays==null) ? "" : ";expires="+exdate.toGMTString());
}

// function createTabId(str) {
//     var val = "";
//     for (var i = 0; i < str.length; i++) {
//         val += str.charCodeAt(i).toString(16);
//     }
//     return val;
// }

// 添加标签
//todo
// function addOneTab(subtitle, url, icon) {
// 	var indexStyle = getCookie("JEECGINDEXSTYLE");
// 	if(indexStyle=='sliding'||indexStyle=='bootstrap'){
// 		//shortcut和bootstrap风格的tab跳转改为直接跳转
// 		window.location.href=url;
// 	}else if(indexStyle=='acele'||indexStyle=='ace'){
// 		var id = "";
// 		//if(url.indexOf("=")!=-1){
// 		//	id = url.substring(url.indexOf("=")+1);
// 		//}else{
// 			id = createTabId(subtitle);
// 		//}
// 		window.top.addTabs({id:id,title:subtitle,close: true,url: url});
// 	}else if(indexStyle=='hplus'){
// 		var id = "";
// 		id = createTabId(subtitle);
// 		window.top.addTabs({id:id,title:subtitle,close: true,url: url});
// 	}else{
// 		if (icon == '') {
// 			icon = 'icon folder';
// 		}
// 		window.top.$.messager.progress({
// 			text : '页面加载中....',
// 			interval : 300
// 		});
// 		window.top.$('#maintabs').tabs({
// 			onClose : function(subtitle, index) {
// 				window.top.$.messager.progress('close');
// 			}
// 		});
// 		if (window.top.$('#maintabs').tabs('exists', subtitle)) {
// 			window.top.$('#maintabs').tabs('select', subtitle);
// 			if (url.indexOf('isHref') != -1) {
// 				window.top.$('#maintabs').tabs('update', {
// 					tab : window.top.$('#maintabs').tabs('getSelected'),
// 					options : {
// 						title : subtitle,
// 						href:url,
// 						//content : '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:99.4%;"></iframe>',
// 						closable : true,
// 						icon : icon
// 					}
// 				});
// 			}else {
// 				window.top.$('#maintabs').tabs('update', {
// 					tab : window.top.$('#maintabs').tabs('getSelected'),
// 					options : {
// 						title : subtitle,
// 						content : '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:99.4%;"></iframe>',
// 						//content : '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:99.4%;"></iframe>',
// 						closable : true,
// 						icon : icon
// 					}
// 				});
// 			}
// 		} else {
// 			if (url.indexOf('isHref') != -1) {
// 				window.top.$('#maintabs').tabs('add', {
// 					title : subtitle,
// 					href:url,
// 					closable : true,
// 					icon : icon
// 				});
// 			}else {
// 				window.top.$('#maintabs').tabs('add', {
// 					title : subtitle,
// 					content : '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:99.4%;"></iframe>',
// 					closable : true,
// 					icon : icon
// 				});
// 			}
// 		}
// 	}
// }
// 关闭自身TAB刷新父TABgrid
// function closetab(title) {
// 	//暂时先不刷新
// 	window.top.$('#maintabs').tabs('close', title);
// }
