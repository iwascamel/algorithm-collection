## 날짜

* 22.01.20 (목)

## 문제
* head 기준
    * 사전 순 정렬
    * 대소문자 구분 x
* head 같을 경우
    * number 로 구분
    * 숫자 정렬
* head, number 같은 경우
    * 순서 유지

## 풀이

* string[] 에서 각 head, 숫자 분리
* 조건에 따라 정렬 ( index 도 넣어줌 )
* 정렬된 값에 따라 결과 반환

## 정리해야 되는 개념

* string compare to
* char 비교
* Integer.parseInt - Integer.valueOf 차이
* Comparator 비교 연산
* Character.isDigit - isAlphabetic