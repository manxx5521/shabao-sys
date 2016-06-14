var widgetFile = $.widget("ui.asiainfoFile", {
	version : "1.0.0-beta.1",
	defaultElement : "<div>",
	delay : 300,
	options : {
		id : '#test1',
		name:'test1',
		filename:'file', //上传文件时的名字
		element_id:'12345679',
		listeners : [],//当自己改变时，要通知刷新的列表
		filterfields:[], //当自己刷新时，要传入的参数 {selector:'#test1',type:'select'}
		url:'/asiainfo-workflow/file/upload.jhtml',
		swf: '/asiainfo-workflow/resources/js/uploadify/uploadify.swf',
		button_image_url: '/asiainfo-workflow/resources/js/uploadify/img/kong.png',
		b_width:120,
		b_height:30,
		h_btn_name:'附件列表',
		pop_btn_name:'上传附件',
		h_text_value:'',	//页面显示附件列表
		h_value:'',//页面传值
	},
	
	_create : function() {
		//初始化参数
		if(this.options.default_value!=undefined){
			var y_value=this.options.default_value;
			var list=y_value.split('|');
			var onelist;
			var y_name='';
			var t='';
			for(var i=0;i<list.length;i++){
				t=list[i];
				onelist=t.split(':');
				y_name+=onelist[1];
				if(i!=list.length-1){
					y_name+=';'
				}
			 }
			this.options.h_text_value=y_name;
			this.options.h_value=y_value;
		}
		
		//画页面
		this._initHtml();
		
	},
	_initHtml:function(){
		
		//添加html内容
		var h_text_id=this.options.name+'_h_text';
		this.options.h_text_id=h_text_id;
		var h_text=$('<input type="text" id="'+h_text_id+'" value="'+this.options.h_text_value+'"/>');
		$('#'+h_text_id).css("float","left");
		
		var h_value_id=this.options.name+'_h_value';
		this.options.h_value_id=h_value_id;
		var h_value=$('<input type="hidden" id="'+h_value_id+'" name="'+this.options.name+'" value="'+this.options.h_value+'" />');
		$('#'+h_text_id).css("float","left");
		
		var h_btn_id=this.options.name+'_h_btn';
		this.options.h_btn_id=h_btn_id;
		var h_btn=$('<input type="button" id="'+h_btn_id+'" value="'+this.options.h_btn_name+'"/>');
		$('#'+h_btn_id).css("float","left");
		
		//添加num序列
		var index_num=$('<input type="hidden" id="index_num_'+this.options.name+'" name="index_num_'+this.options.name+'"  value="0" />');
		this.options.tr_num_id='tr_num_'+this.options.name;
		$(this.options.id).append(h_text).append(h_btn).append(h_value).append(index_num);
		
		//添加弹出框
		var pop_div_id=this.options.name+'_pop_div';
		var pop_div=$('<div id="'+pop_div_id+'"></div>');
		pop_div.css({
			width:'300px',
			height:'100px',
			'background-color':'#fff',
			'font-size': '12px',
			position: 'fixed',
			top: '10%',
			right: '35%',
			'_position': 'absolute',
			'z-index': '1500',
			'border-radius': '5px 5px 5px 5px',
			display: 'none',
			border:'1px solid #000',
			padding:'5px',
			overflow:'scroll'
		});
		/*
		var pop_text_id=this.options.name+'_pop_text';
		this.options.pop_text_id=pop_text_id;
		var h_text=$('<input type="text" id="'+h_text_id+'" name="'+this.options.filename+'_value" style="float:left;"/>');
		
		var pop_btn_id=this.options.name+'_pop_btn';
		this.options.pop_btn_id=pop_btn_id;
		var pop_btn=$('<input type="button" id="'+pop_btn_id+'" value="'+this.options.pop_btn_name+'" style="float:left"/>');
		*/
		var pop_file_id=this.options.name+'_pop_file'; 
		this.options.pop_file_id=pop_file_id; 
		var pop_file=$('<input type="file" id="'+pop_file_id+'"name="'+this.options.filename+'">');
		
		//清空浮动
		var clear_float=$('<div style="clear:both"></div>');
		//添加table
		var pop_table_id=this.options.name+'_pop_table';
		this.options.pop_table_id=pop_table_id;
		var pop_table=$('<table id="'+pop_table_id+'"></table>');
		
		if(this.options.h_value!=''){
			var list=this.options.h_value.split('|');
			var onelist;
			var t='';
			var tr_num=0;
			//var t_value=$('#'+this.options.h_value_id).val();
			//var t_text=$('#'+this.options.h_text_id).val();
			for(var i=0;i<list.length;i++){
				var pop_tr_id=this.options.name+'_pop_trid_'+(++tr_num);
				var pop_tr=$('<tr id="'+pop_tr_id+'"></tr>');
				var pop_btd=$('<td></td>');
				t=list[i];
				onelist=t.split(':');
				pop_tr.append($('<td>'+onelist[1]+'<td>'));
				
				pop_btd.append($('<input type="button" value="删除" onclick="$(\''+this.options.id+'\').asiainfoFile(\'deltr\',{tr_id:\''+pop_tr_id+'\',value:\''+list[i]+'\',text:\''+onelist[1]+'\'})" style="float:left"/>'));
				pop_btd.append($('<input type="button" value="下载" onclick="" style="float:left"/>'));
				
				pop_tr.append(pop_btd);
				pop_table.append(pop_tr);
			 };
			 this._setNum(tr_num);
		}
		
		
		//添加弹出框元素
		pop_div.append(pop_file).append(pop_table);
		$(this.options.id).append(pop_div);
		
		//设置弹出事件
		$('#'+h_btn_id).click(function(event) {
			event.stopPropagation();
			var offset = $(event.target).offset();
			$('#'+pop_div_id).css({
				top : offset.top + $(event.target).height() + "px",
				left : offset.left
			});
			// 按钮的toggle,如果div是可见的,点击按钮切换为隐藏的;如果是隐藏的,切换为可见的。
			$('#'+pop_div_id).toggle('slow');
		});
		// 点击空白处或者自身隐藏弹出层，下面分别为滑动和淡出效果。
		$(document).click(function(event) {
			$('#'+pop_div_id).slideUp('slow')
		});
		$('#'+pop_div_id).click(function(event) {
			//$(this).fadeOut(1000)
			return false;
		});
		
		//添加上传
		$("#" + pop_file_id).uploadify({
			swf : this.options.swf,
			uploader : this.options.url,
			height : this.options.b_height,
			width : this.options.b_width,
			button_image_url:this.options.button_image_url,
			'buttonText' : this.options.pop_btn_name,
			'formData':{
				'dir' : 'attached',
				'pop_table_id':this.options.pop_table_id,
				'h_value_id':this.options.h_value_id,
				'h_text_id':this.options.h_text_id,
				'id':this.options.id,
				'name':this.options.name
			},
			/*
			 'onUploadStart' : function(file) {
		            $("#"+pop_file_id).uploadify("settings", "dir", 'attached');

			 },
			 */
			//上传到服务器，服务器返回相应信息到data里
			'onUploadSuccess' : function(e, data) {
				var jsondata = $.parseJSON(data);
				//alert('123');
				$this=this;
				$formData=this.settings.formData;
				
				var t_value=jsondata.url+':'+jsondata.name;
				var t_text=jsondata.name;
				var h_value=$('#'+$formData.h_value_id).val();
				if(h_value!=''&&h_value!=null&&h_value!=undefined){
					t_value='|'+t_value;
					t_text=';'+t_text;
				}
				t_value=$('#'+$formData.h_value_id).val()+t_value;
				t_text=$('#'+$formData.h_text_id).val()+t_text;
				
				var tr_num=this._getNum();
				var table_id=$formData.pop_table_id;
				var pop_tr_id=$formData.name+'_pop_trid_'+(++tr_num);
				var pop_tr=$('<tr id="'+pop_tr_id+'"></tr>');
				pop_tr.append($('<td>'+jsondata.name+'<td>'));
				var pop_btd=$('<td></td>');
				pop_btd.append($('<input type="button" value="删除" onclick="$(\''+$formData.id+'\').asiainfoFile(\'deltr\',{tr_id:\''+pop_tr_id+'\',value:\''+t_value+'\',text:\''+t_text+'\'})" style="float:left"/>'));
				pop_btd.append($('<input type="button" value="下载" onclick="" style="float:left"/>'));
				pop_tr.append(pop_btd);
				$('#'+table_id).append(pop_tr);

				$('#'+$formData.h_value_id).val(t_value);
				$('#'+$formData.h_text_id).val(t_text);
				this._setNum(tr_num); //待解决
			}
			,
			'onUploadComplete' : function(file, data) {
	        }
		});
		
	},
	_destroy: function() {
        this.element
            .removeClass("asiainfoFile")
            .val("");
    },
    deltr:function(data){
    	var tr_id=data.tr_id;
    	var text=data.text;
    	var value=data.value;
    	$('#'+tr_id).remove();
    	var t_value=$('#'+this.options.h_value_id).val();
    	var idx_value=t_value.indexOf(value);
    	var next_value=t_value.substr(idx_value+value.length,1);
    	if(next_value=='|'){
    		value+="|";
    	}else if(next_value==""&&t_value.length>value.length){
    		value='|'+value;
    	}
    	$('#'+this.options.h_value_id).val(t_value.replace(value,''));
    	var t_text=$('#'+this.options.h_text_id).val();
    	var idx_text=t_text.indexOf(text);
    	var next_text=t_text.substr(idx_text+text.length,1);
    	if(next_text==';'){
    		text+=";";
    	}else if(next_text==""&&t_text.length>text.length){
    		text=';'+text;
    	}
    	$('#'+this.options.h_text_id).val(t_text.replace(text,''));
    	
    },
    _getNum:function(){
    	return $('#'+this.options.tr_num_id).val();
    },
    _setNum:function(num){
    	$('#'+this.options.tr_num_id).val(num);
    },
	refreshdata : function() {
	},
	fireListener : function() {//通知别人刷新
		for (i in this.options.listeners) {
			//$(this.options.listeners[i]).asiainfoSelect("refreshdata");
			var id = this.options.listeners[i].selector;
			var type = this.options.listeners[i].type;
			var pluginName = "asiainfo" + type.replace(/(\w)/,function(v){return v.toUpperCase()});
			var func = "$('"+id+"')."+pluginName+"(\"refreshdata\")";
			eval(func);
		}
	},
	
});