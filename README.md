# Alimi 스터디그룹관리앱
## 사용기술
- Springboot 2.5.x
  - Security, JPA-querydsl, lombok, webjar(JQuery, Bootstrap), Modelmapper, java8
- Template-engine
  - Thymeleaf
- DB
  - docker(mysql), h2
- CI/CD
  - AWS EC2, Docker-Gitlab(Gitlab-Runner,docker-compose), docker registry, springboot-jar 배포 (해당기술로 CI/CD예정)

## 기능(개발완료)
- 회원가입, 로그아웃
- 스터디그룹 생성, 삭제, 조회(페이징, 검색), 수정
- 스터디그룹 내 등급설정
- 스터디그룹 카테고리 설정

## 개발중 및 개발예정
- 스터디그룹 참여신청
- 스터디스케줄정보 생성, 삭제, 수정, 조회
- 스터디스케줄 내 회원간 게시글 포스팅 및 댓글 기능

### 프로젝트구조
<img width="174" alt="스크린샷 2021-07-11 오후 5 13 53" src="https://user-images.githubusercontent.com/35190067/125187741-09946e80-e26c-11eb-9af8-404ea4de5487.png">

### 테스트
<img width="325" alt="스크린샷 2021-07-11 오후 5 14 35" src="https://user-images.githubusercontent.com/35190067/125187770-292b9700-e26c-11eb-9bea-67f2f9c6ee4d.png">

## ERD 
<img width="730" alt="스크린샷 2021-07-11 오후 5 15 53" src="https://user-images.githubusercontent.com/35190067/125187794-56784500-e26c-11eb-9b12-578f99d458a4.png">

- account 회원
- study_group 스터디그룹
  - study_group_membere 스터디-회원 N:N관계 해소 테이블
- category 카테고리
- schedule_info 스터디정보 스케줄
  - study_reservation 스터디그룹-스터디정보 N:N관계 해소 테이블
- study_join 스터디그룹 참가요청

## UI
<img width="1283" alt="스크린샷 2021-07-11 오후 5 31 42" src="https://user-images.githubusercontent.com/35190067/125188260-3a75a300-e26e-11eb-8eb5-3118376662e8.png">
<img width="1165" alt="스크린샷 2021-07-11 오후 5 32 02" src="https://user-images.githubusercontent.com/35190067/125188277-4497a180-e26e-11eb-9d09-17856ab91692.png">

