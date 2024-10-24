package com.easybusan.controller;

import com.easybusan.dto.UserAnswerDTO;
import com.easybusan.dto.UserKindTestDTO;
import com.easybusan.service.QuestionService;
import com.easybusan.service.UserAnswerService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class QuestionRestController {

    private final UserAnswerService userAnswerService;
    private final QuestionService questionService;

    @PostMapping("/user-answer")
    public ResponseEntity<?> answerQuestion(@RequestBody UserAnswerDTO.CreateDTO reqDTO, HttpSession session) {
        // TODO 세션에서 user_id 받아오도록 변경예정
        // int userId = (int) session.getAttribute("sessionUser");
        int userId = 1;
        // TODO 서비스로 위임
        System.out.println(reqDTO.getAnswerId());
        Map<String, Object> response = new HashMap<>();
        if (userAnswerService.createUserAnswer(userId, reqDTO.getAnswerId())){
            UserKindTestDTO.ResponseDTO resDTO = questionService.nextQuestion(userId);
            if (resDTO != null) {
                response.put("success", true);
                response.put("data", resDTO);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                response.put("success", false);
                response.put("message", "서버 오류");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        } else {
            // 오류 처리
            response.put("success", false);
            response.put("message", "서버 오류");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
