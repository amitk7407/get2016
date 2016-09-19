$(document).ready(init);

function init() {
	fnTooltip();
	fnCollapsePanel();
}

function fnTooltip() {
    $('[data-toggle="tooltip"]').tooltip();
}

function fnCollapsePanel() {
	$(".carousel-inner-body .panel a").click(function() {
		var iconClass = $(this).children().children().children().attr("class");
		var classes = iconClass.split(" ");
		$(".carousel-inner-body .panel a .panel-heading div").html("<span class='glyphicon glyphicon-plus'></span>");
		if(classes[1] === "glyphicon-minus") {
			($(this).children()).children().html("<span class='glyphicon glyphicon-plus'></span>");
		} else {
			($(this).children()).children().html("<span class='glyphicon glyphicon-minus'></span>");
		}
		
		
		
		
		
	});
}