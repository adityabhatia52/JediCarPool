$(function () {

	var filterList = {

		init: function () {

				// MixItUp plugin
				// http://mixitup.io
				$('#portfoliolist').mixitup({
					targetSelector: '.portfolio',
					filterSelector: '.filter',
					effects: ['fade'],
					easing: 'snap',
					// call the hover effect
					onMixEnd: filterList.hoverEffect()
				});				

			},
			
			hoverEffect: function () {

			}

		};
		
		// Run the show!
		filterList.init();

	});	