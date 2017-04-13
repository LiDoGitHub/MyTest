$(document).ready(function(){
	$.ajax({
		url: 'http://localhost:8080/Test-backup/FindCylopediaList',  
        type: 'post',  
        dataType: 'json',
        success:function(data){
        	  $.each(data, function(commentIndex, comment){
        		  $("#goods3").html($("#goods3").html()+ "<tr>"+
        	      "<td>"+comment['id']+"</td>"+
        	      "<td>"+'<img src='+ comment["cover"] +' width="50" height="50" border-radius="25" />' +"</td>"+
        	      "<td>"+'<img src='+ comment["icon"] +' width="120" height="50" />' +"</td>"+
        	      "<td>"+comment['title'] +"</td>"+
        	      "<td>"+'<div class="button-group"><p><span>'+comment['content']+'</span></p></div>' +"</td>"+
        	      "<td>"+comment['time']+"</td>"+
        	      "<td>"+ '<div class="button-group">'+
        	      '<a class="button border-main" href="advcreate.html"><span class="icon-edit"></span> 修改</a>'+
        	      '<a class="button border-red" href="javascript:void(0)" onclick="return del(1,1)"><span class="icon-trash-o"></span> 删除</a>'+
        	      '</div>'+ 
        		  "</td>"+
        		  "</tr>");
        	  });
        }
	});
});