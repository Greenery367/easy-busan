package com.easybusan.controller;

import com.easybusan.dto.UserAnswerDTO;
import com.easybusan.dto.UserKindTestDTO;
import com.easybusan.exception.errors.Exception401;
import com.easybusan.exception.errorsRest.RestException401;
import com.easybusan.repository.model.User;
import com.easybusan.service.QuestionService;
import com.easybusan.service.UserAnswerService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class QuestionRestController {

    private final UserAnswerService userAnswerService;
    private final QuestionService questionService;

    @PostMapping("/user-answer")
    public ResponseEntity<?> answerQuestion(@RequestBody UserAnswerDTO.CreateDTO reqDTO, HttpSession session) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            throw new RestException401("로그인이 필요합니다.");
        }
        int userId = sessionUser.getUserId();
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

    @GetMapping("/user-answer")
    public ResponseEntity<?> getUserAnswer(HttpSession session) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            throw new RestException401("로그인이 필요합니다.");
        }
        int userId = sessionUser.getUserId();
        Map<String, Object> response = new HashMap<>();
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
    }

    @DeleteMapping("/user-answer")
    public ResponseEntity<?> deleteUserAnswer(HttpSession session) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            throw new RestException401("로그인이 필요합니다.");
        }
        int userId = sessionUser.getUserId();
        Map<String, Object> response = new HashMap<>();
        if ( questionService.deleteUserAnswer(userId)) {
            response.put("success", true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.put("success", false);
            response.put("message", "서버 오류");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
