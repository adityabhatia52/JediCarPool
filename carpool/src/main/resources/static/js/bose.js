$(document).ready(function() {

	$(".imgback").bose({
		images : [ "images/homepageslider.jpg", "images/homepageslider1.jpg", "images/homepageslider2.jpg"],
		imageTitles: [
		['Title 1', 'Description one here'],
		['Title 2', 'Description two here'],
		['Title 3', 'Description three here']
		],
		onComplete : function(){
			console.log("Trigger onComplete!");
		},
		onSlideStart : function(index){
			console.log(index + ' destroying');
		},
		onSlideEnd : function(index){
			console.log(index + ' showed');
		},
		onPause : function(index){
			console.log('Paused');
		},
		pagination : { show : true, container : '.bose-pagination', text : true },
		thumbs : { show : true, container : '.bose-thumbs', dimension : { width : 150, height: 70 }, text : true },
		responsive : true,
		autofit : false
	});

	$('.play').click(function(){
		$(".imgback").bose('play');
	});

	$('.pause').click(function(){
		$(".imgback").bose('pause');
	});

	$('.previous').click(function(){
		$(".imgback").bose('previous');
	});

	$('.next').click(function(){
		$(".imgback").bose('next');
	});

});