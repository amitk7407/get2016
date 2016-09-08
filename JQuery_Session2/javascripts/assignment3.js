//calls the functions on load of the document
$(document).ready(buttonsClick);

//method to call methods according to the button clicks
function buttonsClick(){
	
	$("#startAnimation").click(startAnimation);
	$("#stopAnimation").click(stopAnimation);
	$("#backAnimation").click(backAnimation);
	$("#leftAnimation").click(leftAnimation);
	$("#rightAnimation").click(rightAnimation);
	$("#topAnimation").click(topAnimation);
	$("#bottomAnimation").click(bottomAnimation);
}

//method to move the div animation towards right by 50px
function startAnimation() {
	
	$("#animateDiv").animate({left: '50px'}, 1000, 'linear');
}

//method to stop animation at that position
function stopAnimation() {
	
	$("#animateDiv").stop();
}

//method to move the div animation towards left by 50px
function backAnimation() {
	
	$("#animateDiv").animate({left: '0'}, 1000, 'linear');
}

//method to move the div animation towards left by 50px
function leftAnimation() {
	
	$("#animateDiv").animate({left: '0'}, 1000, 'linear');
}

//method to move the div animation towards right by 50px
function rightAnimation() {
	
	$("#animateDiv").animate({left: '50px'}, 1000, 'linear');
}

//method to move the div animation towards top by 50px
function topAnimation() {
	
	$("#animateDiv").animate({top: '0'}, 1000, 'linear');
}

//method to move the div animation towards bottom by 50px
function bottomAnimation() {
	
	$("#animateDiv").animate({top: '50px'}, 1000, 'linear');
}