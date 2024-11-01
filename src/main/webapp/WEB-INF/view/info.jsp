<html>
<head>
	<%@ include file="/WEB-INF/view/layout/header.jsp" %>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/info.css">
</head>
<body>


	<div class="slider-container swiper policy-banner">
	    <div class="swiper-wrapper banner-wrapper">
			<!--동백전-->
	        <div class="swiper-slide banner-slide">
	            <a href="https://busandong100.kr/" class="banner-link" target="_blank" title="새창열기" rel="noopener noreferrer">
	                <img src="https://busandong100.kr/img/darayo/mainNew/main_img01.png">
	            </a>
	        </div>
			<!--디딤돌-->
	        <div class="swiper-slide banner-slide">
	            <a href="http://www.youthdidimdol.kr/" target="_blank" title="새창열기" rel="noopener noreferrer">
	                <img src="http://www.youthdidimdol.kr/img/main_vi_01.png">
	            </a>
	        </div>
			
			<!--문화패스-->
	        <div class="swiper-slide banner-slide">
	            <a href="https://young.busan.go.kr/index.nm?menuCd=234" class="banner-link" target="_blank" title="새창열기" rel="noopener noreferrer">
	                <img src="https://young.busan.go.kr/images/img/20240604095354595.jpg">
	            </a>
	        </div>
			
			<!--디딤돌-->
	        <div class="swiper-slide banner-slide">
	            <a href="http://www.youthdidimdol.kr/" class="banner-link" target="_blank" title="새창열기" rel="noopener noreferrer">
	                <img src="/resources/img/swiper01.png">
	            </a>
	        </div>
				        <!-- 필요한 모든 슬라이드 추가 -->
	    </div>

	    <!-- 네비게이션 화살표 -->
	    <div class="swiper-button-prev banner-button-prev"></div>
	    <div class="swiper-button-next banner-button-next"></div>

	    <!-- 페이징 버튼 -->
	    <div class="swiper-pagination banner-pagination"></div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
	<script>
		var swiper = new Swiper(".policy-banner", {
		    loop: true,
		    centeredSlides: true,
		    slidesPerView: 'auto',
		    spaceBetween: -200, 
			autoplay: {
		        delay: 3000,
		        disableOnInteraction: false,
		    },
		    pagination: {
		        el: ".swiper-pagination",
		        clickable: true,
		        bulletClass: 'swiper-pagination-bullet',
		        bulletActiveClass: 'swiper-pagination-bullet-active',
		    },
		    navigation: {
		        nextEl: ".swiper-button-next",
		        prevEl: ".swiper-button-prev",
		    },
		    on: {
				init: function() {
				    this.slideTo(0, 0, false); 

				    this.slides.forEach((slide, index) => {
				        if (index === 0) { 
				            slide.style.opacity = "1";
				            slide.style.transform = "scale(1)";
				            slide.style.zIndex = "10";
				        } else { 
				            slide.style.opacity = "0.5";
				            slide.style.transform = "scale(0.85)";
				            slide.style.zIndex = "1";
				        }
				    });
				},
		        slideChangeTransitionStart: function () {
		            swiper.slides.forEach((slide) => {
		                slide.style.opacity = "0.5";
		                slide.style.transform = "scale(0.85)";
						slide.style.zIndex = "1";
		            });
		            swiper.slides[swiper.activeIndex].style.opacity = "1";
		            swiper.slides[swiper.activeIndex].style.transform = "scale(1)";
		            swiper.slides[swiper.activeIndex].style.zIndex = "2";
		        }
		    }
		});
	</script>

</body>
</html>