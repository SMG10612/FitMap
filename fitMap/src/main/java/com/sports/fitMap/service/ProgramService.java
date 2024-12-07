package com.sports.fitMap.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sports.fitMap.model.Program;
import com.sports.fitMap.repository.ProgramRepository;

@Service
public class ProgramService {

    @SuppressWarnings("unused")
	@Autowired
    private ProgramRepository programRepository;

//    @Autowired
//    private ProgramMapper programMapper;

    public List<Program> getAllPrograms() {
        // 예시: 데이터베이스에서 모든 프로그램을 조회하는 서비스 메서드
        List<Program> programs = programRepository.findAll();
        if (programs == null) {
            // 빈 리스트로 반환하거나 적절한 예외 처리
            return Collections.emptyList();
        }
        System.out.println("Fetched programs: " + programs);

        return programs;
    }
    
    public Page<Program> getProgramsWithPaging(String searchType, String searchKeyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);  // PageRequest.of(page, size)로 Pageable 객체 생성
        if (searchKeyword == null || searchKeyword.trim().isEmpty())
            return programRepository.findAll(pageable);  // 검색어가 비었거나 공백일 경우 모든 프로그램 반환
        
        if (searchType.equals("시설명")) return programRepository.findByFcltyNmContaining(searchKeyword, pageable);
        else return programRepository.findByProgrmNmContaining(searchKeyword, pageable);
    }
}

