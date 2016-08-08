
$(function(){
	
	//Main Swiper
	swiper = new Swiper('.swiper1', {
		pagination : '.pagination1',
		loop:true
	});
	$('.arrow-left').click(function(e) {
        e.preventDefault()
		swiper.swipePrev()
    });
	$('.arrow-right').click(function(e) {
        e.preventDefault()
		swiper.swipeNext()
    });
	
	/* Vertical mode: */
	swiperV = $('.swiper-v').swiper({
		mode : "vertical", 
		pagination : '.pagination-v',
		slidesPerSlide : 5
	});
	swiperV01 = $('.swiper-v01').swiper({
		mode : "vertical", 
		pagination : '.pagination-v01',
		slidesPerSlide : 4
	});
	
	/* Free mode: */
	var swiperFree = $('.swiper-free').swiper({
		pagination : '.pagination-free',
		freeMode : true,
		freeModeFluid: true,
		slidesPerSlide : 1
	});
	
	
	/* Carousel mode: */
	swiperCar = $('.swiper-car').swiper({
		pagination : '.pagination-car',
		slidesPerSlide : 1
	});
	
	/* Carousel & Loop mode. Infinite Scrolling: */
	swiperLoop = $('.swiper-loop').swiper({
		pagination : '.pagination-loop',
		slidesPerSlide : 3,
		loop:true
	});
	
	/* Scroll container: */
	var sScroll = $('.swiper-scroll-container').swiper({
		scrollContainer : true,
		scrollbar : {
			container : '.swiper-scrollbar'	
		}
	})	
	
	
	/* Nested Swipers. Vertical Swiper inside of horizontal: */	
	var swiperN1 = $('.swiper-n1').swiper({
		pagination : '.pagination-n1',
		slidesPerSlide : 3,
	});
	var swiperN2 = $('.swiper-n2').swiper({
		pagination : '.pagination-n2',
		slidesPerSlide : 5,
		mode: 'vertical'
	});
	var swiperN3 = $('.swiper-n3').swiper({
		pagination : '.pagination-n3',
		slidesPerSlide : 5,
		mode: 'vertical'
	});
	var swiperN4 = $('.swiper-n4').swiper({
		pagination : '.pagination-n4',
		slidesPerSlide : 4,
		mode: 'vertical'
	});
	var swiperN5 = $('.swiper-n8').swiper({
		pagination : '.pagination-n8',
		slidesPerSlide : 4,
		mode: 'vertical'
	});
	/* More complex. Nested Swipers + Carousel Mode + Loop Mode: */
	var swiperN11 = $('.swiper-n11').swiper({
		pagination : '.pagination-n11',
		loop : true,
		slidesPerSlide : 3
	});
	var swiperN22 = $('.swiper-n22').swiper({
		pagination : '.pagination-n22',
		slidesPerSlide : 4,
		mode: 'vertical'
	});
})

