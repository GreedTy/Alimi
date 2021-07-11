# Alimi 스터디그룹관리앱
- Springboot 2.5.x
  - Security, JPA-querydsl, lombok, webjar(JQuery, Bootstrap), Modelmapper, java8
- Template-engine
  - Thymeleaf
- DB
  - docker(mysql), h2
- CI/CD
  - Docker-Gitlab(Gitlab-Runner,docker-compose), docker registry, springboot-jar 배포

### 프로젝트구조
<img width="174" alt="스크린샷 2021-07-11 오후 5 13 53" src="https://user-images.githubusercontent.com/35190067/125187741-09946e80-e26c-11eb-9af8-404ea4de5487.png">

### 테스트
<img width="325" alt="스크린샷 2021-07-11 오후 5 14 35" src="https://user-images.githubusercontent.com/35190067/125187770-292b9700-e26c-11eb-9bea-67f2f9c6ee4d.png">

### DB설계 
<img width="730" alt="스크린샷 2021-07-11 오후 5 15 53" src="https://user-images.githubusercontent.com/35190067/125187794-56784500-e26c-11eb-9b12-578f99d458a4.png">
- account 회원
- study_group 스터디그룹
  - study_group_membere 스터디-회원 N:N관계 해소 테이블
- category 카테고리
- schedule_info 스터디정보 스케줄
  - study_reservation 스터디그룹-스터디정보 N:N관계 해소 테이블
- study_join 스터디그룹 참가요청
