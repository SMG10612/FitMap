package com.sports.fitMap.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sports.fitMap.model.Program;

public interface ProgramRepository extends JpaRepository<Program, Integer> {
    // 모든 Program 조회
	//	List<Program> findAll();
	
	// 시설명(fcltyNm) 또는 프로그램명(progrmNm)에 검색어가 포함된 프로그램을 찾는 쿼리
	/*
	 * 	SELECT * FROM program
		WHERE fclty_nm LIKE %searchKeyword% 
		OR progrm_nm LIKE %searchKeyword%;
	 */
//    Page<Program> findByFcltyNmContainingOrProgrmNmContaining(String fcltyNm, String progrmNm, Pageable pageable);
    Page<Program> findByFcltyNmContaining(String fcltyNm, Pageable pageable);
    Page<Program> findByProgrmNmContaining(String progrmNm, Pageable pageable);

}
	
