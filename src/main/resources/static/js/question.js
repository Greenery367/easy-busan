// 계속 진행 요청
function continueTest() {
    location.href = "/question?continue=true";
}

// 기존 테스트 삭제 요청
function deleteTest() {
    fetch("/user-answer", {
        method: "DELETE"
    })
        .then(response => {
            if (!response.ok) throw new Error("서버 응답이 실패했습니다.");
            return response.json();
        })
        .then(data => {
            console.log("받은 데이터:", data);
            if (data.success) {
                alert("새로운 테스트를 진행하겠습니다.");
                window.location.href = "/question";
            } else {
                alert("오류가 발생했습니다: " + data.message);
            }
        })
        .catch(error => console.error("Error:", error));
}

document.addEventListener("DOMContentLoaded", function () {
    let boatPosition = 75;
    let selectedCategories = [];

    const boatIcon = document.querySelector(".boat-icon");
    boatIcon.style.left = '${boatPosition}px';
    if (count) {
        for (let i = 0; i < count; i++) {
            moveBoat();
        }
    }

    // 초기 버튼들에 이벤트 리스너 추가
    document.querySelectorAll(".answer-btn").forEach(button => {
        addAnswerButtonListener(button);
    });
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

    // 서버에 데이터 전송
    function sendAnswer(answerId, answerText) {
        console.log("보내는 데이터:", {answerId, answerText});

        fetch("/user-answer", {
            method: "POST",
            headers: {
                "Content-Type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify({answerId, answerText})
        })
            .then(response => {
                if (!response.ok) throw new Error("서버 응답이 실패했습니다.");
                return response.json();
            })
            .then(data => {
                console.log("받은 데이터:", data);
                if (data.success) {
                    displayNextQuestion(data.data);
                } else {
                    alert("오류가 발생했습니다: " + data.message);
                }
            })
            .catch(error => console.error("Error:", error));
    }

    // 서버에서 받은 다음 질문과 답변 버튼들 화면에 출력
    function displayNextQuestion(questionData) {
        const answerSection = document.querySelector(".answer-selection");
        answerSection.innerHTML = "";

        if (questionData.last) {
            // last가 true인 경우 sectionCategoryList로 버튼 생성
            if (questionData.sectionCategoryList) {
                questionData.sectionCategoryList.forEach(category => {
                    const button = createCategoryButton(category.sectionCategoryId, category.sectionCategoryName);
                    answerSection.appendChild(button);
                });

                const resultButton = document.createElement("button");
                resultButton.textContent = "결과 보기";
                resultButton.classList.add("result-btn");
                resultButton.addEventListener("click", sendSelectedCategories);
                answerSection.appendChild(resultButton);
            } else {
                console.error("sectionCategoryList가 존재하지 않습니다:", questionData);
            }
        } else {
            // last가 false인 경우 answerList로 버튼 생성
            if (questionData.answerList) {
                document.querySelector(".question").textContent = questionData.questionText;
                questionData.answerList.forEach(answer => {
                    const button = createAnswerButton(answer);
                    button.setAttribute("data-answer-id", answer.answerId);
                    answerSection.appendChild(button);
                });
            } else {
                console.error("answerList가 존재하지 않습니다:", questionData);
            }
        }
    }

    // 답변 버튼 생성 및 리스너 추가
    function createAnswerButton(answer) {
        const button = document.createElement("button");
        button.classList.add("answer-btn");
        button.textContent = answer.answerText;
        addAnswerButtonListener(button);
        return button;
    }

    // 카테고리 버튼 생성
    function createCategoryButton(categoryId, categoryName) {
        const button = document.createElement("button");
        button.classList.add("category-btn");
        button.textContent = categoryName;

        button.addEventListener("click", function () {
            handleCategorySelection(categoryId);
            button.classList.toggle("selected");
        });

        return button;
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

    // 버튼 클릭 시 답변 전송 및 보트 이동
    function addAnswerButtonListener(button) {
        button.addEventListener("click", function () {
            const answerId = event.target.getAttribute("data-answer-id");
            sendAnswer(answerId, button.textContent.trim());
            moveBoat();
        });
    }

    // 보트 이동
    function moveBoat() {
        boatPosition += 30;
        boatIcon.style.left = `${boatPosition}px`; // 백틱 사용
        boatIcon.style.transform = "translateY(-10%) rotate(-5deg)";

        setTimeout(() => {
            boatIcon.style.transform = "translateY(-10%) rotate(0deg)";
        }, 500);
    }

});