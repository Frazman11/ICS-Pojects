//make sure DOM is fully loaded before JS is active

//show calendar when date input field is clicked
$(document).ready(function() {
	$("#datepicker").datepicker({
		showButtonPanel: true
	});
	$("#datepicker2").datepicker({
		showButtonPanel: true
	});
//declare variable outside of function
	let selectedRoom = ''; 
	let price = 0; 
	let totalPrice = 0;

	$("#book").click(function() {
		// create dates and then check various date problems
		let date1 = new Date($("#datepicker").val());
		let date2 = new Date($("#datepicker2").val());
		if ($("#datepicker").val() == "") {
			alert("Please select an Arrival Date.");
		} else if (date1.getTime() > date2.getTime() || date1.getTime() == date2.getTime()) {
			alert("Arrival must be at least 1 day before departure.");
		} else if ($("#datepicker2").val() == "") {
			alert("Please select a Departure Date.");
        //check if no room buttons are selected
		} else if (!$("input[name='room']").is(":checked")) {
			alert("Please select a room type.");
		} else {
			// Get date1 and date2 and create date objects
			let durationDays = (date2.getTime() - date1.getTime()) / 86400000;
			selectedRoom = $("input[name='room']:checked").attr('id');
            //originally tried to create hotel object array, but resorted to a simple switch to set price instead
			switch (selectedRoom) {
				case 'room1':
					price = 129;
					break;
				case 'room2':
					price = 179;
					break;
				case 'room3':
					price = 359;
					break;
				default:
					price = 0;
			}
			totalPrice = (price * durationDays).toFixed(2);
			$('#results').html(`<p>Your length of stay is ${durationDays} days</p>
                                <p>${price} $/night</p>
                                <p>Total Price: ${totalPrice} $</p>`);

		}
	});

	// Handle radio button change event
	$("input[name='room']").change(function() {
		$(".btn-group label").removeClass("active");
		$(this).closest("label").addClass("active");
	});
});
