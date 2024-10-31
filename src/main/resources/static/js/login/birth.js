

$(document).ready(function(){
	$('#phoneNumber').on('input', function(){
	    if ($(this).val().length > 11) {
	        $(this).val($(this).val().slice(0, 11));
	    }
	});
});