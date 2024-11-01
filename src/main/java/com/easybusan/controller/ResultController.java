package com.easybusan.controller;

import java.util.List;

import com.easybusan.dto.KindDTO;
import com.easybusan.exception.errors.Exception401;
import com.easybusan.repository.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.easybusan.repository.model.Kind;
import com.easybusan.repository.model.Section;
import com.easybusan.service.ResultService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ResultController {

	private final HttpSession session;
	private final ResultService resultService;

	@GetMapping("/result")
	public String resultPage(Model model) {
		User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            throw new Exception401("로그인이 필요합니다.");
        }
		int userId = sessionUser.getUserId();
		KindDTO.ResponseDTO kind = resultService.readKindByUserId(userId);
		model.addAttribute("data", kind);
		return "/result";
	}

}
