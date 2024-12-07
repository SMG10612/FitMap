package com.sports.fitMap.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "facility_program")
public class Program {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
    @Column(name = "FCLTY_NM")
    private String fcltyNm;                  // 시설명
    
    @Column(name = "FCLTY_TY_NM")
    private String fcltyTyNm;                // 시설유형명
    
    @Column(name = "CTPRVN_CD")
    private String ctvprvnCd;                // 시도코드
    
    @Column(name = "CTPRVN_NM")
    private String ctvprvnNm;                // 시도명
    
    @Column(name = "SIGNGU_CD")
    private String signguCd;                 // 시군구코드
    
    @Column(name = "SIGNGU_NM")
    private String signguNm;                 // 시군구명
    
    @Column(name = "FCLTY_ADDR")
    private String fcltyAddr;                // 시설주소
    
    @Column(name = "FCLTY_TEL_NO")
    private String fcltyTelNo;               // 시설전화번호
    
	@Column(name = "PROGRM_TY_NM")
    private String progrmTyNm;               // 프로그램유형명
    
    @Column(name = "PROGRM_NM")
    private String progrmNm;                 // 프로그램명
    
    @Column(name = "PROGRM_TRGET_NM")
    private String progrmTrgetNm;            // 프로그램대상명
    
    @Getter(AccessLevel.NONE)
    @Column(name = "PROGRM_BEGIN_DE")
    private String progrmBeginDe;            // 프로그램시작일자
    
    @Getter(AccessLevel.NONE)
    @Column(name = "PROGRM_END_DE")
    private String progrmEndDe;              // 프로그램종료일자
    
    @Column(name = "PROGRM_ESTBL_WKDAY_NM")
    private String progrmEstblWkdayNm;       // 프로그램개설요일명
    
    @Column(name = "PROGRM_ESTBL_TIZN_VALUE")
    private String progrmEstblTiznValue;     // 프로그램개설시간대값
    
    @Column(name = "PROGRM_RCRIT_NMPR_CO")
    private int progrmRcritNmprCo;    	   	 // 프로그램모집인원수
    
    @Getter(AccessLevel.NONE)
    @Column(name = "PROGRM_PRC")
    private int progrmPrc;           		 // 프로그램가격
    
    @Column(name = "PROGRM_PRC_TY_NM")
    private String progrmPrcTyNm;            // 프로그램가격유형명
    
    @Column(name = "HMPG_URL")
    private String hmpgUrl;                  // 홈페이지URL
    
    @Column(name = "SAFE_MANAGT_CN")
    private String safeManagtCn;             // 안전조치내용
    
    @Column(name = "EDC_GOAL_CN")
    private String edcGoalCn;                // 교육목표내용
    
    @Column(name = "PRTC_NMPR_PARTCPT_AT")
    private String prtcNmprPartcptAt;        // 보호인원참가여부
    
    @Column(name = "LDR_QUALF_CN")
    private String ldrQualfCn;               // 지도자자격내용

    // 날짜 형식 변환 예) 20010130 -> 2001-01-30
    public String getProgrmBeginDe() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(progrmBeginDe, formatter);
        return date.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일"));
    }

    // 날짜 형식 변환 예) 20010130 -> 2001-01-30
    public String getProgrmEndDe() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(progrmEndDe, formatter);
        return date.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일"));
    }

    // String.format() 사용 - 가격을 60000과 같은 숫자를 60,000 형식으로 변환
	public String getProgrmPrc() {
		return String.format("%,d", progrmPrc) + "원";
	}
    
    

    
    
    
}
