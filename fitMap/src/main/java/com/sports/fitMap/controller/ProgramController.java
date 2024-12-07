package com.sports.fitMap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sports.fitMap.model.Program;
import com.sports.fitMap.service.ProgramService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProgramController {

    @Autowired
    private ProgramService programService;
    
    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        // 기본 페이지로 리다이렉트
        return "redirect:/programs?page=0&size=8";

    }
    
    @GetMapping("/programs")
    public String getPrograms(
    		@RequestParam(name = "searchType", required = false, defaultValue = "시설명") String searchType,
    		@RequestParam(name = "searchKeyword", required = false, defaultValue = "") String searchKeyword,
    		@RequestParam(name = "page", defaultValue = "0") int page, 
            @RequestParam(name = "size", defaultValue = "8") int size,
            Model model) {
        // 페이징 처리된 결과 가져오기
        Page<Program> programPage = programService.getProgramsWithPaging(searchType, searchKeyword, page, size);

        // 모델에 데이터와 페이징 정보를 추가
        model.addAttribute("programs", programPage.getContent()); // 현재 페이지의 프로그램 목록
        model.addAttribute("currentPage", page);                  // 현재 페이지 번호
        model.addAttribute("totalPages", programPage.getTotalPages());  // 총 페이지 수
        model.addAttribute("totalItems", programPage.getTotalElements()); // 총 데이터 수
        model.addAttribute("searchType", searchType);  // searchType 추가
        model.addAttribute("searchKeyword", searchKeyword);  // searchKeyword 추가
        
        return "index";
    }
    
    /*
     * 시설명, 프로그램명에 따른 검색결과가 나오긴하나
     * 그 다음 페이지에는 초기화 됨.
     */
    
}

