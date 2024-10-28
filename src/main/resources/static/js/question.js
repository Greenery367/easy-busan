document.addEventListener("DOMContentLoaded", function () {
    let answerId = 1; 
    let boatPosition = 75; 

    const boatIcon = document.querySelector(".boat-icon");
    boatIcon.style.left = `${boatPosition}px`;

    const buttons = document.querySelectorAll(".answer-btn");
    buttons.forEach(button => addAnswerButtonListener(button));

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

    function displayNextQuestion(questionData) {
        if (!questionData || !questionData.answerList) {
            console.error("Invalid data received:", questionData);
            return;
        }

        document.querySelector(".question").textContent = questionData.questionText;

        const answerSection = document.querySelector(".answer-selection");
        answerSection.innerHTML = ""; // 기존 버튼 제거

        questionData.answerList.forEach(answer => {
            const button = document.createElement("button");
            button.classList.add("answer-btn");
            button.textContent = answer.answerText;
            addAnswerButtonListener(button, answer.answerText); // 새 버튼에도 리스너 추가
            answerSection.appendChild(button);
        });
    }

    function addAnswerButtonListener(button, answerText) {
        button.addEventListener("click", function () {
            sendAnswer(answerId, answerText || button.textContent.trim());
            moveBoat();
            answerId++;
        });
    }

    function moveBoat() {
        boatPosition += 30;
        boatIcon.style.left = `${boatPosition}px`;
        boatIcon.style.transform = "translateY(-10%) rotate(-5deg)";

        setTimeout(() => {
            boatIcon.style.transform = "translateY(-10%) rotate(0deg)";
        }, 500);
    }
});
