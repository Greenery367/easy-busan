package com.easybusan.controller;

import java.util.List;

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

	@GetMapping("result")
	public String resultPage(Model model) {
		// TODO 세션에서 user_id 받아오도록 변경예정
		// int userId = (int) session.getAttribute("sessionUser");
		int userId = 1;
		Kind kind = resultService.readKindByUserId(userId);
		List<Section> sectionList = resultService.readSectionsByUserId(userId);
		model.addAttribute("kind", kind);
		model.addAttribute("sectionList", sectionList);
		return "result";
	}

}
