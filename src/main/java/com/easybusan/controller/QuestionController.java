package com.easybusan.controller;

import com.easybusan.dto.KindDTO;
import com.easybusan.dto.UserKindDTO;
import com.easybusan.dto.UserKindTestDTO;
import com.easybusan.exception.errors.Exception401;
import com.easybusan.exception.errorsRest.RestException401;
import com.easybusan.repository.model.User;
import com.easybusan.service.QuestionService;
import com.easybusan.service.UserKindService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final UserKindService userKindService;

    @GetMapping("/question")
    public String question(@RequestParam(name = "continue", defaultValue = "false") boolean isContinue, HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            throw new Exception401("로그인이 필요합니다.");
        }
        int userId = sessionUser.getUserId();
        // 진행중인 성향테스트가 있는지 확인, 없으면 처음부터 있으면 선택지 제공
        // confirm 보내고 yes 일시 기존 테스트 이어서 하기
        // no 일시 진행중인 테스트 all delete,
        UserKindTestDTO.ResponseDTO resDTO = questionService.firstQuestion(userId, isContinue);
        System.out.println("answerlist" + resDTO.getAnswerList());
        model.addAttribute("data", resDTO);
        return "questionTest";
    }

    @PostMapping("/user-kind")
    @ResponseBody
    public ResponseEntity<?> getUserKindByIds(@RequestBody UserKindDTO.UpdateDTO reqDTO, HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            throw new RestException401("로그인이 필요합니다.");
        }
        int userId = sessionUser.getUserId();
        userKindService.getUserKind(reqDTO, userId);
        return ResponseEntity.ok(null);
    }
}
