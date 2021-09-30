
$(function () {

    $(".concert-cover>.img-upload").change(function () {
        var $file = $(this);
        var objUrl = $file[0].files[0];
   
        var windowURL = window.URL || window.webkitURL;

        var dataURL = windowURL.createObjectURL(objUrl);

        $(".concert-cover>.img-view").attr("src", dataURL).on("load", function () {
            var ih = $(this).height();
            $(".concert-cover").css({
                height: ih
            });
        });

        $(".concert-cover>.img-upload-info").addClass("hidden");

        $(".concert-cover>.img-upload-stop").show();
        $(this).css({
            height: 0
        });
    });

    $(".concert-cover>.img-upload-stop").click(function () {
        $(".concert-cover>.img-view").removeAttr("src");
        $(".concert-cover").css({
            height: "450px"
        });
   
        $(".concert-cover>.img-upload").attr("type", "text").attr("type", "file").css({
            height: "450px"
        });
        $(".concert-cover>.img-upload-info").removeClass("hidden");
        $(".concert-cover>.img-upload-stop").hide();
    });

    $(".performerPicture>.img-upload").change(function () {
        var $file = $(this);
        var objUrl = $file[0].files[0];
   
        var windowURL = window.URL || window.webkitURL;

        var dataURL = windowURL.createObjectURL(objUrl);

        $(".performerPicture>.img-view").attr("src", dataURL).on("load", function () {
            var ih = $(this).height();
            $(".performerPicture").css({
                height: ih
            });
        });

        $(".performerPicture>.img-upload-info").addClass("hidden");

        $(".performerPicture>.img-upload-stop").show();
        $(this).css({
            height: 0
        });
    });

    $(".performerPicture>.img-upload-stop").click(function () {
        $(".performerPicture>.img-view").removeAttr("src");
        $(".performerPicture").css({
            height: "450px"
        });
   
        $(".performerPicture>.img-upload").attr("type", "text").attr("type", "file").css({
            height: "450px"
        });
        $(".performerPicture>.img-upload-info").removeClass("hidden");
        $(".performerPicture>.img-upload-stop").hide();
    });
});


$(function () {

    var index;
    $(".concert-more>.img-upload").change(function () {
        index = $(this).parent().parent().parent().index();
        console.log(index);
        var $file = $(this);
        var objUrl = $file[0].files[0];

        var windowURL = window.URL || window.webkitURL;
  
        var dataURL = windowURL.createObjectURL(objUrl);

        $(".concert-more>.img-view").eq(index).attr("src", dataURL).on("load", function () {
            var ih = $(this).height();
            $(".concert-more").eq(index).css({
                height: ih
            });
        });
 
        $(".concert-more>.img-upload-info").eq(index).addClass("hidden");

        $(".concert-more>.img-upload-stop").eq(index).show();
        $(this).eq(index).css({
            height: 0
        });
    });

    $(".concert-more>.img-upload-stop").click(function () {
        index = $(this).parent().parent().parent().index();
        $(".concert-more>.img-view").eq(index).removeAttr("src");
        $(".concert-more").eq(index).css({
            height: "254px"
        });

        $(".concert-more>.img-upload").eq(index).attr("type", "text").attr("type", "file").css({
            height: "254px"
        });
        $(".concert-more>.img-upload-info").eq(index).removeClass("hidden");
        $(".concert-more>.img-upload-stop").eq(index).hide();
    });

    $(".add-more").click(function () {

        var $li = $("ol>li:first").clone(true);
        $li.find("textarea").val("");
        $li.find(".concert-more>.img-view").removeAttr("src");
        $li.find(".concert-more").css({
            height: "254px"
        });
        $li.find(".concert-more>.img-upload").attr("type", "text").attr("type", "file").css({
            height: "254px"
        });
        $li.find(".concert-more>.img-upload-info").removeClass("hidden");
        $li.find(".concert-more>.img-upload-stop").hide();

        $("ol").append($li);
    });

    $(".remove-more").click(function () {
        var index = $(this).parent().parent().parent().index();
        $("ol>li").eq(index).remove();
    });
    

    $(".add-moreticket").click(function () {

        var $li = $("ul>li:first").clone(true);
        $li.find("textarea").val("");
        $li.find(".concert-more>.img-view").removeAttr("src");
        $li.find(".concert-more").css({
            height: "254px"
        });
        $li.find(".concert-more>.img-upload").attr("type", "text").attr("type", "file").css({
            height: "254px"
        });
        $li.find(".concert-more>.img-upload-info").removeClass("hidden");
        $li.find(".concert-more>.img-upload-stop").hide();

        $("ul").append($li);
    });

    $(".remove-moreticket").click(function () {
        var index = $(this).parent().parent().parent().index();
        $("ul>li").eq(index).remove();
    });
});


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