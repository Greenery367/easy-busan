// TODO 143번째줄 로직 변경

$(document).ready(function() {
    let timerInterval;
    let typingTimer;
    const doneTypingInterval = 1000;
    let isEmailValid = false;
    let isPasswordValid = false;
    let isGenderSelected = false;
    let isSubmitting = false;  
    let isSmsSent = false;     

    // 이메일 입력 체크 및 중복 확인
    $('#email').on('keyup', function() {
        clearTimeout(typingTimer);
        const email = $(this).val();
        
        if (email.length > 0) {
            typingTimer = setTimeout(function() {
                checkEmail(email);
            }, doneTypingInterval);
        } else {
            $('#emailMessage').text('').removeClass('success error');
            $('#email').css('border', '1px solid #ddd');
            isEmailValid = false;
        }
    });

    // 이메일 중복 확인 함수
    function checkEmail(email) {
        if (!email.includes("@")) {
            $('#emailMessage').text('*유효하지 않은 이메일 형식입니다.').addClass('error').removeClass('success');
            $('#email').css('border', '2px solid red');
            isEmailValid = false;
            return;
        }
        
        $.ajax({
            url: '/user/checkUserEmail',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({ email: email }),
            success: function(response) {
                if (response.repetition === "repetition") {
                    $('#emailMessage').text('*중복된 이메일입니다.').addClass('error').removeClass('success');
                    $('#email').css('border', '2px solid red');
                    isEmailValid = false;
                } else {
                    $('#emailMessage').text('*사용 가능한 이메일입니다.').addClass('success').removeClass('error');
                    $('#email').css('border', '1px solid #ddd');
                    isEmailValid = true;
                }
            },
            error: function() {
                $('#emailMessage').text('*이메일 확인 중 오류 발생').addClass('error').removeClass('success');
                $('#email').css('border', '2px solid red');
                isEmailValid = false;
            }
        });
    }

    // 비밀번호 입력 체크
    $('#password').on('keyup', function() {
        clearTimeout(typingTimer);
        const password = $(this).val();
        if (password.length > 0) {
            typingTimer = setTimeout(function() {
                checkPassword(password);
            }, doneTypingInterval);
        } else {
            $('#passwordMessage').text('').removeClass('success error');
            $('#password').css('border', '1px solid #ddd');
            isPasswordValid = false;
        }
    });

    // 성별 체크
    $('input[name="gender"]').on('change', function() {
        isGenderSelected = $('input[name="gender"]:checked').length > 0;
    });

    // 비밀번호 유효성 검사 함수
    function checkPassword(password) {
        const lowercasePattern = /[a-z]/;
        const uppercasePattern = /[A-Z]/;
        const digitPattern = /\d/;
        const specialCharPattern = /[!@#$%^&*()_+|~=`{}\[\]:";'<>?,./]/;

        let matchCount = 0;
        if (lowercasePattern.test(password)) matchCount++;
        if (uppercasePattern.test(password)) matchCount++;
        if (digitPattern.test(password)) matchCount++;
        if (specialCharPattern.test(password)) matchCount++;

        if (password.length >= 8 && password.length <= 16 && matchCount >= 2) {
            $('#passwordMessage').text('*사용 가능한 비밀번호입니다.').removeClass('error').addClass('success');
            $('#password').css('border', '1px solid #ddd');
            isPasswordValid = true;
        } else {
            $('#passwordMessage').text('*비밀번호는 8~16자이고, 영문 대문자, 소문자, 숫자, 특수문자 중 두 가지 이상을 포함해야 합니다.').removeClass('success').addClass('error');
            $('#password').css('border', '2px solid red');
            isPasswordValid = false;
        }
    }

    // 버튼 클릭 이벤트 처리
    $("#sendSmsBtn").on("click", function() {
		
        if (isSubmitting || isSmsSent) return;  

        if (isEmailValid && isPasswordValid && isGenderSelected) {
            const formData = {
                phoneNumber: $("#phoneNumber").val()
            };

            isSubmitting = true;

            fetch('/sms/send', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            })
            .then(response => response.text())
            .then(data => {
                alert("인증번호가 발송되었습니다: ");
                $("#authSection").show(); 
                startTimer(180);  
                $("#sendSmsBtn").text("재발송").prop("disabled", true); 
                isSmsSent = true;  
                $("#email, #password, #user_name, #phoneNumber").prop("readonly", true);
                $("input[name='gender'], input[name='terms']").prop("readonly", true);
            })
            .catch(error => console.error('Error:', error))
            .finally(() => {
                isSubmitting = false;
            });
        } else {
            alert("이메일, 비밀번호, 성별을 올바르게 입력하세요.");
        }
    });
	//TODO 나중에 로직 바꾸기
/*
    // 인증 확인 버튼 클릭 시
    $("#verifyCodeBtn").on("click", function() {
        const authCode = $("#authCodeInput").val();

        fetch('/sms/verify', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ authCode: authCode })
        })
        .then(response => response.text())
        .then(data => {
            if (data.trim() === "Verification successful") {
                alert("인증에 성공했습니다.");
                $("#verifyCodeBtn").text("인증완료").prop("readonly", true);
                $("#authCodeInput").prop("readonly", true);
                clearInterval(timerInterval);
                $("#sendSmsBtn").hide();
                $("#joinDone").show(); 
            } else {
                alert("인증번호가 올바르지 않습니다.");
            }
        })
        .catch(error => console.error('Error:', error));
    });
*/

$("#verifyCodeBtn").on("click", function() {
    alert("인증에 성공했습니다.");
    $("#verifyCodeBtn").text("인증완료").prop("readonly", true);
    $("#authCodeInput").prop("readonly", true);
    clearInterval(timerInterval);
    $("#sendSmsBtn").hide();
    $("#joinDone").show(); 
});

    function startTimer(duration) {
        let timer = duration, minutes, seconds;
        clearInterval(timerInterval);
        timerInterval = setInterval(function() {
            minutes = Math.floor(timer / 60);
            seconds = timer % 60;
            seconds = seconds < 10 ? '0' + seconds : seconds;

            $('#timer').text(`${minutes}:${seconds}`);

            if (--timer < 0) {
                clearInterval(timerInterval);
                $('#timer').text("");
                alert("인증 시간이 만료되었습니다. 인증번호를 재발송해주세요.");
                $("#authCodeInput, #verifyCodeBtn").prop("disabled", true);
                fetch('/clearSessionCode', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                .then(() => {
                    isSmsSent = false;  
                    $("#sendSmsBtn").prop("disabled", false).text("재발송");
                })
                .catch(error => console.error('Error clearing session code:', error));
            }
        }, 1000);
    }
});
