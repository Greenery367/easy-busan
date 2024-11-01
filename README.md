# <이지 부산 : 맞춤형 부산 이주 컨설팅 웹서비스🗺>
### Springboot와 공공 API를 사용한 부산 이주 컨설팅 사이트
&nbsp; 
&nbsp;
![제목을-입력해주세요_-001 (3)](https://github.com/user-attachments/assets/93c138a0-5207-4152-94f2-aa9bc3cc1e40)


* 노션 : https://coffee-pike-9e2.notion.site/Easy-Busan-6bfb34829e274e14947c3904e15f5e27?pvs=4
* 유튜브 시연 영상 : https://www.youtube.com/watch?v=4SEdc42ile0


&nbsp;
### 목차
1. 프로젝트 개요
2. 구성원 및 맡은 역할
3. 서비스 환경
4. 사용 외부 API
5. 주요 기능
6. ERD 다이어그램
&nbsp; &nbsp;&nbsp;
## 1️⃣ 프로젝트 개요
### (1) 프로젝트 주제 및 목적
-부산 인구 유출을 해결하기 위한 부산 이주 컨설팅 웹사이트
### (2) 프로젝트 핵심 기능
-개인별 맞춤형 부산 이주 컨설팅 테스트 
## 2️⃣ 구성원 및 맡은 역할
|이름|역할|맡은 역할|
|------|---|---|
|엄송현|팀장| API 데이터 파싱 및 데이터 삽입 |
|강경훈|팀원| DB 설계 및 질문-결과 로직 구현 |
|박준수|팀원| 전체 UI 설계 및 구현 |
|서영수|팀원| 커뮤니티 게시판, 질문-결과 로직 구현 |
## 3️⃣ 서비스 환경 
|유형|구분|서비스 배포 환경|
|------|---|---|
|SW|OS| Windows11 |
||Browser| Chrome 121.0.6167.161 |
||Tool| Spring Tool Suite, IntelliJ |
||BackEnd| Java 17 & h2 & MyBatis |
||Version/Issue 관리| GitHub & GitBash |
||Communication| Discord & Notion & Jira |

## 4️⃣ 사용 외부 API
### (1) 사용 외부 API
|기능|API 명|제공|용도|
|------|---|---|---|
|데이터 수집|국토교통부_단독/다가구 전월세 실거래가 자료|-----|-----|
||국토교통부_오피스텔 전월세 실거래가 자료|-----|-----|
||국토교통부_연립다세대 전월세 실거래가 자료|-----|-----|
||국토교통부_아파트 전월세 실거래가 자료|-----|-----|
||부산광역시_부산버스정보시스템|-----|-----|
||시군구별 생활업종 정보|-----|-----|
||리버스 지오코딩(WGS84)|-----|-----|

## 4️⃣ ERD 다이어그램
![image](https://github.com/user-attachments/assets/6a4942c3-f8ae-4d58-830d-ca5e41111ea2)


## 5️⃣ 주요 기능 및 화면 소개 &nbsp;
#### (1) 회원 가입
![회원 가입 페이지](https://github.com/user-attachments/assets/495278c1-b07c-4209-8550-ae0141e14cb5)

#### (2) 로그인
![로그인 페이지](https://github.com/user-attachments/assets/855cf953-996d-4f87-ac9d-fd077b1deb56)

#### (3) 메인 화면
![메인 페이지](https://github.com/user-attachments/assets/1c850912-fa4a-4aed-99b5-e3a6642e550b)
![메인 페이지2](https://github.com/user-attachments/assets/568adfa9-7b09-4834-8a29-0ee48e9ba57c)
![메인 페이지3](https://github.com/user-attachments/assets/53e021cb-9f0b-4c39-80f2-44d725940cba)

#### (4) 질문 페이지
![질문 페이지](https://github.com/user-attachments/assets/d61eea5b-f376-41be-85bc-fbf6a50f42d0)

#### (5) 결과 페이지
![테스트 결과 페이지 (2)](https://github.com/user-attachments/assets/a578bc09-4f69-4620-bba5-92f7a1a76093)

#### (6) 정보 페이지
![정보 페이지 3](https://github.com/user-attachments/assets/44df2e0a-fb7f-4a95-963b-a5342eb7d2e1)

#### (7) 커뮤니티 게시판
![커뮤니티 페이지3](https://github.com/user-attachments/assets/28332183-c85a-4395-acac-6c491bdd5372)

