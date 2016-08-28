function init() {
	window.addEventListener('scroll', function(e){
		var distanceY = window.pageYOffset || document.documentElement.scrollTop,
		shrinkOn = 35,
		header = document.querySelector("header");
		if (distanceY > shrinkOn) {
			classie.add(header,"smallmenu");
		} else {
			if (classie.has(header,"smallmenu")) {
				classie.remove(header,"smallmenu");
			}
		}
	});
}
window.onload = init();