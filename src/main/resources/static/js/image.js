document.addEventListener('DOMContentLoaded', function() {
	const backgroundSection = document.querySelector('.second-background');
	const images = [
		'/images/dong/Centum.jpg',
		'/images/dong/marin.jpg',
		'/images/dong/Seomyeon.jpg'
	];
	let currentSlide = 0;


	backgroundSection.style.backgroundImage = `url('${images[currentSlide]}')`;

	const indicators = document.querySelectorAll('.carousel-indicators button');


	function setActiveButton(index) {

		indicators.forEach(button => button.classList.remove('active'));

		indicators[index].classList.add('active');
	}
	indicators.forEach((button, index) => {
		button.addEventListener('click', function() {
			currentSlide = index;
			backgroundSection.style.backgroundImage = `url('${images[currentSlide]}')`;
			setActiveButton(currentSlide);
		});
	});
	setActiveButton(currentSlide);
});
