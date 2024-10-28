document.addEventListener("DOMContentLoaded", function () {
    let answerId = 1;
    let boatPosition = 75;

    const boatIcon = document.querySelector(".boat-icon");
    boatIcon.style.left = `${boatPosition}px`;

	// 초기 버튼들에 이벤트 리스너 추가
    document.querySelectorAll(".answer-btn").forEach(button => {
        addAnswerButtonListener(button, answerId++);
    });

	// 서버에 데이터 전송
    function sendAnswer(answerId, answerText) {
        console.log("보내는 데이터:", { answerId, answerText });

        fetch("/user-answer", {
            method: "POST",
            headers: {
                "Content-Type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify({ answerId, answerText })
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
        if (!questionData || !questionData.answerList) {
            console.error("Invalid data received:", questionData);
            return;
        }

        document.querySelector(".question").textContent = questionData.questionText;

        const answerSection = document.querySelector(".answer-selection");
        answerSection.innerHTML = "";

        questionData.answerList.forEach(answer => {
            const button = createAnswerButton(answer.answerText);
            answerSection.appendChild(button);
        });
    }

	// 답변 버튼 생성 및 리스너 추가
    function createAnswerButton(answerText) {
        const button = document.createElement("button");
        button.classList.add("answer-btn");
        button.textContent = answerText;

        addAnswerButtonListener(button, answerId++);
        return button;
    }

	// 버튼 클릭 시 답변 전송 및 보트 이동
    function addAnswerButtonListener(button, answerId) {
        button.addEventListener("click", function () {
            sendAnswer(answerId, button.textContent.trim());
            moveBoat();
        });
    }

	// 보트 이동
    function moveBoat() {
        boatPosition += 30;
        boatIcon.style.left = `${boatPosition}px`;
        boatIcon.style.transform = "translateY(-10%) rotate(-5deg)";

        setTimeout(() => {
            boatIcon.style.transform = "translateY(-10%) rotate(0deg)";
        }, 500);
    }
});
