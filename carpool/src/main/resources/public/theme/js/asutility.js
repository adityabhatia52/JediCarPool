/*This code is intellectual property of OpCord and its highly Confidential.*/

function setMessageTop(){
if($(window).scrollTop()>50){  

			$("#flash-message").css("position","fixed");
		}else{
			$("#flash-message").css("position","static");
		}	
}

$(document).ready(function(e) {
	$(document).keyup(function(e){
		if (e.keyCode == 27){
			hideLoader();hideAlert();
		}});
	});
	
	function checkImageExtension(file,ext){
		if (! (ext && /^(jpg|jpeg|png|gif|svg)$/.test(ext))){
			alert("file: "+file+" is not a valid image file. \nOnly images are allowed");return false;
		}else{return true;}
	}
	
	function make2digitno(no){
		if(parseInt(no)<10){
			no="0"+no ;
		}return no;
	}
	
	function showLoader(msg){
		hDW=$(window).width()/2 ;
		hDH=$(window).height()/2 ;
		$(".loaderbox").css("left",(hDW-32)+"px");
		$(".loaderbox").css("top",(hDH-32)+"px");
		$("#loader_messege").html(msg);
		$("#loaderwrapper").fadeIn();
	}
	
	function hideLoader(){
		$("#loader_messege").html("");
		$("#loaderwrapper").fadeOut();
	}
	
	function showAlert(msg){
		$("#notify_messege").html(msg);
		$("#notifywrapper").fadeIn();/*setTimeout('hideAlert()',1000);*/
		return;
	}
	
	function hideAlert(){
		$("#notifywrapper").fadeOut();
	}
	
	$(document).ready(function(e) {
		$("#notifyok").click(function(e) {hideAlert();
	});/*showAlert("test alert") ;*/
});

function hideFlashBox(){
	
	$(".flash_messages").slideUp(1000);
}	
	$(document).ready(function(e) {
		//console.log(afterLoginRedirect);
	
	setTimeout('hideFlashBox()',5000);
    
	$(document).scroll(function(e) {
        setMessageTop();
    });

	$(".remove_message, .flash_messages li").click(function(e) { 
		var msg=$(this).parent() ;
		msg.slideUp(function(){	msg.remove();});
	 });
	
	 });

function showFlashMessage(msg){ 
 errorhtml= '<ul id="flash_messages">'
errorhtml+='<li id="fm0" class="flash-message"><span></span>'+msg;
 errorhtml+='<a name="0"class="remove_message" href="javascript:;"></a></li></ul>';
 $(".flash_messages").html(errorhtml);$(".flash_messages").slideDown(500);
 $(".remove_message, .flash_messages li").click(function(e) {var msg=$(this).parent() ;msg.slideUp(function(){msg.remove();});});setTimeout('$(".flash_messages").slideUp(1000)',4000);}
 function showFlashError(msg){ 
	errorhtml= '<ul id="flash_messages">'
errorhtml+='<li id="fm0" class="flash-error"><span></span>'+msg;
 errorhtml+='<a name="0"class="remove_message" href="javascript:;"></a></li></ul>';

	$(".flash_messages").html(errorhtml);
    $(".flash_messages").slideDown(500);
	$(".remove_message, .flash_messages li").click(function(e) {
		var msg=$(this).parent() ;
		msg.slideUp(function(){
			msg.remove();
		});
    });
	//$(".flash_messages").slideUp(1000);
	setTimeout('$(".flash_messages").slideUp(1000)',4000);
}
 function showError(elem,errmsg){$("#em"+elem.attr('id')).remove();elem.parent().append('<span class="formerror" id="em'+elem.attr('id')+'" style="display:none">'+errmsg+'</span>');elem.addClass('inputalert');	
/*alert(elem.parent().offset().top+'>'+parseInt($(window).scrollTop()));alert(elem.parent().html());return false;*/if(elem.parent().offset().top<parseInt($(window).scrollTop())){$('html, body').animate({scrollTop: elem.parent().prev().offset().top}, 1000);}else{}$("#em"+elem.attr('id')).fadeIn();/*return false;alert(elem.parent().html());*/}function scrollToElement(elem){$('html, body').animate({scrollTop: parseInt(elem.offset().top)}, 1000);}var moveToError=true;function showFormError(elem,errmsg){$("#em"+elem.attr('id')).remove();elem.parent().append('<span class="formerror" id="em'+elem.attr('id')+'"style="display:none">'+errmsg+'</span>');elem.addClass('inputalert');if(!(typeof elem.parent().offset()==="undefined")){if(elem.parent().offset().top<parseInt($(window).scrollTop())){$('html, body').animate({scrollTop: elem.parent().offset().top}, 1000);}}elem.addClass("inputalert");$("#em"+elem.attr('id')).fadeIn();/*return false;alert(elem.parent().html());*/}$(document).ready(function(e) {$("input,select").each(function(){$(this).change(function(e) {if(this.value!="" && !$(this).hasClass("nochangecheck")){$("#em"+this.id).remove();$(this).removeClass('inputalert');}else{$(this).addClass('inputalert');}});});});function checkSelects(){var checkedRecords=false;$(".elem_ids").each(function(index, element) {if(this.checked==true){checkedRecords=true;}});if(!checkedRecords){alert("Please select records");return false;}}$(document).ready(function(e) {$("#chk_all").change(function(e) {chkAll=this ;$(".elem_ids").each(function(index, element) {this.checked=chkAll.checked ;});});$(".radcheckbtn").click(function(e) {radid=$(this).attr("data-radio");groupclass=$(this).attr("data-radiogroup");/*alert(document.getElementById(radid).value);*/document.getElementById(radid).checked=true;$("."+groupclass).removeClass("rbchecked");$(this).addClass("rbchecked");});if(window.FileReader){$(".filefield").css({"width":"0px","height":"0px","opacity":0});}});function resetIndexes(){$(".boxindex").each(function(i,spn){newIndex=i+1;$(this).html(newIndex)});}

function trimSpaces(str) {
	return str.replace(/^\s\s*/, '').replace(/\s\s*/, '').replace(/\s\s*$/, '');
}
function resetgroup_resonbox(){
	hDW=$(document).width()/2 ;
	hDH=$(document).height()/2 ;
	hBW=$(".group_resonbox").width()/2 ;
	hBH=$(".group_resonbox").height()/2 ;
	if(parseInt(hBW)==0){hBW=150 ;}$(".group_resonbox").css("left",(hDW-hBW)+"px");/*$("#loginregisterbox").css("right",(hDW-hBW)+"px");$(".group_resonbox").css("top",(hDH-hBH-100)+"px");*/$(".group_resonbox").css("top", "100px");
}
function prn(obj){
	str =''; 
	for (var key in obj) {
		  str+='['+key+']=>'+(obj[key])+'\n';
	}
	//alert(str);
}


function loadjscssfile(filename, filetype){
 if (filetype=="js"){ //if filename is a external JavaScript file
  var fileref=document.createElement('script')
  fileref.setAttribute("type","text/javascript")
  fileref.setAttribute("src", filename)
 }
 else if (filetype=="css"){ //if filename is an external CSS file
  var fileref=document.createElement("link")
  fileref.setAttribute("rel", "stylesheet")
  fileref.setAttribute("type", "text/css")
  fileref.setAttribute("href", filename)
 }
 if (typeof fileref!="undefined")
  document.getElementsByTagName("head")[0].appendChild(fileref)
}
 
 
function clog(data){console.log(data);} 
function cinfo(data){console.info(data);} 
function cerr(data){console.error(data);} 
function cdeb(data){console.debug(data);} 
