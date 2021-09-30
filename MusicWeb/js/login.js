
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

$('form').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        username: {
            message: 'F',
            validators: {
                notEmpty: {
                    message: 'N'
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9_]+$/,
                    message: 'L'
                }
            }
        },
        password: {
            validators: {
                notEmpty: {
                    message: 'N'
                }
            }
        }
    }
});
