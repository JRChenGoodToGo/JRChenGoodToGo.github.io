
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


$(function () {
    var $li = $('ul.tab-pages li');
    $($li.eq(0).addClass('active').find('div').attr('href')).siblings('.tab-inner').hide();

    $li.click(function () {
        $($(this).find('div').attr('href')).show().siblings('.tab-inner').hide();
        $(this).addClass('active').siblings('.active').removeClass('active');
    });
});

var app = new Vue({
    el: '#app',
    data: {
        itemList: [
            {
                id: '1',
                itemName: '《No Mercy》台北場',
                imgUrl: 'pictures/cover.jpg',
                price: '500',
                count: '2'
            },
        ]
    },
    methods: {
        handlePlus: function (item) {
            item.count++;
        },
        handleSub: function (item) {
            if (item.count > 1) {
                item.count--;
            }
        },
        handledelete: function (index) {
            console.log(this);
            this.itemList.splice(index, 1);
        }
    },
    computed: {

    }
})