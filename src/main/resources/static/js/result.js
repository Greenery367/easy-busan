document.addEventListener("DOMContentLoaded", function () {
    let selectedCategories = [];
    document.querySelectorAll(".category-btn").forEach(button => {
        const categoryId = button.getAttribute("data-category-id")
        button.addEventListener("click", () => {
            handleCategorySelection(categoryId);
            button.classList.toggle("selected");
        });
    });
    const resultBtn = document.querySelector(".result-btn");
    if (resultBtn) {
        resultBtn.addEventListener("click", sendSelectedCategories);
    }

    // 카테고리 선택 처리
    function handleCategorySelection(categoryId) {
        if (selectedCategories.includes(categoryId)) {
            selectedCategories = selectedCategories.filter(id => id !== categoryId); // 이미 선택한 카테고리 제거
        } else {
            selectedCategories.push(categoryId);
        }
        console.log("현재 선택된 카테고리 IDs:", selectedCategories);
    }

    // 선택된 카테고리 전송
    function sendSelectedCategories() {
        if (selectedCategories.length === 0) {
            alert("결과를 보기 위해 최소 하나의 카테고리를 선택해주세요.");
            return;
        }
        console.log("전송할 카테고리 IDs:", selectedCategories);

        fetch("/user-kind", {
            method: "POST",
            headers: {
                "Content-Type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify({ids: selectedCategories})
        })
            .then(response => {
                if (response.ok) {
                    window.location.href = "/result";
                } else {
                    throw new Error("서버 응답 실패");
                }
            })
            .catch(error => console.error("Error:", error));
    }
});