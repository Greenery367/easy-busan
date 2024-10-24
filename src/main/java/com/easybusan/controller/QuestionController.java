package com.easybusan.controller;

import com.easybusan.dto.UserKindTestDTO;
import com.easybusan.service.QuestionService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/question")
    public String question(HttpSession session, Model model) {
        // TODO 세션에서 user_id 받아오도록 변경예정
        // 비회원 기능 아직 없음
        // int userId = (int) session.getAttribute("sessionUser");
        int userId = 1;
        // 진행중인 성향테스트가 있는지 확인, 없으면 처음부터 있으면 선택지 제공
        // confirm 보내고 yes 일시 기존 테스트 이어서 하기
        // no 일시 진행중인 테스트 all delete,
        UserKindTestDTO.ResponseDTO resDTO = questionService.firstQuestion(userId);
        System.out.println(resDTO.getAnswerList());
        model.addAttribute("data", resDTO);
        return "questionTest";
    }
}
