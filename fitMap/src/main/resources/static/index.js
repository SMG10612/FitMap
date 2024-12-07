const regions = {
    "서울특별시": ["강남구", "강동구", "강북구", "강서구", "관악구", "용산구", "구로구",
        "노원구", "광진구", "마포구", "금천구", "중구", "도봉구", "종로구",
        "중랑구", "송파구", "서초구", "영등포구", "동대문구", "서대문구", "동작구",
        "성동구", "성북구", "은평구", "양천구"],

    "경기도": ["수원시", "고양시", "용인시", "성남시", "부천시", "안산시", "안양시", "남양주시",
        "화성시", "평택시", "의정부시", "파주시", "광명시", "김포시", "광주시", "군포시",
        "오산시", "이천시", "양주시", "구리시", "안성시", "포천시", "의왕시", "하남시",
        "여주시", "양평군", "가평군", "연천군"],

    "부산광역시": ["중구", "서구", "동구", "남구", "북구", "영도구", "부산진구",
        "해운대구", "수영구", "금정구", "동래구", "연제구", "사상구", "사하구", "기장군"],

    "인천광역시": ["남동구", "중구", "동구", "남구", "미추홀구", "연수구",
        "부평구", "계양구", "강화군", "옹진군"],

    "대구광역시": ["중구", "동구", "서구", "남구", "북구", "수성구",
        "달서구", "달성군", "군위군"],

    "광주광역시": ["동구", "서구", "남구", "북구", "광산구"],

    "대전광역시": ["동구", "중구", "서구", "유성구", "대덕구"],

    "울산광역시": ["중구", "남구", "동구", "북구", "울주군"]
};

// 지역 선택에 따라 군구를 업데이트하는 함수
function updateDistrictOptions() {
    const regionSelect = document.getElementById("region");
    const districtSelect = document.getElementById("district");
    const selectedRegion = regionSelect.value;

    // 군구 목록 초기화
    districtSelect.innerHTML = '<option value="">군구 선택</option>';

    if (selectedRegion && regions[selectedRegion]) {
        regions[selectedRegion].forEach(district => {
            const option = document.createElement("option");
            option.value = district;
            option.textContent = district;
            districtSelect.appendChild(option);
        });
    }
}

        // "조건 검색" 버튼을 클릭했을 때 필터링 옵션을 토글하는 기능
document.querySelector('.toggle-filter').addEventListener('click', function() {
    const filterOptions = document.querySelector('.filter-options');
    
    // 필터링 옵션의 표시/숨기기 전환
    if (filterOptions.style.display === 'none' || filterOptions.style.display === '') {
        filterOptions.style.display = 'block'; // 표시
    } else {
        filterOptions.style.display = 'none'; // 숨기기
    }
});