
$(function () {

	$('#returnTop').hide();

	$(window).scroll(function () {

		var offset = $("html,body").scrollTop();

		if (offset > 500) {
			$("#returnTop").fadeIn(100);
		} else {
			$("#returnTop").fadeOut(100);
		}
	});

	$("#returnTop").click(function () {
		$("html,body").animate({
			scrollTop: 0
		}, 200);
	});
});
