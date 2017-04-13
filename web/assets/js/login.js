function login(){
	//获取参数
	var phone = $.trim($("#phone").val());
	var password = md5Encrypt($.trim($("#password").val()));
	console.log("password:"+password+"\n长度:"+password.length);
		if(phone && password){
			$.ajax({
				url : 'user/Login',
				data : {'phone': phone,'password': password},
				type:'POST',
				success : function(data) {
					if(data == "pwdError"||data=="phoneError"){
						alert("用户名或密码错误");
					}else if(data.role == "2"){
						$.cookie("user",JSON.stringify(data));
						var user=JSON.parse($.cookie("user"));
						console.log($.cookie("user"));
						console.log("Id："+user.userid+"昵称："+data.name+"手机号："+data.phone+"性别："+data.gender);
				    	location.href = "index.html";
					}else if(data.role == "1"){
						$.cookie("user",JSON.stringify(data));						
						console.log("Id："+data.id+"昵称："+data.name+"手机号："+data.phone+"性别："+data.gender);
				    	location.href = "index-guest.html";
					}else if(data.role == "3"){
						$.cookie("user",JSON.stringify(data));
						location.href = "index-doctor.html";
					}
				},
				error : function(data) {
//					alert("error:"+data);
					alert("系统错误");
				}
//				complete: function(data) {
//					alert(eval(data));
//				}
			});
	}
}
function logged(){
	var user=JSON.parse($.cookie("user"));
	var phone = user.phone;
	var name = user.name;
	var gender = user.gender;
	var Id = user.userid;
	var role =user.role;
	console.log(user);
	console.log("保持登录{"+" id:"+Id+" 手机号:" +phone+" 昵称:"+name+" 角色:"+role)+" }";
}
