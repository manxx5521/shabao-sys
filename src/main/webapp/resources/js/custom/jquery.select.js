var widgetsSelect = $.widget("ui.asiainfoSelect", {
	version : "1.0.0-beta.1",
	delay : 300,
	options : {
		id : '#select1',
		element_id:'12345679',
		listeners : [ ],//当自己改变时，要通知刷新的列表
		fireParam:[ ], //当自己刷新时，要传入的参数
		reName:{},
		data:{},
		minimumResultsForSearch: Infinity,  //隐藏搜索框
		fireevent:[]
	},
	_create : function() {
		this._getSelectData(this.options.id,this.options.element_id,this.options.key);
		
		this._on( $(this.options.id), {
			  "change":function( event ) {
				  this.fireListener()
			  }
		});
	},
	_getSelectData: function(id,element_id,key){
		_getSelectData(id,element_id,key,null);
	},
	_getSelectData : function(id,element_id,key,params){
		// 提交表单
		$this=this;
		$.ajax({
			type : "POST",
			url : "/shabao-sys/select/select.html",
			data : {
				element_id : element_id,
				json:params
			},
			async:false,
			dataType : "json",
			success : function(data) {
				$this.options.data=data;
				$this._resData($this.options);
			},
			error : function(info) {
				console.log("请求下拉框数据失败！")
			}
		});
	},
	_resData:function(options){
		$this=this;
		var fireevent=this.options.fireevent;
		$(options.id).val(null).trigger("change"); 
		$(options.id).select2(options);
		/*
		$(options.id).on("change", function() {
			
		});
		*/
	},
	_resSelect:function(element_id,param_id){
		var list=param_id;
		var rs='[';
		var size=list.length-1;
		for(i in list){
			rs+='{\"name\":\"';
			var idx=$.inArray("js", this.options.reName);
			if(idx==-1){
				rs+=list[i];
			}else{
				rs+=this.options.reName[idx];
			}
			rs+='\",\"value\":\"'+$('#'+list[i]).val()+'\"}';
			if(size!=i){
				rs+=',';
			}
		}
		rs+=']';
		console.log(rs);
		var reparam=
		
		this._getSelectData(this.options.id,element_id,null,rs);
	},
	refreshdata : function() {
		this._resSelect(this.options.element_id,this.options.fireParam)
	},
	fireListener : function() {//通知别人刷新
		for (i in this.options.listeners) {
			
			$('#'+this.options.listeners[i]).asiainfoSelect("refreshdata");
		}
	}
});