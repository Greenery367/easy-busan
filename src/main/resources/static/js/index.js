document.addEventListener("DOMContentLoaded", function () {
    const boxes = document.querySelectorAll(".third-box-blue, .third-box-white");

    const observerOptions = {
      root: null, // 뷰포트를 기준으로 관찰
      rootMargin: '0px',
      threshold: 0.2 // 요소가 20% 이상 보이면 콜백 실행
    };

    const observerCallback = (entries, observer) => {
      entries.forEach(entry => {
        if (entry.isIntersecting) {
          entry.target.classList.add('show');
          observer.unobserve(entry.target); // 이미 보인 요소는 관찰 종료
        }
      });
    };

    const observer = new IntersectionObserver(observerCallback, observerOptions);
    boxes.forEach(box => {
      observer.observe(box);
    });
  });