if ( (jQuery(window).height() + 100) < jQuery(document).height() ) {
		jQuery('#top-link-block').removeClass('hidden').affix({
			offset: {top:100}
		});
	}

	jQuery(document).ready(function() { 
		jQuery("html").niceScroll();
	            var dates = jQuery("#check_in_date, #check_out_date").datepicker({
                minDate: "0",
                maxDate: "+2Y",
                defaultDate: "+1w",
                dateFormat: 'mm/dd/yy',
                numberOfMonths: 1,
                onSelect: function (date) {
                    for (var i = 0; i < dates.length; ++i) {
                        if (dates[i].id < this.id){
                            jQuery(dates[i]).datepicker('option', 'maxDate', date);
						}
                        else if (dates[i].id > this.id){
                            jQuery(dates[i]).datepicker('option', 'minDate', date);
						}
                    }
                }
            });
       
            var dates1 = jQuery("#check_in_date1, #check_out_date1").datepicker(
			{
                minDate: "0",
                maxDate: "+2Y",
                defaultDate: "+1w",
                dateFormat: 'mm/dd/yy',
                numberOfMonths: 1,
                onSelect: function (date) {
                    for (var i = 0; i < dates1.length; ++i) {
                        if (dates[i].id < this.id){
                            jQuery(dates1[i]).datepicker('option', 'maxDate', date);
						}
                        else if (dates1[i].id > this.id){
                            jQuery(dates1[i]).datepicker('option', 'minDate', date);
						}
                    }
                }
            });
			
			var width = Number(jQuery('body').width());
                                            if (width < 768) {
	jQuery('header#myHeader').css("position","relative");
                                            }
											
        });