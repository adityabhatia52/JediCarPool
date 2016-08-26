//jQuery to collapse the navbar on scroll
/*$(".marathonlogregbox").css('display','block');
var outerboxheight=$(".marathonlogregbox").height();
var innerboxheight=$(".marathoninnerlogregbox").height();
var heightdiff=outerboxheight-innerboxheight;
var margintopbot=(heightdiff/2)+'px';
if((heightdiff/2)>100){
$(".marathoninnerlogregbox").css('margin-top','100px');
}else {
	$(".marathoninnerlogregbox").css('margin-top',margintopbot);
}
$(".marathonlogregbox").css('z-index','40');*/

$(".mycashtab").click(function(){
	$(".mycashtab").removeClass('bbottom').addClass('activebbottom');
	$(".myregtab").removeClass('activebbottom').addClass('bbottom');
});

$(".myregtab").click(function(){
	$(".myregtab").removeClass('bbottom').addClass('activebbottom');
	$(".mycashtab").removeClass('activebbottom').addClass('bbottom');
});

function flipsharetime(flipclass,work,homeh,flipid){
		$( "."+flipclass).toggleClass('addflip');
		$( "."+homeh).toggleClass('display');
		$( "."+work).toggleClass('display');
		if($("#"+flipid).val()==0){
		$("#"+flipid).val(1);
	    }else if($("#"+flipid).val()==1){
		$("#"+flipid).val(0);
	}
}

function validatetime(hrs,mins,errorspan){

	var today = new Date();
	today.setMinutes(today.getMinutes() + 5);
	var datetimeh = today.getHours();
	var datetimem = today.getMinutes();
	datetimem =  datetimem < 10 ? '0' + datetimem : datetimem;
	var timeh = parseInt($('#'+hrs).val());
	var timem = parseInt($('#'+mins).val());
	if (timeh == datetimeh) {
	if (datetimem >= timem) {
		$('.'+errorspan).html("Sorry, you can create ride only after 5 mins from current time.");
		$('.'+errorspan).show();
		$('.'+errorspan).delay(3000).fadeOut(300);
		return false;
	}else{
	$('.'+errorspan).html("");
	return 1;
	} 
	} else if (timeh < datetimeh){
		$('.'+errorspan).html("Sorry, you can create ride only after 5 mins from current time.");
		$('.'+errorspan).show();
		$('.'+errorspan).delay(3000).fadeOut(300);
		return false;
	}else{
	$('.'+errorspan).html("");
	return 1;
	}
	
	}
function sharetimeurl(url,flipyesno,hrs,mins,ridetype,errorspan){
	   if (validatetime(hrs,mins,errorspan)==1){
	
		localStorage.setItem('flipornot',$("#"+flipyesno).val());
		localStorage.setItem('gohour',$("#"+hrs).val());
		localStorage.setItem('gomins',$("#"+mins).val());
		localStorage.setItem('stridetype',$("#"+ridetype).val());
		localStorage.setItem('flagofc', "1");
		
		if(AuthLoggedId==0){
		$("#aslastact").val(url);
		pleaselogin();
		resetLoginBox();
		$(".logregbox").show();
		}else{
			window.location = url;
		}
	   }
}

function createsharetime(url,flipyesno,hrs,mins,ridetype,errorspan){
	    if(validatetime(hrs,mins,errorspan)==1){
		localStorage.setItem('cflipornot',$("#"+flipyesno).val());
		localStorage.setItem('cgohour',$("#"+hrs).val());
		localStorage.setItem('cgomins',$("#"+mins).val());
		localStorage.setItem('cstridetype',$("#"+ridetype).val());
		localStorage.setItem('flagofc', "1");
		
		if(AuthLoggedId==0){
		$("#aslastact").val(url);
		pleaselogin();
		resetLoginBox();
		$(".logregbox").show();
		}else{
			window.location = url;
		}
		}
}


$(window).scroll(function(){ 
if($("#ui-datepicker-div").is(":visible")){
    $("#ui-datepicker-div").hide();
}
});
function createQuikRide(){
	document.getElementById('shareridecreate').action=SiteHttpUrl+'/officegroup/createquickride';
	$("#shareridecreate").submit();
	}
function goBack() { window.history.back();}

$.fn.scrollView = function () {
    return this.each(function () {
        $('html, body').animate({
            scrollTop: ($(this).offset().top) - $("#navbar").height() - $("#ratabs").height() - 30
        }, 1000);
    });
}
$.fn.scrollhitw = function () {
    return this.each(function () {
        $('#hiw').animate({
            scrollTop: ($(this).offset().top)
        }, 1000);
    });
}

$(".addoptionbtn , .addoptionbtnres").click(function(){
	$("#rideoptions , #rideoptionsres").slideToggle();
	$(".addoptionbtn span span , .addoptionbtnres span span").toggleClass("display");
	$(".addoptionbtn > span , .addoptionbtnres > span").removeClass("ranewgreen");
    $(".addoptionbtn > span , .addoptionbtnres > span").toggleClass("raneworange");
});
<!--for our team page only-->
$("#readmore1 , #readless1 , #readmore1res , #readless1res").click(function(){
	$("#readhari , #readharires").toggleClass("readhari");
	$("#readmore1 , #readless1 , #readmore1res , #readless1res").toggleClass("display");
});

$("#readmore2 , #readless2 , #readmore2res , #readless2res").click(function(){
	$("#readarun , #readarunres").toggleClass("readarun");
	$("#readmore2 , #readless2 , #readmore2res , #readless2res").toggleClass("display");
});

$("#readmore3 , #readless3 , #readmore3res , #readless3res").click(function(){
	$("#readricha , #readrichares").toggleClass("readricha");
	$("#readmore3 , #readless3 , #readmore3res , #readless3res").toggleClass("display");
});

<!--end of our team page-->


$("#create_ride_a").click(function(){
	$("#offer_ride_a , #shared_taxi_a").removeClass("rideoptgreen");
    $("#create_ride_a").addClass("rideoptgreen");
});
/*$("#offer_ride_a").click(function(){
	$("#create_ride_a , #shared_taxi_a").removeClass("rideoptgreen");
    $("#offer_ride_a").addClass("rideoptgreen");
});*/
$("#shared_taxi_a").click(function(){
	$("#offer_ride_a , #create_ride_a").removeClass("rideoptgreen");
    $("#shared_taxi_a").addClass("rideoptgreen");
});


$("#switch").click(function(){
	$(".addoptionbtn span img:first-child").removeClass("display");
	$(".addoptionbtn span img ~img").addClass("display");
    $(".addoptionbtn > span").addClass("ranewgreen");
	$(".addoptionbtn > span").removeClass("raneworange");
	 $("#offer_ride_a,#create_ride_a,#shared_taxi_a").removeClass("rideoptgreen");
	$("#rideoptions").slideUp();
	
	$(".goinglistrslt").toggleClass('display');
	$("#going").toggleClass("zindexb");
	$("#coming").toggleClass("zindexb");
    $("#going , .goinglistrslt , #coming , #taxiride , #poolride").toggleClass("in active");
	$("#taxiride , #poolride , #coming , #going").toggleClass("display");
	$("#showaddrides").hide();
	$("#pooltaxirides").show();
});
function addmsg(type, msg){
	if(msg != "null" && msg != 0) {
		$("#noti_link").html(msg);
		$(".aflnotpend").css('display', 'block')
    		//'<span class="aflnotpend"> '+msg+'</span>'     
    		//"<div class='msg "+ type +"' style='float: right; margin-top: 0px;z-index:10; border:solid 1px;background-color:#03c9a9;color:#fff'>"+ msg +"</div>"
   // );
	}
}



$(document).ready(function(){
	//$("#messages").css("right", "0px");
	$("#messages").css("margin-top","110px");
	if(AuthLoggedId > 0 && window.location.href.indexOf("confirm_mobile") <0) {
		waitForMsg(); /* Start the inital request */
	}
});

function waitForMsg(){
    $.ajax({
        type: "POST",
        url: url=SiteHttpUrl+"/user/getnewnotif",
        data: 'user_id='+AuthLoggedId,
        async: true,
        cache: false,
        timeout:50000,
    
        success: function(data){ 
        	//console.log(data);
            addmsg("new", data); 
            setTimeout(
                waitForMsg,
                10000 /* ..after 10 seconds */
            );
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            //addmsg("error", textStatus + " (" + errorThrown + ")");
            setTimeout(
                waitForMsg, 
                1000); /* milliseconds (1seconds) */
        }
    });
};

$(window).resize(function(){
	if($(document).width()<=768){
	$(".any , .work , .air , .rout").addClass('collapse');	
	//$("#container2").addClass('container');
	//$("#container2").removeClass('container1');
	}else{
	$(".any , .work , .air , .rout").removeClass('collapse').slideDown();	
	//$("#container2").addClass('container1');	
	//$("#container2").removeClass('container');
	
	}
});
 //function slideups(){
//	 $('.ride , .air , .rout , .work').slideUp("slow");
// }
 $(".showsearch").click(function(){
    $(".ride , .air , .rout , .work").slideToggle("slow");
 });
$(document).ready(function(){
	
	 $(".backroute").click(function(){ window.history.go(-1);});
	

        $(".orangecolor").removeClass('nghide');
		$(".horangecolor").removeClass('nghide');
/*navigator.geolocation.getCurrentPosition(GetLocation);
function GetLocation(location) {
		$("#home_address_lat").val(location.coords.latitude);
		$("#home_address_long").val(location.coords.longitude);
 }*/
});

$('#next').click(function(){ 
var pattern =/^[a-zA-Z0-9._-]+@[a-zA-Z]+\.[a-zA-Z.]{2,5}$/;
var uEmail=$("#semail").val();
var mobnum=$('#smobile_number').val();
if(isNaN(mobnum)){
	$('#smobile_number').val('').addClass('error');
}else if(!$(".email_error").is(":visible") && !$(".login_error").is(":visible")){
			if($('#smobile_number').val().length==10 && uEmail.match(pattern) && $('#spassword').val().length>=6){
              $('#logregp3').animate({'left':-$('#innerlogregbox').width()});
              $('#logregp4').animate({'left':0});
              $("sfirst_name").focus();
			}}
           });
		   

/*$("#midnit").click(function(e) {
	$("#aslastact").val(SiteHttpUrl+'/workplace/midnightmarathon');
	$("#slastact").val(SiteHttpUrl+'/workplace/midnightmarathon');
	$("#errormsg").html("Please Login or Sign Up to proceed further!");
	$(".logregbox").show();
});

 $("#marathonoverlay , .closemarathon").click(function(){
	  $("#errormsg").html("");	 
      $(".marathonlogregbox").hide();	  
    });
	if($(".marathoninnerlogregbox").is(":visible"))
    {
		$("body").css('overflow-y','hidden');	
	}
  else{
		$("body").css('overflow-y','scroll');
	}*/

$(".btncleartxt").click(function(e) {
		//console.log($(this).prev("input").val());
		$(this).prev("input").val("");
		return false;
	});
	
	$(".btnclearinput").keyup(function () {
		var im=$(this).val().length;
       if (im>=1 && im<=3) {
          $(this).next().next('.locshint').show();
       }else if(im==0 || im>3){
		   $(this).next().next('.locshint').hide();
	   }
    });
	$(".btnclearinput").blur(function () {
		$(this).next().next('.locshint').hide();
	});
	
if($("#searchbar").is(":visible"))
    {
		$("#headersearchbar").css('display','none');
		$("#searchbar").css('display','block');	
	}
  else{
	    $("#searchbar").css('display','none');
		$("#headersearchbar").css('display','block');	
	}
/*header tabs after login*/

$("#workplacetab").click(function(){
	console.log("clear search");
	localStorage.clear();
		$("#workplacetab").addClass('transparentblack');
		$("#activetab").val('');
		$("#workplaceh").css('display', 'block');
		$("#routeh, #anywhereh, #airporth").css('display', 'none');
		$("#airporttab ,#anywheretab , #routetab").removeClass('transparentblack');
		if(AuthLoggedId==0){
			getAllData(6,0);
		}
	});
$("#airporttab").click(function(){
	console.log("clear search");
	localStorage.clear();
		$("#airporttab").addClass('transparentblack');
		$("#activetab").val('2');
		$("#airporth").css('display', 'block');
		$("#routeh, #anywhereh, #workplaceh").css('display', 'none');
		$("#workplacetab , #routetab , #anywheretab").removeClass('transparentblack');
		if(AuthLoggedId==0){
		getAllData(2,0);}
	});
$("#anywheretab").click(function(){
	console.log("clear search");
	localStorage.clear();
		$("#anywheretab").addClass('transparentblack');
		$("#activetab").val('9');
		$("#anywhereh").css('display', 'block');
		$("#routeh, #airporth, #workplaceh").css('display', 'none');
		$("#airporttab , #workplacetab ,#routetab ").removeClass('transparentblack');
		if(AuthLoggedId==0){
		getAllData(9,0);
		$('#wsource , #wdest , #wp_src_lat , #wp_src_long , #wp_src_tmp , #wp_dest_lat , #wp_dest_long , #wp_dest_tmp').val('');
		 }
	});	
$("#routetab").click(function(){
	console.log("clear search");
	localStorage.clear();
		$("#routetab").addClass('transparentblack');
		$("#activetab").val('');
		$("#routeh").css('display', 'block');
		$("#anywhereh, #airporth, #workplaceh").css('display', 'none');
		$("#airporttab , #workplacetab ,#anywheretab ").removeClass('transparentblack');
if(AuthLoggedId==0){
		getAllData(10,0); }
	});		
	
var isNormalLogin=true ;var afterLoginUrl="";
/*login box close*/
$('body').ready(function(){
    if($(".innerlogregbox").is(":visible") || $("#overlay-slider-menu").is(":visible") || $("#hiw").is(":visible") || $("#flashhelpshow").is(":visible"))
    {
		$("body").css('overflow-y','hidden');	
	}
  else{
		$("body").css('overflow-y','scroll');
	}
});
$("body").click(function(){	
     /*$("#overlay").click(function(){
	  $("#errormsg").html("");	 
      $(".logregbox").hide();	  
    });*/
	if($(".innerlogregbox").is(":visible") || $("#overlay-slider-menu").is(":visible") || $("#hiw").is(":visible") || $("#flashhelpshow").is(":visible"))
    {
		$("body").css('overflow-y','hidden');	
	}
  else{
		$("body").css('overflow-y','scroll');
	}
 });

/*login box slides*/

$('#logregp2').css('right',-$('#innerlogregbox').width()).show();
$('#logregp3').css('right',-$('#innerlogregbox').width()).show();
$('#logregp4').css('right',-$('#innerlogregbox').width()).show();
$('#logregp5').css('right',-$('#innerlogregbox').width()).show();
$('#logine').click(function(){
    $('#logregp1').animate({'left':-$('#innerlogregbox').width()});
   	$('#logregp2').css('z-index','90');
	$('#logregp3').css('z-index','80');
    $('#logregp2').animate({'left':0});
});

$('#signupe').click(function(){
    $('#logregp1').animate({'left':-$('#innerlogregbox').width()});
   	$('#logregp2').css('z-index','80');
	$('#logregp3').css('z-index','90');	
    $('#logregp3').animate({'left':0});
    $("#semail").focus();
    $("#semail").removeClass('error');
});
$('#loginback').click(function(){
    $('#logregp2').animate({'left':$('#innerlogregbox').width()});
    $('#logregp1').animate({'left':0});
});
$('#signupback1').click(function(){
    $('#logregp3').animate({'left':$('#innerlogregbox').width()});
    $('#logregp1').animate({'left':0});
});
$('#signupback2').click(function(){
    $('#logregp4').animate({'left':$('#innerlogregbox').width()});
    $('#logregp3').animate({'left':0});
});
$('#signupback3').click(function(){
    $('#logregp5').animate({'left':$('#innerlogregbox').width()});
    $('#logregp4').animate({'left':0});
	
});
$('#signupback5').click(function(){ 
    $('#logregp2').css('z-index','90');
	$('#logregp3').css('z-index','80');
    $('#logregp3').animate({'left':-$('#innerlogregbox').width()});
    $('#logregp2').animate({'left':0});
    $("#asemail").focus();
    $("#asemail").removeClass('error');
});
$('#signupback6').click(function(){
	$('#logregp2').css('z-index','90');
	$('#logregp4').css('z-index','80');
    $('#logregp4').animate({'left':-$('#innerlogregbox').width()});
    $('#logregp2').animate({'left':0});
    $("#asemail").focus();
    $("#asemail").removeClass('error');
});
$('#signupback4').click(function(){
	$('#logregp2').css('z-index','80');
	$('#logregp3').css('z-index','90');
    $('#logregp2').animate({'left':-$('#innerlogregbox').width()});
    $('#logregp3').animate({'left':0});
    $("#semail").focus();
    $("#semail").removeClass('error');
    $(".login_error").html('');
});


$('#lrbbtnsignup').click(function(){
	if($("#sfirst_name").val()==""){
			$("#sfirst_name").addClass('error');
			$("#sfirst_name").focus();
		}
	if($("#slast_name").val()==""){
			$("#slast_name").addClass('error');
		}
	if($("#uhome_address").val()==""){
			$("#uhome_address").addClass('error');
			$("#uhome_address").focus();
		}
});

$('#loginback , #signupback1').click(function(){
	$("#innerlogregbox input").removeClass('ng-touched used error').addClass('ng-untouched');
	$("#innerlogregbox form").removeClass('ng-submitted');
	$("#next").attr('disabled','disabled');
	$(".error , .email_error").addClass('ng-hide');
	$(".login_error").html('');
	$("#innerlogregbox input[type='password'] , input[type='email'] ,  input[type='text']").val('');
	$("#lrbbtnsignup").val('SIGN UP');
	$("#lrbbtnlogin").val('LOGIN');
});

$('#closels , #closelsres').click(function(){
	$("#innerlogregbox input").removeClass('ng-touched used error').addClass('ng-untouched');
	$("#innerlogregbox form").removeClass('ng-submitted');
	$("#next").attr('disabled','disabled');
	$(".error , .email_error").addClass('ng-hide');
	$(".login_error").html('');
	$("#innerlogregbox input[type='password'] , #innerlogregbox input[type='email'] , #innerlogregbox input[type='text']").val('');
	$("#lrbbtnsignup").val('SIGN UP');
	$("#lrbbtnlogin").val('LOGIN');
	clearval();
	$("#errormsg").html("");
    $('.logregbox').css('display','none'); 

});
 
$(window, document, undefined).ready(function() {

var url = window.location.href; 
if(url.indexOf('#login')!=-1){
  $("#errormsg").html("Please Login or Sign Up to proceed further!");
  $(".logregbox").show();
}
$('#semail').on('keypress', function(){
var uEmail=$(this).val() ;
var $this = $(this);

        var pattern =/^[a-zA-Z0-9._-]+@[a-zA-Z]+\.[a-zA-Z.]{2,5}$/;
		if (!uEmail.match(pattern)){
			$this.addClass('error');
			$(".errorem").removeClass('ng-hide');
			
		}
});

  $('#innerlogregbox input').blur(function() {
    var $this = $(this);
	if ($this.val()==""){
		$this.addClass('error');
	}
    if ($this.val()){
      $this.addClass('used');
	}else{
      $this.removeClass('used');
	}
  });
});

function checknummsp(e)

{ 
  //document.getElementById("next").style.display = "none";
  var charCode = (e.which) ? e.which : e.keyCode;

   if (charCode > 31 && (charCode < 48 || charCode > 57)) {

    return false;

  }
 
	

}

/*for popups*/
$('#poped input').blur(function() {
    var $this = $(this);
	
    if ($this.val()){
      $this.addClass('used');
	}else{
      $this.removeClass('used');
	}
  });
/*search bar click on button effect */

$(document).ready(function(){
	'use strict';
/*	$('#subsearchwork').css('left',-$('#f1_container1').width()).show();
	$('#subsearchair').css('left',-$('#f1_container').width()).show();
$('#mainsearchwork').click(function(){
    $('#mainsearchwork').animate({'right':-$('#f1_container1').width()});
    $('#subsearchwork').animate({'left':0});
});
$('#mainsearchairport').click(function(){
    $('#mainsearchairport').animate({'right':-$('#f1_container').width()});
    $('#subsearchair').animate({'left':0});
});

$("#f1_container1").mouseenter(function(){
	$('#subsearchwork').animate({'left':0});
	//$('#mainsearchwork').animate({'right':-380+'px'});
	//$(this).animate({'right':-$("#subsearchwork").width()});
});

$("#f1_container1").mouseleave(function(){
	$('#mainsearchwork').animate({'right':0});
	//$('#mainsearchwork').remove({'right':0});
	//$('#subsearchwork').animate({'left':380+'px'});
	//$(this).animate({'right':-$("#subsearchwork").width()});
});
$('#mainsearchwork').mouseenter(function(){
    $('#mainsearchwork').animate({'right':-$('#f1_container1').width()});
    $('#subsearchwork').animate({'left':0});
});

$('#mainsearchairport').mouseenter(function(){
    $('#mainsearchairport').animate({'right':-$('#f1_container').width()});
    $('#subsearchair').animate({'left':0});
});

$('#wpsearch , #airsearch , #anysearch').click(function(){

    $('#subsearchair').animate({'left':-$('#f1_container').width()});
	$('#subsearchwork').animate({'left':-$('#f1_container1').width()});
    $('#mainsearchairport').animate({'right':0});
	$('#mainsearchwork').animate({'right':0});
	
});*/

/*airport flip textboxes*/
	
	var flipit = false;
	
	if($(document).width()>=768){
		$("#flip").attr('src',ThemeHttpUrl+'/images/filp_h_orange.png');
    $("#flip").click(function(){
		$("#taxi_ride_src").attr('placeholder','Drop me at..');
		
		if(flipit==false){
			flipit = true;
		$("#taxi_ride_src").attr('name','taxi_ride_dest');
		$("#taxi_ride_dest").attr('name','taxi_ride_src');	
		$("#taxi_ride_dest").attr('ng-model','airsource');
		$("#taxi_ride_src").attr('ng-model','airdest');
		$("#flipleftinput #taxi_ride_src").attr('id','taxi_ride_dest');
		$("#fliprightinput #taxi_ride_dest").attr('id','taxi_ride_src');
        $("#flipleftinput").animate({
            left: '53.5%'
        });
      $("#fliprightinput").animate({
            right: '53.5%'
        });
	 }else{
	    $("#taxi_ride_src").attr('name','taxi_ride_dest');
		$("#taxi_ride_dest").attr('name','taxi_ride_src');
		$("#taxi_ride_dest").attr('ng-model','airsource');
		$("#taxi_ride_src").attr('ng-model','airdest');
        $("#fliprightinput #taxi_ride_src").attr('id','taxi_ride_dest');
		$("#flipleftinput #taxi_ride_dest").attr('id','taxi_ride_src');
		
		 	flipit = false;
			$("#taxi_ride_src").attr('placeholder','Pick me up at..');
		
        $("#flipleftinput").animate({
            left: '0px'
        });
      $("#fliprightinput").animate({
            right: '0px'
        });
	 }
   });
	} else {
	$("#flip").attr('src',ThemeHttpUrl+'/images/filp_v_orange.png');	
	$("#flip").click(function(){
		var flipleftinput= $('#flipleftinput').height();
		var fliprightinput= $('#fliprightinput').height();
		var aiorangecolorfir= $('.aiorangecolorfir').height();
		$("#taxi_ride_src").attr('placeholder','Drop me at..');
		if(flipit==false){
			flipit = true;
		$("#taxi_ride_src").attr('name','taxi_ride_dest');
		$("#taxi_ride_dest").attr('name','taxi_ride_src');
		$("#taxi_ride_dest").attr('ng-model','airsource');
		$("#taxi_ride_src").attr('ng-model','airdest');	
		$("#flipleftinput #taxi_ride_src").attr('id','taxi_ride_dest');
		$("#fliprightinput #taxi_ride_dest").attr('id','taxi_ride_src');
		$("#flipmiddleinput").animate({
            top: -aiorangecolorfir
        });
        $("#flipleftinput").animate({
            top: fliprightinput+flipleftinput-aiorangecolorfir
        });
      $("#fliprightinput").animate({
            top: -flipleftinput-fliprightinput
        });
	 }else{
		 $("#taxi_ride_src").attr('name','taxi_ride_dest');
		$("#taxi_ride_dest").attr('name','taxi_ride_src');
		$("#taxi_ride_dest").attr('ng-model','airsource');
		$("#taxi_ride_src").attr('ng-model','airdest');
        $("#fliprightinput #taxi_ride_src").attr('id','taxi_ride_dest');
		$("#flipleftinput #taxi_ride_dest").attr('id','taxi_ride_src');
		 	flipit = false;
			$("#taxi_ride_src").attr('placeholder','Pick me up at..');
	    $("#flipmiddleinput").animate({
            top: '0px'
        });		
        $("#flipleftinput").animate({
            top: '0px'
        });
      $("#fliprightinput").animate({
            top: '0px'
        });
	 }
   });	
		
		
	}
});



	$(".loginbtn").click(function(){
		$('#overlay-slider-menu').hide();
      	$('body').removeClass('nav-expanded');
        $('body').toggleClass('open');
		resetLoginBox();
		$('input[name="user_gender"]')[0].checked = true;
		$("#aspool_id").val(0);
		$("#aslastact").val("");
		$("#spool_id").val(0);
		$("#slastact").val("");
		$(".logregbox").show();
		$('#fbloginbtn').focus();
	});
	$(".logregboxclose").click(function(){
		$(".logregbox").hide();
	});

$('#mainsearchairport ,#mainsearchwork').click(function(){
      		$('#carPool ,#personal ,#sharedTaxi ,#sharedwTaxi, #searchCarpool').removeClass('show');
      	});
if(crrController=='index' && crrAction=='index'){

	$(window).scroll(function() {
		if ($(".navbar").offset().top > 50) {
			$(".navbar-fixed-top").addClass("top-nav-collapse");
		} else {
			$(".navbar-fixed-top").removeClass("top-nav-collapse");
		}
	});

}
//jQuery for page scrolling feature - requires jQuery Easing plugin
$(function() {
    $('a.page-scroll').bind('click', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: $($anchor.attr('href')).offset().top
        }, 1500, 'easeInOutExpo');
        event.preventDefault();
    });
});


$(document).ready(function(e) {
            $('#nav-expander , #nav-expander-mobile').on('click',function(e){
      		e.preventDefault();
			
			$('#overlay-slider-menu').show();
			$('#guidelines').removeClass('in');
      		$('body').toggleClass('nav-expanded');
            $('body').toggleClass('open');
      	});
      	$('#nav-close').on('click',function(e){
      		e.preventDefault();
			$('#overlay-slider-menu').hide();
      		$('body').removeClass('nav-expanded');
            $('body').toggleClass('open');
      	});
		$('#overlay-slider-menu').on('click',function(e){
			$('#overlay-slider-menu').hide();
			$('body').removeClass('nav-expanded');
            $('body').removeClass('open');
      	});
});

$("#grupLink").click(function(event){
	if(AuthLoggedId==0){
		pleaselogin();
		resetLoginBox();
		$(".logregbox").show();
	}else{
		window.location = grupId;
	}
});

function gotoUrl(wpId){
	if(AuthLoggedId==0){
		$("#aslastact").val($("#"+wpId).val());
		pleaselogin();
		resetLoginBox();
		$(".logregbox").show();
	}else{
		window.location = $("#"+wpId).val();
	}
}

function resetLoginBox(){
	$('#logregp1').css('left',0);
	$(".logregbox").show();
}
function pleaselogin(){
	$("#errormsg").html("Please Login or Sign Up to proceed further!");
}

/*all angular controllers*/
var App = angular.module("mainApp", []);
     
/*sign in angular function*/
App.controller('signin', function($scope) {
	/*$scope.update = function(user) {
      console.log("Form submitted");
     /* if ($scope.signin.$valid) {
        console.log("The form is valid.");
      } else {
        console.log("Form is invalid");
      }*
    };*/

    $scope.showError = function(input) {
      var form = $scope.signin;
      
      return (form.$submitted || form[input].$touched) && !form[input].$valid;
    };
     
});


//--------------------------------------------Login Service Call------------------------------------------------------
$("#lrbbtnlogin").click(function(){
		var uEmail=$("#asemail").val() ;
		var uPassword=$("#aspassword").val() ;
		var uPoolId=$("#aspool_id").val() ;
		var uLastAct=$("#aslastact").val() ;
        var pattern =/^[a-zA-Z0-9._-]+@[a-zA-Z]+\.[a-zA-Z.]{2,5}$/;
        if(!isNaN(uEmail) ) {
        	if ($("#asemail").val().length!=10) {
        		$("#asemail").addClass('error');
        		$("#asemail").focus();
        		return false;
        	}
        } else {
        	if(!uEmail.match(pattern)){
				$("#asemail").addClass('error');
				$("#asemail").focus();
				return false;
			}
        }
		if(uPassword.length<6){
			$("#aspassword").addClass('error');
		}
		
	if(uPassword.length>=6){
		staylogin=$("#staylogin").get(0).checked ;
		url=SiteHttpUrl+"/user/alogin";	
		showLoader();

		if(uLastAct!="save_offer" && uLastAct!='' && uLastAct.indexOf('workplace/index.html')==-1){
			postdata= "email="+uEmail+"&password="+uPassword+"&lastPoolId="+uPoolId+"&staylogin="+staylogin+"&lastAct="+uLastAct+"&aflgURl="+afterLoginUrl;
		}else if (afterLoginRedirect){ 
			postdata="email="+uEmail+"&password="+uPassword+"&lastPoolId="+uPoolId+"&lastAct="+uLastAct+"&aflgURl="+afterLoginRedirect;
		}else if (uLastAct!=''){
			postdata= "email="+uEmail+"&password="+uPassword+"&lastPoolId="+uPoolId+"&staylogin="+staylogin+"&lastAct="+uLastAct;
		}else{
			postdata= "email="+uEmail+"&password="+uPassword+"&lastPoolId="+uPoolId+"&staylogin="+staylogin;			
		}

		$.ajax({ 
			type: "POST",
			url: url,
			data: postdata,
			dataType: "POST",
			complete: function( data ) {
			/*console.log(data.responseText);
	             return false;*/
			postLoginAction(data);
		}});
	}
});

	function postLoginAction(data){ 
	//console.log(data.responseText);
			/*if( data.responseText=="INVALIDDETAILS" ){
				//$(".login_error").html("Sorry, either Email Id or Password is incorrect.");
					$(".login_error").fadeIn(500,function(){});
				//setTimeout(function(){$(".login_error").fadeOut(100,function(){});},5000);
			} else*/ if( data.responseText=="EMAILNOTEXIST" ){
				$(".login_error").html("Email or phone not registered with us, please Signup!");
					$(".login_error").fadeIn(500,function(){});
					setTimeout(function(){$(".login_error").fadeOut(100,function(){});},5000);
			}else if( data.responseText=="INVALIDDETAILS" ){
				$(".login_error").html("Sorry, either Email/Phone or Password is incorrect.");
					$(".login_error").fadeIn(500,function(){});
					setTimeout(function(){$(".login_error").fadeOut(100,function(){});},5000);
			}else if( data.responseText=="ALREADYLOGGEDIN" ){
				alert("You are already logged in");
			}
			
			else if(data.responseText=="LOGINSUCCESS_GOPROFILE" ){
				
				if(afterLoginRedirect){
					window.location.replace(afterLoginRedirect) ;
					//return false ;
				}
	 
				if(typeof actionAfterLogin=="function"){ 
					if(!actionAfterLogin(data.responseText)){
						window.location.replace(SiteHttpUrl+"/user/profile?referer=fb");
					}
				}else{ 
						window.location.replace(SiteHttpUrl+"/user/profile?referer=fb");
				}
			}else if(data.responseText=="LOGINSUCCESS" ){
				/*if(afterLoginRedirect){
					window.location=afterLoginRedirect;
				}*/

				if($("#aslastact").val()!='' && $("#aspool_id").val()==0){
					window.location=$("#aslastact").val();
				}else if(afterLoginUrl){
					window.location = afterLoginUrl;
				}else
				if(isNormalLogin){
					window.location=SiteHttpUrl;
					
				}				
	else			
	if(typeof actionAfterLogin=="function" && !isNormalLogin){
		actionAfterLogin(data.responseText);
	}else
	if(afterLoginUrl=="" && afterLoginUrl!="FALSE" ){ 
		if (afterLoginUrl.indexOf('user_type') > -1 || afterLoginUrl.indexOf('pool_id') > -1 || afterLoginUrl.indexOf('cat') > -1){
			window.location=afterLoginUrl;
		}else{
			window.location=afterLoginUrl+'/?pool_id='+$("#aspool_id").val();
			}
	}else if(afterLoginUrl=="FALSE" && !isNormalLogin){}
	else if(afterLoginUrl!="" && afterLoginUrl!="FALSE" ){
		if (afterLoginUrl.indexOf('user_type') > -1 || afterLoginUrl.indexOf('pool_id') > -1 || afterLoginUrl.indexOf('cat') > -1) {
			window.location=afterLoginUrl;
			}else{
				window.location=afterLoginUrl+'/?pool_id='+$("#aspool_id").val();}	}}hideLoader();
		
	}
	
//------------------------------End Of Login Function ----------------------------------------------------------	

//------------------------------- User FB Login Function -------------------------------------------------------

	function loginFbUser(authData){
		showLoader();
		uPoolId=$("#aspool_id").val() ;
		uLastAct=$("#aslastact").val() ;
		fbreturn=escape(JSON.stringify(authData)) ;
		if(uLastAct!="save_offer" && uLastAct.indexOf('workplace/index.html')==-1){
			url=SiteHttpUrl+"/user/afblogin/?lastPoolId="+uPoolId+"&lastAct="+uLastAct+"&aflgURl="+afterLoginUrl;
		}else if (afterLoginRedirect){
			url=SiteHttpUrl+"/user/afblogin/?lastPoolId="+uPoolId+"&lastAct="+uLastAct+"&aflgURl="+afterLoginRedirect;
		}else{
			url=SiteHttpUrl+"/user/afblogin/?lastPoolId="+uPoolId+"&lastAct="+uLastAct;
		}
		postdata= "facebookAuth="+ fbreturn;
		//alert(postdata);	
		$.ajax({type: "POST",async: true,url: url,data:encodeURI(postdata),dataType: "POST",
	complete: function( data ) {
		   if(data==""){
		   		loginFbUser(authData);
		   }else{
		   		postFBLoginAction(data);
		   }
		   //location.reload();
		  	hideLoader();
			}
	});
}

	function  postFBLoginAction(data){
	 	
		if(data.responseText=="LOGINSUCCESS_CP"){
					//console.log(afterLoginRedirect);console.log(afterLoginUrl);console.log(SiteHttpUrl);
				if(afterLoginUrl!="" && afterLoginUrl!="FALSE" && afterLoginUrl!=null){
					window.location=afterLoginUrl+"&confirm_mobile";
				}else{
					window.location = SiteHttpUrl+"/?confirm_mobile";
				}
				
				if(afterLoginRedirect){ 
					if(afterLoginUrl!="" && afterLoginUrl!="FALSE" && afterLoginUrl.indexOf('office_id') > -1  ){
						window.location=(afterLoginUrl+"&confirm_mobile");
					}else{
						if(afterLoginRedirect.indexOf('login') == -1){
					window.location=(afterLoginRedirect+"&confirm_mobile") ;
					}}
				}else if(afterLoginUrl!="" && afterLoginUrl!="FALSE" && afterLoginUrl!=null){ 
					window.location=afterLoginUrl+"&confirm_mobile";
					}
					else{
					window.location = SiteHttpUrl+"/?confirm_mobile";
				}
			
		}else
		
	 	if(data.responseText!="LOGINSUCCESS" && data.responseText!="LOGINSUCCESS_GOPROFILE" )
		{
			window.location = data.responseText;
		}else
		if(data.responseText=="LOGINSUCCESS"  ){
			
				if(afterLoginRedirect){
					//$("#afterloginredirectfrm").submit();
					if(afterLoginUrl!="" && afterLoginUrl!="FALSE" && afterLoginUrl.indexOf('office_id') > -1  ){
						window.location=(afterLoginUrl);
					}else{
					window.location=(afterLoginRedirect) ;
					}
					//return false ;
				}else{
					if(afterLoginUrl!='' && afterLoginUrl.indexOf('office_id') > -1  ){
						window.location=(afterLoginUrl);
					}
					else
					if(typeof ($(".hid_pool_cat").val()) != 'undefined' && $(".hid_pool_cat").val()!="" && $(".hid_pool_cat").val()!='0'){
						if(afterLoginUrl.indexOf('pool_id') > -1){
							window.location=afterLoginUrl;
						}else{
						window.location=afterLoginUrl+'/?pool_id='+$("#aspool_id").val();
						}
					}
					else{
						if($("#aslastact").val()!=''){
							window.location = $("#aslastact").val();
						}else{
							window.location=(SiteHttpUrl);//+"?createride");
						}
					}
					
				}
		}else if(data.responseText=="LOGINSUCCESS_GOPROFILE" ){
			//window.location.replace(SiteHttpUrl+"/user/profile?referer=fb");
		}else{ 
			if(!IsMobileTrue){
			window.location.replace(SiteHttpUrl+"#login");//+"?createride");
			}else{ 
				window.location.replace(SiteHttpUrl+"/user/loginauth");//+"?createride");
			}
		}
	}
//------------------------------- End of Fb Login Function -----------------------------------------------------

//----------------------------------Verify User Mobile Number ---------------------------------------------------------------

	function resendverifcode(){
		if($("#mobile").val()==""){
			$(".verif_error").html("Please enter mobile number.");
			$(".verif_error").fadeIn(500,function(){});return false;
		}else{ 
		showLoader();
		url=SiteHttpUrl+"/user/resendcode?resend=doresend&mnumber="+$("#mobile").val();
		$.get(url,function(response){
			if(response=="INVALIDNUMBER" ){
				$(".verif_error").html("Mobile Number is invalid.");
				$(".verif_error").fadeIn(500,function(){});
				hideLoader();
			}
			if(response=="ALREADYEXIST"){ 
				//showFlashMessage("Mobile No already exist.");
				$(".verif_error").html("Mobile No already exist.");
				$(".verif_error").fadeIn(500,function(){});
				hideLoader();
			}
			if(response=="RESENDSUCCESS" ){
				$("#mobile").val($("#mobile").val());
				$("#existingMobile").val($("#mobile").val());
				//showFlashMessage("We have sent you a new verification code.");
				if(window.location.href.indexOf('confrim_mobile')==-1){
					//window.location = window.location.href+'?confrim_mobile';
				}else{
					//window.location = window.location.href;
				}
				$(".verif_error").html("<b style='color:#03c9a9' >We have sent you a new verification code.</b>");
				hideLoader();
				}});
		//hideLoader();
	 }
	}
			



	function sendcodeverif(){ 
		if($("#mobile").val()==""){
			$(".verif_error").html("Please enter mobile number.");
			$(".verif_error").fadeIn(500,function(){});return false;
		}else{ 
		showLoader();
		url=SiteHttpUrl+"/user/resendcode?resend=doresend&mnumber="+$("#mobile").val()+"&sendfirst";
		$.get(url,function(response){ 
			if(response=="INVALIDNUMBER" ){
				$(".verif_error").html("Mobile Number is invalid.");
				$(".verif_error").fadeIn(500,function(){});
				hideLoader();
			}
			if(response=="ALREADYEXIST"){ 
				showFlashMessage("Mobile No already exist.");
				$(".verif_error").html("Mobile No already exist.");
				$(".verif_error").fadeIn(500,function(){});
				hideLoader();
			}
			var mobileNo = $.parseJSON(response);//console.log(mobileNo.mobile);
			if(mobileNo.mobile==$("#mobile").val()){
				$(".HeadingIs").text('Verify Mobile Number');
				$("#mobile").val($("#mobile").val());
				$("#existingMobile").val($("#mobile").val());
				$(".btnverify").css('display','block');
				$("#btnsend").css('display','none');
				showFlashMessage("We have sent you a verification code.");
				if(window.location.href.indexOf('confrim_mobile')==-1){
					//window.location = window.location.href+'?confrim_mobile';
				}else{
					//window.location = window.location.href;
				}
				$(".verif_error").html("<b style='color:green' >We have sent you a verification code.</b>");
				hideLoader();
				}});
		//
	 }
	}

			/*.........................start of user state ...............................*/
			
			function userstateverification(userstate){
				
				if(userstate == 2){
					showFlashError("Please verify your email and mobile number to proceed further.");
					 return false;
					}
					
					if(userstate <= 3){
					showFlashError("Please verify your mobile number to proceed further.");
					 return false;
					}
					
				if(userstate == 4 || userstate != 5){
					showFlashError("Please verify your email  to proceed further.");
					 return false;
					}
					if(userstate >= 5){
					 return true;
					}
				
				
				}
				
				/*.....................end of verification........................*/
			
			
			
			
	 
	function verifynumber(){
		$(".verif_error").hide();
		var verifcode = '';
		if(typeof $("#verifcode").val() != "undefined" && $("#verifcode").val()!="" ){	verifcode=$("#verifcode").val() ;}
		else if(typeof $("#verifcode1").val() != "undefined" && $("#verifcode1").val()!="" ){verifcode=$("#verifcode1").val() ;}
		else{ verifcode = ''; } 
		if($("#mobile").val()==""){
			$(".verif_error").html("Please enter mobile number.");
			$(".verif_error").fadeIn(500,function(){});return false;
		}
		if($("#existingMobile").val()==""){
			$(".verif_error").html("Your number is not registred with rideally.<br/>Please press resend code to register your number.");
			$(".verif_error").fadeIn(500,function(){});return false;
		}
		if($("#existingMobile").val()!=$("#mobile").val()){
			$(".verif_error").html("Your number is not match with registred number.<br/>Please either press resend code or enter existing number.");
			$(".verif_error").fadeIn(500,function(){});return false;
		}
		if(verifcode=="" || typeof(verifcode)=="undefined"){$(".verif_error").html("Please enter verification code.");
		$(".verif_error").fadeIn(500,function(){});return false;}
	url=SiteHttpUrl+"/user/verifynumber";
	showLoader();
	postdata= "verifcode="+verifcode;
	
	
	 if($("#verifyonjoin").val()=='1'){postdata+"&verifyonjoin"}
	
	$.ajax({type: "POST",url: url,data: postdata,dataType: "POST",
	complete: function( data ) {
		if( data.responseText=="INVALIDCODE" ){
			$(".verif_error").html("Invalid Code.");$(".verif_error").fadeIn(500,function(){});
			hideLoader();
			}else if(data.responseText=="VERIFSUCCESS" ){showFlashMessage("Mobile Number Verification Successful.");
			/*if(typeof showJoinBox=="function"){
				showJoinBox();
				}*/
				
				window.location = $("#afterverifyredirect").val().replace("&confirm_mobile","");
			$(".iconphone").removeClass("monoverified");
			$(".notifymnv").remove();
			$(".mnvwrapper").hide(500,function(){});
			hideLoader();
		}else if(data.responseText=="ALREADYVERIFIED" ){
			showFlashMessage("Your number is already verified.");
			$(".iconphone").removeClass("monoverified");
			$(".mnvwrapper").hide(500,function(){});
			hideLoader();
		}else{
			$(".verif_error").html("Verification Failed. Please try again.");$(".verif_error").fadeIn(500,function(){});
			hideLoader();
		}//hideLoader();
	}});	
}

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
	
//----------------------------------------End of Verify Mobile Code ------------------------------------------------------

	if (window.location.hash == '#_=_') {window.location.hash = ''; /*// for older browsers, leaves a # behind*/ history.pushState('', document.title, window.location.pathname);/* // nice and clean*/ e.preventDefault(); /*// no page reload*/}
	

/*sign up angular function*/
App.controller('signup', function($scope) {
    
	$scope.update = function() {
      console.log("Form submitted");
      //if ($scope.signup.$submitted) {//$scope.signup.$valid ||
	  if($('#uhome_address').val()!=gsearchFrom){
		  $('#uhome_address').addClass('error');
		  $('.home_error').removeClass('ng-hide');
		  $('.home_error').html('please select location from google places only');
		  return false;
		  }
	  if($('#uhome_address').val()!="" && $('#uhome_address').val()==gsearchFrom){
		  $('#uhome_address').removeClass('error');
		   $('.home_error').css('display','none');
		 console.log("Form is valid");
		  userRegister();
	  }else{
        console.log("Form is invalid");
     }
    };

    $scope.showError = function(input) {
      var form = $scope.signup;
      
      return (form.$submitted || form[input].$touched) && !form[input].$valid;
    }
     
});



App.controller('validateairport', function($scope) {
	$scope.validateairports = function() {
      console.log("Form submitted");
	  if(gsearchFrom==true){
		$('.aiorangecolorfir').addClass('nghide');
	}else {
      if(gsearchFrom==false || ($('#taxi_ride_dest').val()==""))
	  {
		   $('#taxi_ride_src').focus();
		  $scope.airsource="";	  
	  }
	  else if(gsearchTo==false || ($('#taxi_ride_dest').val()==""))
	  {
		  $('#taxi_ride_dest').focus();
		  $scope.airdest="";	  
	  }
	  
      if (gsearchFrom!=false && gsearchTo!=false) { 
		    $('#sharedTaxi').addClass('show');
      		$('#carPool ,#personal ,#sharedwTaxi ,#searchCarpool').removeClass('show');
      	    console.log("The form is valid.");
      } else {
        console.log("Form is invalid"); 
      }
	}
    };
	 $scope.validateairportp = function() {
      console.log("Form submitted");
	  if(gsearchFrom==true){
		$('.aiorangecolorfir').addClass('nghide');
	}else {
      if(gsearchFrom==false || ($('#taxi_ride_dest').val()==""))
	  {
		  $('#taxi_ride_src').focus();
		  $scope.airsource="";	  
	  }
	  

      if (gsearchFrom!=false && gsearchTo!=false) { 
		    $('#personal').addClass('show');
      		$('#carPool ,#sharedTaxi ,#sharedwTaxi, #searchCarpool').removeClass('show');
			pleaselogin();
		    resetLoginBox();
		    $(".logregbox").show();
      	    console.log("The form is valid.");
      } else {
        console.log("Form is invalid"); 
      }
	}
    }; 
});

App.controller('validateanywhere', function($scope) {
	var _gsearchFrom;
	var _gsearchTo;
	$scope.showError = function(input) {
      var form = $scope.anywhereForm;
      
      return (form.$submitted || form[input].$touched) && !form[input].$valid;
    }
    $scope.validateanywhere = function() { 
      //console.log("anyw Form submitted");
	  if((gsearchFrom==true && gsearchTo==true) || (_gsearchFrom==true && _gsearchTo==true)){
		$('.anorangecolorfir').addClass('nghide');
		$('.anorangecolorsec').addClass('nghide');	
	  }else if(gsearchFrom==true || _gsearchFrom==true){
			$('.anorangecolorfir').addClass('nghide');
		}else if(gsearchTo==true || _gsearchTo==true){
			$('.anorangecolorsec').addClass('nghide');
	  }else {
	 if(($('#anysource').val()=="" && $('#anydest').val()=="") || ($('#office_name').val()=="" && $('#ride_src').val()==""))
	  {
		  $('#anysource').focus();
		  $scope.anysource="";
		  $scope.anydest="";
		  $('#office_name').focus();  
	  }
	  else if(($('#anysource').val()=="") || ($('#office_name').val()==""))
	  {
		  $('#office_name').focus();
		  $scope.anysource="";	  
	  }else
	   if(gsearchTo==false || ($('#anydest').val()==""))
	  {
		  $('#anydest').focus();
		  $scope.anydest="";	  
	  }
	  if(gsearchFrom==false || ($('#ride_src').val()==""))
	  {
		  $('#ride_src').focus();
		  $scope.wpdest="";	  
	  }
	  
      if ($scope.anywhereForm.$valid && gsearchTo!=false  && $scope.anysource!=$scope.anydest) {
		  $('#searchCarpool').addClass('show');
      	  $('#carPool ,#personal ,#sharedTaxi, #sharedwTaxi').removeClass('show');
        console.log("The form is valid.");
      } else {
        console.log("Form is invalid"); 
      }
	}
    };
	
	$scope.validateheadwp = function() { 
      //console.log("anyw Form submitted");
	  if(gsearchFrom==true && gsearchTo==true){
		$('.anorangecolorfir').addClass('nghide');
		$('.anorangecolorsec').addClass('nghide');	
	  }else if(gsearchFrom==true){
			$('.anorangecolorfir').addClass('nghide');
		}else if(gsearchTo==true){
			$('.anorangecolorsec').addClass('nghide');
	  }else {
	 if($('#office_name').val()=="" && $('#ride_src').val()=="")
	  {
		  $scope.anysource="";
		  $scope.anydest="";
		  $('#office_name').focus();  
	  }
	  else if(($('#anysource').val()=="") || ($('#office_name').val()==""))
	  {
		  $('#office_name').focus();
		  $scope.anysource="";	  
	  }else
	   if(gsearchTo==false || ($('#anydest').val()==""))
	  {
		  $('#anydest').focus();
		  $scope.anydest="";	  
	  }
	  if(gsearchFrom==false || ($('#ride_src').val()==""))
	  {
		  $('#ride_src').focus();
		  $scope.wpdest="";	  
	  }
	  
      if ($scope.anywhereForm.$valid && gsearchTo!=false  && $scope.anysource!=$scope.anydest) {
		  $('#searchCarpool').addClass('show');
      	  $('#carPool ,#personal ,#sharedTaxi, #sharedwTaxi').removeClass('show');
        console.log("The form is valid.");
      } else {
        console.log("Form is invalid"); 
      }
	}
    };

});

App.controller('validateworkplace', function($scope) {

//	$scope.url = SiteHttpUrl+'/services/officegroups/getofficegroup'; // The url of our searc gsearchTo
    	
	$scope.validateworkplaces = function() {
		
		console.log("wp Form submitted");// && $scope.workplaceForm.$submitted
		if(gsearchFrom==true && gsearchTo==true){
		$('.wporangecolorfir').addClass('nghide');
		$('.wporangecolorsec').addClass('nghide');	
		}else if(gsearchFrom==true){
			$('.wporangecolorfir').addClass('nghide');
		}else if(gsearchTo==true){
			$('.wporangecolorsec').addClass('nghide');
	  }else {
      if((gsearchFrom==false && gsearchTo==false) || (($('#wsource').val()=="") && ($('#wdest').val()=="")))
	  {
		  $('#wsource').focus();
		  $scope.wpsource="";
		  $scope.wpdest="";	  
	  }
	  else if(gsearchFrom==false || ($('#wsource').val()==""))
	  {   
	      $('#wsource').focus();
		  $scope.wpsource="";	  
	  }
	  else if(gsearchTo==false || ($('#wdest').val()==""))
	  {
		  $('#wdest').focus();
		  $scope.wpdest="";	  
	  }
	}
	};
	// The function that will be executed on button click (ng-click="search()")
	$scope.wpsearch = function() {
		
		console.log("wp Form submitted");//&& $scope.workplaceForm.$submitted 
	if(gsearchFrom==true && gsearchTo==true){
		$('.wporangecolorfir').addClass('nghide');
		$('.wporangecolorsec').addClass('nghide');	
	    }else if(gsearchFrom==true){
			$('.wporangecolorfir').addClass('nghide');
		}else if(gsearchTo==true){
			$('.wporangecolorsec').addClass('nghide');
	  }else {
      if(((gsearchFrom==false && gsearchTo==false) && (($('#wsource').val()=="") && ($('#wdest').val()==""))) || ((gsearchFrom==false && gsearchTo==false) && (($('#ride_src').val()=="") && ($('#ride_dest').val()==""))))
	  {
		  $('#wsource').focus();$('#ride_src').focus();
		  $scope.wpsource="";$scope.ride_src="";
		  $scope.wpdest="";$scope.ride_dest="";
	  }
	  else if(gsearchFrom==false || (($('#wsource').val()=="") || ($('#ride_src').val()=="")))
	  {
		  $('#wsource').focus();
		  $scope.wpsource="";	
		  $('#ride_src').focus();
		  $scope.ride_src="";	  
	  }
	  else if(gsearchTo==false || (($('#wdest').val()=="") || ($('#ride_dest').val()=="")))
	  {
		  $('#wdest').focus();
		  $scope.wpdest="";	  
		  $('#ride_dest').focus();
		  $scope.ride_dest="";	
	  }
	  
	}
	};

          
});

App.controller('validateroute', function($scope) {

//	$scope.url = SiteHttpUrl+'/services/officegroups/getofficegroup'; // The url of our searc gsearchTo
    	
	$scope.validateroutes = function() {
		
		console.log("route Form submitted");// && $scope.workplaceForm.$submitted
		if(gsearchFrom==true && gsearchTo==true){
		$('.routeorangecolorfir').addClass('nghide');
		$('.routeorangecolorsec').addClass('nghide');	
		}else if(gsearchFrom==true){
			$('.routeorangecolorfir').addClass('nghide');
		}else if(gsearchTo==true){
			$('.routeorangecolorsec').addClass('nghide');
	  }else {
      if((gsearchFrom==false && gsearchTo==false) || (($('#routesrc').val()=="") && ($('#routedest').val()=="")))
	  {
		  $('#routesrc').focus();
		  $scope.routesrc="";
		  $scope.routedest="";	  
	  }
	  else if(gsearchFrom==false || ($('#routesrc').val()==""))
	  {   
	      $('#routesrc').focus();
		  $scope.routesrc="";	  
	  }
	  else if(gsearchTo==false || ($('#routedest').val()==""))
	  {
		  $('#routedest').focus();
		  $scope.routedest="";	  
	  }
	}
	};
});

$("#wpsearch div span").removeClass('tabride').addClass('tabrideb');

$("#wpsearch").click(function (){
	initialize('workplace');
	$("#wsource , #wdest").val('');
	$(".routeorangecolor , .aiorangecolor , .anorangecolor , .wporangecolor").addClass('nghide');
	$("#wpsearch div span").removeClass('tabride').addClass('tabrideb');
	$("#airsearch div span").removeClass('tabairb').addClass('tabair');
	$("#anysearch div span").removeClass('tabworkb').addClass('tabwork');
	$("#routesearch div span").removeClass('tabrouteb').addClass('tabroute');

$("#f1_container1").mouseenter(function(){
	$('#subsearchwork').animate({'left':0});
	//$('#mainsearchwork').animate({'right':-380+'px'});
	//$(this).animate({'right':-$("#subsearchwork").width()});
});

$("#f1_container1").mouseleave(function(){
	$('#mainsearchwork').animate({'right':0});
	//$('#mainsearchwork').remove({'right':0});
	//$('#subsearchwork').animate({'left':380+'px'});
	//$(this).animate({'right':-$("#subsearchwork").width()});
});
});
$("#airsearch").click(function (){
	initialize('airport');  
	$("#taxi_ride_src").val('');
	$(".routeorangecolor , .aiorangecolor , .anorangecolor , .wporangecolor").addClass('nghide');
	$("#airsearch div span").removeClass('tabair').addClass('tabairb');
	$("#anysearch div span").removeClass('tabworkb').addClass('tabwork');
	$("#wpsearch div span").removeClass('tabrideb').addClass('tabride');
	$("#routesearch div span").removeClass('tabrouteb').addClass('tabroute');

$("#f1_container").mouseenter(function(){ 
	$('#subsearchair').animate({'left':0});
	//$('#mainsearchairport').animate({'right':-380+'px'});
	//$(this).animate({'right':-$("#subsearchwork").width()});
});

$("#f1_container").mouseleave(function(){
	$('#mainsearchairport').animate({'right':0});
	//$('#mainsearchairport').remove({'right':0});
	//$('#subsearchair').animate({'left':380+'px'});
	//$(this).animate({'right':-$("#subsearchwork").width()});
});
});
$("#anysearch").click(function (){
	initialize('anywhere');
	$("#anysource , #anydest").val('');
	$(".routeorangecolor , .aiorangecolor , .anorangecolor , .wporangecolor").addClass('nghide');
	$("#anysearch div span").removeClass('tabwork').addClass('tabworkb');
	$("#airsearch div span").removeClass('tabairb').addClass('tabair');
	$("#wpsearch div span").removeClass('tabrideb').addClass('tabride');
	$("#routesearch div span").removeClass('tabrouteb').addClass('tabroute');
});

$("#routesearch").click(function (){
	initialize('route');
	$("#routesrc , #routedest").val('');
	$(".routeorangecolor , .aiorangecolor , .anorangecolor , .wporangecolor").addClass('nghide');
    $("#routesearch div span").removeClass('tabroute').addClass('tabrouteb');
	$("#wpsearch div span").removeClass('tabrideb').addClass('tabride');
	$("#airsearch div span").removeClass('tabairb').addClass('tabair');
	$("#anysearch div span").removeClass('tabworkb').addClass('tabwork');
});


$(".anywheretabh").click(function (){
	//$("#routeh , #anywhereh , #airporth").hide();
	//$(".routetabopt , .worktabopt , .airporttabopt").hide();
	//$("#workplaceh").show();
	//$(".ridetabopt").show();
	initialize('workplace');
	//$(".anywheretabh").addClass('transparentblack');
	/*$(".anywheretabh span img").attr('src',ThemeHttpUrl+'/images/Workplace_Green.png');
	$(".airporttabh , .workplacetabh , .routetabh").removeClass('transparentblack ranewgreen');
	$(".routetabh span img").attr('src',ThemeHttpUrl+'/images/route.png');
	$(".airporttabh span img").attr('src',ThemeHttpUrl+'/images/airport_orange.png');
	$(".workplacetabh span img").attr('src',ThemeHttpUrl+'/images/anywhere_orange.png');*/
});
$(".airporttabh").click(function (){
	//$("#workplaceh , #routeh , #anywhereh").hide();
	//$(".ridetabopt , .routetabopt , .worktabopt").hide();
	//$("#airporth").show();
	//$(".airporttabopt").show();
	initialize('airport');
	//$(".airporttabh").addClass('transparentblack');
	/*$(".airporttabh span img").attr('src',ThemeHttpUrl+'/images/Airport_Green.png');
	$(".anywheretabh , .workplacetabh , .routetabh").removeClass('transparentblack ranewgreen');
	$(".routetabh span img").attr('src',ThemeHttpUrl+'/images/route.png');
	$(".anywheretabh span img").attr('src',ThemeHttpUrl+'/images/workplace_orange.png');
	$(".workplacetabh span img").attr('src',ThemeHttpUrl+'/images/anywhere_orange.png');*/
});
$(".workplacetabh").click(function (){
	//$("#routeh , #workplaceh , #airporth").hide();
	//$(".ridetabopt , .routetabopt , .airporttabopt").hide();
	//$("#anywhereh").show();
	//$(".worktabopt").show();
	initialize('anywhere');
	//$(".workplacetabh").addClass('transparentblack');
	/*$(".workplacetabh span img").attr('src',ThemeHttpUrl+'/images/Anywhere_Green.png');
	$(".airporttabh , .anywheretabh , .routetabh").removeClass('transparentblack ranewgreen');
	$(".routetabh span img").attr('src',ThemeHttpUrl+'/images/route.png');
	$(".airporttabh span img").attr('src',ThemeHttpUrl+'/images/airport_orange.png');
	$(".anywheretabh span img").attr('src',ThemeHttpUrl+'/images/workplace_orange.png');*/
});
$(".routetabh").click(function (){
	//$("#workplaceh , #anywhereh , #airporth").hide();
	//$(".ridetabopt , .worktabopt , .airporttabopt").hide();
	//$("#routeh").show();
	//$(".routetabopt").show();
	initialize('route');
	//$(".routetabh").addClass('transparentblack');
	/*$(".routetabh span img").attr('src',ThemeHttpUrl+'/images/route_green.png');
	$(".airporttabh , .anywheretabh , .workplacetabh").removeClass('transparentblack ranewgreen');
	$(".workplacetabh span img").attr('src',ThemeHttpUrl+'/images/anywhere_orange.png');
	$(".airporttabh span img").attr('src',ThemeHttpUrl+'/images/airport_orange.png');
	$(".anywheretabh span img").attr('src',ThemeHttpUrl+'/images/workplace_orange.png');*/
});



/*$('#wsource').click(function(){
	    $(".wporangecolorfir").removeClass('nghide');
});
$('#wdest').click(function(){
	    $(".wporangecolorsec").removeClass('nghide');
});
$('#taxi_ride_src').click(function(){
		$(".aiorangecolorfir").removeClass('nghide');
});
$('#anysource').click(function(){
		$(".anorangecolorfir").removeClass('nghide');
});
$('#anydest').click(function(){
		$(".anorangecolorsec").removeClass('nghide');
});*/
$('#carPool , #sharedwTaxi , #sharedTaxi , #personal , #searchCarpool , #routecarPool').click(function(){
		$(".anorangecolor").removeClass('nghide');
		$(".aiorangecolor").removeClass('nghide');
	    $(".wporangecolor").removeClass('nghide');
		$(".routeorangecolor").removeClass('nghide');
});


//--------------------------------------------- email and mobile check onblur---------------------------------------
function ismobileexistcheck(){ 
var umobile1=$("#smobile_number").val();
 url=SiteHttpUrl+"/user/ismobileexistcheck";	
 PostData =  "&mobile="+umobile1;
 
	console.log(url);
	$.ajax({
		type: "POST",
		url: url,
		data : PostData,
		complete: function( data ) {
				//console.log(data.responseText);
				//alert(data.responseText);
			if(data.responseText=="MOBEXIST" ){
            $("#mobilecheck").val("0");
				
		    $(".login_error").html("Mobile number already exist.");$(".login_error").fadeIn();
		    return false;
			} else if( data.responseText=="MOBNOTEXIST" ){
				$("#mobilecheck").val("1");	   
           $(".login_error").fadeOut();
		       return true;
			}
		}
		});	

}



function isemailexistcheck()
{
$("#emailverloader").fadeIn();
var pattern =/^[a-zA-Z0-9._-]+@[a-zA-Z]+\.[a-zA-Z.]{2,5}$/;
var uEmail=$("#semail").val();
//var postdata;
   
	//alert(postdata);
	if(uEmail.match(pattern)){
 url=SiteHttpUrl+"/user/isemailexistcheck";	
 PostData =  "&email="+uEmail;
 
	console.log(url);
	$.ajax({
		type: "POST",
		url: url,
		data : PostData,
		complete: function( data ) {
				//console.log(data.responseText);
				//alert(data.responseText);
			if(data.responseText=="EMAILEXIST" ){
				$("#emailverloader").fadeOut();
				$(".email_error").removeClass('ng-hide');
				$(".email_error").html("Email already exist.");$(".email_error").fadeIn();
				return false;
   //console.log('EMAILEXIST');
			} else if( data.responseText=="EMAILNOTEXIST" ){
			$("#emailverloader").fadeOut();
            $(".email_error").fadeOut();
			  return true;
			}
			}
		});
	$("#semail").removeClass("error");
	}else{
		   $("#emailverloader").fadeOut();
           $(".email_error").fadeOut();
	}
}


//--------------------------------------------------onblur end-------------------------------------------------------


/*-----------------------------------------Start of Sign Up---------------------------------------------------*/	
	function userRegister(){
		
		
		if($(".login_error").is(":visible") || $(".email_error").is(":visible"))
    {
	$('#logregp4').animate({'left':$('#innerlogregbox').width()});
    $('#logregp3').animate({'left':0});	
	}
	else {
		if($("#sfirst_name").val()!=""){
   setTimeout(function() {
     $(".signup_error").fadeOut();
     }, 2000);	
	$(".signup_error").hide();
	var uEmail=$("#semail").val() ;
	var uPassword=$("#spassword").val() ;
	var ufirstname=$("#sfirst_name").val();
	var ulastname=$("#slast_name").val();
	var umobile=$("#smobile_number").val();
	var uhomeloc=$("#uhome_address").val();
	var uhomeloc_lat=$("#home_address_lat").val();
	var uhomeloc_long=$("#home_address_long").val();

	
var uLastAct=$("#slastact").val() ; var uPoolId=$("#spool_id").val() ;		 			
var ugender="";	
if(document.getElementById("sgender_type_f").checked){
	
   ugender="F";
}else{
	ugender="M";
} 	
	
//console.log(uLastAct);console.log(afterLoginUrl);return false;
		 		//alert('hello');	   	
url=SiteHttpUrl+"/user/asignup";
showLoader();
if(uLastAct!="save_offer" && uLastAct!=''){ 
	postdata= "firstname="+ufirstname+"&lastname="+ulastname+"&email="+uEmail+"&password="+uPassword+"&mobile="+umobile+"&gender="+ugender+"&lastPoolId="+uPoolId+"&lastAct="+uLastAct+"&aflgURl="+afterLoginUrl+"&uhomeloc="+uhomeloc+"&uhomeloc_lat="+uhomeloc_lat+"&uhomeloc_long="+uhomeloc_long;
}else if (afterLoginRedirect){
	postdata= "firstname="+ufirstname+"&lastname="+ulastname+"&email="+uEmail+"&password="+uPassword+"&mobile="+umobile+"&gender="+ugender+"&lastPoolId="+uPoolId+"&lastAct="+uLastAct+"&uhomeloc="+uhomeloc+"&uhomeloc_lat="+uhomeloc_lat+"&uhomeloc_long="+uhomeloc_long;
			//url=SiteHttpUrl+"/user/afblogin/?lastPoolId="+uPoolId+"&lastAct="+uLastAct;
		}else if(uLastAct!=''){
			
		postdata= "firstname="+ufirstname+"&lastname="+ulastname+"&email="+uEmail+"&password="+uPassword+"&mobile="+umobile+"&gender="+ugender+"&lastPoolId="+uPoolId+"&lastAct="+uLastAct+"&uhomeloc="+uhomeloc+"&uhomeloc_lat="+uhomeloc_lat+"&uhomeloc_long="+uhomeloc_long;
}else {
			
		postdata= "firstname="+ufirstname+"&lastname="+ulastname+"&email="+uEmail+"&password="+uPassword+"&mobile="+umobile+"&gender="+ugender+"&uhomeloc="+uhomeloc+"&uhomeloc_lat="+uhomeloc_lat+"&uhomeloc_long="+uhomeloc_long+"&lastPoolId="+uPoolId;
}
		$.ajax({ 
		type: "POST",
		url: url,data: postdata,
		dataType: "POST",
		complete: function( data ) {
			
		if( data.responseText=="INVALIDEMAIL" ){
		$(".signup_error").html("Invalid Email or Password.");
		$(".signup_error").fadeIn(500,function(){});}
		else if( data.responseText=="INVALIDPASSWORD" ){
		$(".signup_error").html("Password should be 6 characters long.");
		$(".signup_error").fadeIn(500,function(){});
		 }else if( data.responseText=="ALREADYLOGGEDIN" ){
		 alert("You are already logged in");
		 window.location=SiteHttpUrl+"";
		 }else if(data.responseText=="EMAILALREADYEXISTS" ){
		 $(".signup_error").html("Email already exists.");
		 $(".signup_error").fadeIn(500,function(){});
		 }else if(data.responseText=="REGISTRATION_FAILED" ){
		 $(".signup_error").html("Mobile number already exists.");
		 $(".signup_error").fadeIn(500,function(){});
		 }else if(data.responseText=="REGISTRATION_DONE" ){ 
		 	/*console.log(data);console.log(uLastAct);console.log(typeof actionAfterLogin);
			 console.log(afterLoginUrl);console.log(afterLoginRedirect);return false;*/
		 if(typeof actionAfterLogin=="function" && !isNormalLogin){ 
		 actionAfterLogin(data.responseText);}
		 else{
		 
				if(afterLoginRedirect){
					window.location=afterLoginRedirect+"";
				}
				if(isNormalLogin){
					window.location=SiteHttpUrl+"?confirm_mobile";
				}				
	else {			
	if(typeof actionAfterLogin=="function" && !isNormalLogin){
		actionAfterLogin(data.responseText);
	}
	else if(afterLoginUrl=="" && afterLoginUrl!="FALSE" ){ 
		if (afterLoginUrl.indexOf('user_type') > -1 || afterLoginUrl.indexOf('pool_id') > -1 || afterLoginUrl.indexOf('cat') > -1){
			window.location=afterLoginUrl;
		}else{
			window.location=afterLoginUrl+'/?pool_id='+$("#aspool_id").val();
			}
	}else if(afterLoginUrl=="FALSE" && !isNormalLogin){}
	else if(afterLoginUrl!="" && afterLoginUrl!="FALSE" ){
		if (afterLoginUrl.indexOf('user_type') > -1 || afterLoginUrl.indexOf('pool_id') > -1 || afterLoginUrl.indexOf('cat') > -1) {
			window.location=afterLoginUrl;
			}else{
				if(uLastAct!=''){console.log(uLastAct);
					window.location = uLastAct;
				}else{
					window.location=afterLoginUrl+'/?pool_id='+$("#aspool_id").val();
					}	
				}
				}
			
	}
		   }
		 }
		 hideLoader();
		 }});}}}
		 			   								
		 			   								
	/*----------------------------------------------------------------End of Sign Up-------------------------------------------------------*/	 			   								
		 			   				

//--------------------------------Show & Hide Loader when ajax is calling ---------------------------------------------

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

//---------------------------------------On Click Create Ride befor login ------------------------------------------------

function WAAclick(clickfrom,group_url){

if(!AuthLoggedId){
	if(clickfrom=='marathon'){
		var url =group_url;
		var aslastact = document.getElementById("aslastact");
		var slastact = document.getElementById("slastact");
        aslastact.value = url;
		slastact.value = url;
	}
	if(clickfrom=='anwp'){
			$("#aslastact").val(SiteHttpUrl+'/workplace/addworkplace');
			$("#slastact").val(SiteHttpUrl+'/workplace/addworkplace');
			localStorage.setItem('hmLoc',$("#hmLoc").val());
			localStorage.setItem('wpLoc',$("#wpLoc").val());
			localStorage.setItem('wpLat',$("#wpLat").val());
			localStorage.setItem('wpLon',$("#wpLon").val());
			localStorage.setItem('wpStaxi',$("#wpStaxi").val());
	}else 
	if(clickfrom=='anwptaxi'){
		
			$("#aslastact").val(SiteHttpUrl+'/ride?shared');
			$("#slastact").val(SiteHttpUrl+'/ride?shared');
			localStorage.setItem('hmLoc',$("#hmLoc").val());
			localStorage.setItem('hmLat',$("#hmLat").val());
			localStorage.setItem('hmLon',$("#hmLon").val());
			localStorage.setItem('wpLoc',$("#wpLoc").val());
			localStorage.setItem('wpLat',$("#wpLat").val());
			localStorage.setItem('wpLon',$("#wpLon").val());
			localStorage.setItem('wpStaxi',$("#wpStaxi").val());
	}else
	if(clickfrom=='wp'){
		var wpurl =group_url;
		/*if(typeof ($("#wpurl").val()) == 'undefined'){
			$("#aslastact").val(SiteHttpUrl+'/workplace/addworkplace');
			$("#slastact").val(SiteHttpUrl+'/workplace/addworkplace');
			localStorage.setItem('wpLoc',$("#wpLoc").val());
		}else{*/
		var aslastact = document.getElementById("aslastact");
		var slastact = document.getElementById("slastact");
        aslastact.value = wpurl;
		slastact.value = wpurl;
			//$("#aslastact").val()=wpurl;
			//$("#slastact").val()=wpurl;
		//}
	}
	else if(clickfrom=='jwp'){
			var wpurl =group_url;
		var aslastact = document.getElementById("aslastact");
		var slastact = document.getElementById("slastact");
        aslastact.value = wpurl;
		slastact.value = wpurl;
	}
	else if(clickfrom=='stwp'){
		//$("#aslastact").val($("#stwp").val());
		//$("#slastact").val($("#stwp").val());
		var wpurl =group_url;
		var aslastact = document.getElementById("aslastact");
		var slastact = document.getElementById("slastact");
        aslastact.value = wpurl;
		slastact.value = wpurl;
		
	}
	else if(clickfrom=='arwp'){
	var wpurl =group_url;

		var aslastact = document.getElementById("aslastact");
		var slastact = document.getElementById("slastact");
        aslastact.value = wpurl;
		slastact.value = wpurl;;
	}
	else if(clickfrom=='oarwp'){ 
	var wpurl =group_url;

		var aslastact = document.getElementById("aslastact");
		var slastact = document.getElementById("slastact");
        aslastact.value = wpurl;
		slastact.value = wpurl;;
		
		//$("#slastact").val($("#stwp").val());
	}
	else if(clickfrom=='sjrwp'){
		var wpurl =group_url;
		var aslastact = document.getElementById("aslastact");
		var slastact = document.getElementById("slastact");
        aslastact.value = wpurl;
		slastact.value = wpurl;
	}
	else if(clickfrom=='ap'){
	
		$("#aslastact").val(SiteHttpUrl+'/taxirides/book/airport/?offer=2');
		$("#slastact").val(SiteHttpUrl+'/taxirides/book/airport/?offer=2');
		localStorage.setItem('tr_src',$("#taxi_ride_src").val());
		localStorage.setItem('tr_src_lat',$("#taxi_ride_src_lat").val());
		localStorage.setItem('tr_src_long',$("#taxi_ride_src_long").val());
		localStorage.setItem('tr_dest',$("#taxi_ride_dest").val());
		localStorage.setItem('tr_dest_lat',$("#taxi_ride_dest_lat").val());
		localStorage.setItem('tr_dest_long',$("#taxi_ride_dest_long").val());
		localStorage.setItem('tr_book_taxi','s');
	}
	else if(clickfrom=='aw'){
		
		$("#aslastact").val(SiteHttpUrl+'/ride?nride');
		$("#slastact").val(SiteHttpUrl+'/ride?nride');
		localStorage.setItem('anysource',$("#tr_src").val());
		localStorage.setItem('anysource_lat',$("#tr_src_lat").val());
		localStorage.setItem('anysource_long',$("#tr_src_long").val());
		localStorage.setItem('anydest',$("#tr_dest").val());
		localStorage.setItem('anydest_lat',$("#tr_dest_lat").val());
		localStorage.setItem('anydest_long',$("#tr_dest_long").val());
	}
	else if(clickfrom=='ro'){
		var wpurl =group_url;
		var aslastact = document.getElementById("aslastact");
		var slastact = document.getElementById("slastact");
        aslastact.value = wpurl;
		slastact.value = wpurl;//console.log(aslastact.value);console.log(slastact.value);
		//$("#aslastact").val(SiteHttpUrl+'/route');
		//$("#slastact").val(SiteHttpUrl+'/route');
		localStorage.setItem('routesrc',$("#tr_src").val());
		localStorage.setItem('routesrc_lat',$("#tr_src_lat").val());
		localStorage.setItem('routesrc_long',$("#tr_src_long").val());
		localStorage.setItem('routedest',$("#tr_dest").val());
		localStorage.setItem('routedest_lat',$("#tr_dest_lat").val());
		localStorage.setItem('routedest_long',$("#tr_dest_long").val());
	}
	else if(clickfrom=='mem'){
	//	alert('hello');
		var wpurl =group_url;
		var aslastact = document.getElementById("aslastact");
		var slastact = document.getElementById("slastact");
        aslastact.value = wpurl;
		slastact.value = wpurl;
	}
	
	else if(clickfrom=='route'){
		
		var routeurl =group_url;
	
		var aslastact = document.getElementById("aslastact");
		var slastact = document.getElementById("slastact");
        aslastact.value = routeurl;
		slastact.value = routeurl;
	}
	else if(clickfrom == 'apt'){

			$("#aslastact").val(SiteHttpUrl+'/taxirides/book/airport/?offer=2');
			$("#slastact").val(SiteHttpUrl+'/taxirides/book/airport/?offer=2');
			localStorage.setItem('tr_src',$("#taxi_ride_src").val());
			localStorage.setItem('tr_src_lat',$("#taxi_ride_src_lat").val());
			localStorage.setItem('tr_src_long',$("#taxi_ride_src_long").val());
			localStorage.setItem('tr_dest',$("#taxi_ride_dest").val());
			localStorage.setItem('tr_dest_lat',$("#taxi_ride_dest_lat").val());
			localStorage.setItem('tr_dest_long',$("#taxi_ride_dest_long").val());
			localStorage.setItem('tr_book_taxi','p');

	}
	if(clickfrom == 'apt'){
		if($("#taxi_ride_src").val()!='' && gsearchFrom!=false && gsearchTo!=false && $("#taxi_ride_dest").val()!=''){
		$("#errormsg").html("Please Login or Sign Up to proceed further!");
		$(".logregbox").show();
	}}else{
			$("#errormsg").html("Please Login or Sign Up to proceed further!");
		$(".logregbox").show();
	}

}else{ 
	if(clickfrom=='sjrwp'){
		var wpurl =group_url;
		//alert(wpurl);
		window.location.href = wpurl;
		//window.location = $("#sjrwp").val();
	}else
	if(clickfrom == 'jwp'){
		window.location = $("#jwp").val();		
	}else
	if(clickfrom == 'stwp'){
		var wpurl =group_url;
		window.location = wpurl;
		//window.location = $("#stwp").val();
	}else
	if(clickfrom == 'arwp'){
		var wpurl =group_url;
		window.location = wpurl;
	}
	if(clickfrom == 'oarwp'){
		var wpurl =group_url;
		window.location = wpurl;
	}
}

}


/*This code is intellectual property of OpCord and its highly Confidential.*/
$(document).ready(function(e) {
	$( ".localstclear" ).click(function() {
	 // alert( "Handler for .click() called." );
	  localStorage.clear();
	});
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
	

//-----------------------------By Gopal old file function -------------------------------------------
function resetIndexes(){$(".boxindex").each(function(i,spn){newIndex=i+1;$(this).html(newIndex)});}