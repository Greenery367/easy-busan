-- 1) 자녀가 있으신가요?
-- 네, 초등학생 자녀가 있어요. -> 학군 , 아마트 매매, 전세 , 초 // 41,  11, 12, 13, 14, 8
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (1, 41, 10);
INSERT INTO answer_section(answer_id, section_id, score)
VALUES (1, 11, 5);
INSERT INTO answer_section(answer_id, section_id, score)
VALUES (1, 12, 5);
INSERT INTO answer_section(answer_id, section_id, score)
VALUES (1, 13, 5);
INSERT INTO answer_section(answer_id, section_id, score)
VALUES (1, 14, 5);
INSERT INTO answer_section(answer_id, section_id, score)
VALUES (1, 8, 10);

-- 네, 중학생 자녀가 있어요. -> 학군 , 아마트 매매, 전세 , 중  // 41,  11, 12, 13, 14, 9 
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (2, 41, 10);
INSERT INTO answer_section(answer_id, section_id, score)
VALUES (2, 11, 5);
INSERT INTO answer_section(answer_id, section_id, score)
VALUES (2, 12, 5);
INSERT INTO answer_section(answer_id, section_id, score)
VALUES (2, 13, 5);
INSERT INTO answer_section(answer_id, section_id, score)
VALUES (2, 14, 5);
INSERT INTO answer_section(answer_id, section_id, score)
VALUES (2, 9, 10);

-- 네, 고등학생 자녀가 있어요 -> 학군 , 아마트 매매, 전세, 고  // 41,  11, 12, 13, 14, 10
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (3, 41, 10);
INSERT INTO answer_section(answer_id, section_id, score)
VALUES (3, 11, 5);
INSERT INTO answer_section(answer_id, section_id, score)
VALUES (3, 12, 5);
INSERT INTO answer_section(answer_id, section_id, score)
VALUES (3, 13, 5);
INSERT INTO answer_section(answer_id, section_id, score)
VALUES (3, 14, 5);
INSERT INTO answer_section(answer_id, section_id, score)
VALUES (3, 10, 10);

-- 2) 운동을 다양하게 즐기시나요? 1
-- 네, 다양하게 즐기지만 가끔 운동해요. -> 생활체육시설
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (5, 1, 3);
-- 네, 다양하게 즐기고 자주 운동해요. -> 생활체육시설
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (6, 1, 6);
--  네, 다양하게 하고 매일 다른 운동을 해요. -> 생활체육시설
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (7, 1, 9);

-- 3) 어떤 문화생활을 자주 즐기시나요?
-- 극장이나 영화관에 자주 가요. -> 극장/영화관 6
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (9, 6, 10);
-- 도서관이나 박물관에 자주 가요. -> 도서관/박물관 7
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (10, 7, 10);
-- 백화점이나 중대형마트에 자주 가요. 백화점/중대형마트 5 
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (11, 5, 10);
-- 다 자주 가요 -> 극장/영화관, 도서관/박물관, 백화점/중대형마트 5,6,7
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (12, 5, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (12, 6, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (12, 7, 10);



-- 4) 번화가와 주거지역 중 어느곳을 희망하시나요?
-- 주변에 편의점이나 여가생활 즐기게 많은 번화가가 좋아요. -> 편의점,버스,지하철,여가생활 모든 항목 // 42, 3, 4, 
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (13, 42, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (13, 3, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (13, 4, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (13, 43, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (13, 44, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (13, 6, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (13, 7, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (13, 1, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (13, 45, 10);

-- 주변에 즐길게 조금 있는 주거지역이 좋아요.
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (14, 42, 7);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (14, 3, 7);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (14, 4, 7);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (14, 43, 7);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (14, 44, 7);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (14, 6, 7);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (14, 7, 7);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (14, 1, 7);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (14, 45, 7);

-- 주변에 즐길거리는 적어도 조용한 주거지역이 좋아요.
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (15, 42, 4);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (15, 3, 4);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (15, 4, 4);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (15, 43, 4);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (15, 44, 4);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (15, 6, 4);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (15, 7, 4);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (15, 1, 4);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (15, 45, 4);

-- 아주 조용한 주거지역이 좋아요.
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (16, 42, 1);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (16, 3, 1);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (16, 4, 1);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (16, 43, 1);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (16, 44, 1);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (16, 6, 1);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (16, 7, 1);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (16, 1, 1);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (16, 45, 1);


-- 5) 병원에 자주 가셔야하나요?
-- 네, 병원이 조금 많았으면 좋겠어요
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (17, 2, 9);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (17, 46, 9);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (17, 47, 9);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (17, 48, 9);

-- 네, 병원이 많았으면 좋겠어요.
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (18, 2, 6);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (18, 46, 6);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (18, 47, 6);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (18, 48, 6);

-- 아뇨, 병원에 자주 가는 편은 아니에요.
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (19, 2, 3);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (19, 46, 3);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (19, 47, 3);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (19, 48, 3);


-- 6) 바다 주변에 사는걸 희망하시나요?
-- 네, 바다 근처가 좋아요. 근데 꼭 아니어도 돼요.
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (20, 40, 10);
-- 네, 바다 근처에서 살고싶어요.
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (21, 40, 5);

-- 7) 애완동물을 키우시나요?
-- 네, 키우고 있어요. 
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (23, 39, 10);


-- 8) 버스, 지하철 중 어떤 것을 많이 이용하시나요? (버스, 지하철, 둘다, 상관없음)
-- 버스를 자주 이용해요. 
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (25, 3, 10);
-- 지하철을 자주 이용해요. 
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (26, 4, 10);
-- 둘 다 자주 이용해요.
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (27, 3, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (27, 4, 10);
-- 자차가 있어서 상관없어요.
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (28, 49, 10);

-- 9) 전세를 희망하시나요 월세를 희망하시나요 매매를 희망하시나요?
-- 전세
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (29, 11, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (29, 12, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (29, 17, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (29, 18, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (29, 23, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (29, 24, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (29, 29, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (29, 30, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (29, 33, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (29, 34, 10);

-- 월세
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (30, 15, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (30, 16, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (30, 21, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (30, 22, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (30, 27, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (30, 28, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (30, 31, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (30, 32, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (30, 37, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (30, 38, 10);

-- 매매
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (31, 13, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (31, 14, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (31, 19, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (31, 20, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (31, 25, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (31, 26, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (31, 35, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (31, 36, 10);

-- 10) 선호하는 주거형태를 골라주세요.
-- 아파트
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (33, 12, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (33, 14, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (33, 16, 10);

-- 주택
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (34, 34, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (34, 36, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (34, 38, 10);

-- 오피스텔
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (35, 24, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (35, 26, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (35, 28, 10);

-- 빌라
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (36, 18, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (36, 20, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (36, 22, 10);

-- 원룸
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (37, 30, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (37, 32, 10);


-- 11) 주거 비용은 상대적으로 어떤 곳이 좋으신가요?
-- 최대한 저렴한 곳
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (38, 11, 20);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (38, 13, 20);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (38, 15, 20);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (38, 19, 20);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (38, 21, 20);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (38, 23, 20);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (38, 25, 20);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (38, 27, 20);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (38, 29, 20);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (38, 31, 20);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (38, 33, 20);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (38, 35, 20);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (38, 37, 20);

-- 적당히 저렴한 곳
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (39, 11, 15);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (39, 13, 15);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (39, 15, 15);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (39, 19, 15);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (39, 21, 15);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (39, 23, 15);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (39, 25, 15);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (39, 27, 15);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (39, 29, 15);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (39, 31, 15);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (39, 33, 15);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (39, 35, 15);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (39, 37, 15);

-- 조금 비싸도 오케이
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (40, 11, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (40, 13, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (40, 15, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (40, 19, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (40, 21, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (40, 23, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (40, 25, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (40, 27, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (40, 29, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (40, 31, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (40, 33, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (40, 35, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (40, 37, 10);


-- 12) 치안을 중요하게 생각하시나요?
-- 중요하지만 신경 안 써요
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (42, 50, 4);
-- 좀 중요
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (43, 50, 7);
-- 매우 중요
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (44, 50, 10);


-- 13) 대중목욕탕에 많은곳이 좋으신가요?
-- 적당히 있는 곳
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (46, 51, 4);
-- 많은 곳
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (47, 51, 7);
-- 많으면 많을 수록 좋음
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (48, 51, 10);


-- 14) 택배 업무를 자주 보시나요?
-- 가끔
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (50, 52, 4);
-- 자주
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (51, 52, 7);
-- 매일
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (52, 52, 10);


-- 15) 술을 좋아하시나요?
-- 월 1회
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (54, 53, 4);
-- 주 1회
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (55, 53, 7);
-- 매일
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (56, 53, 10);


-- 16) 카페를 자주 가시나요?
-- 월 1회
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (58, 56, 4);
-- 주 1회
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (59, 56, 7);
-- 매일
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (60, 56, 10);


-- 17) 나이와 성별이 어떻게 되시나요?
-- 2030 남성
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (62, 43, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (62, 54, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (62, 1, 10);

-- 2030 여성
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (63, 54, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (63, 55, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (63, 56, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (63, 5, 10);

-- 4050 남성
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (64, 54, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (64, 55, 10);

-- 4050 여성
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (65, 54, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (65, 55, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (65, 56, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (65, 5, 10);


-- 18) 차량을 소지하고 계신가요?
-- 월 1회 사용
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (66, 49, 3);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (66, 57, 3);

-- 주 1회 사용
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (67, 49, 7);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (67, 57, 7);

-- 매일 사용
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (68, 49, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (68, 57, 10);

-- 대중교통 사용
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (69, 3, 10);
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (69, 4, 10);


-- 19) 고속버스를 자주 이용하시나요?
-- 월 1회
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (70, 59, 4);
-- 주 1회
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (71, 59, 7);
-- 매일
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (72, 59, 10);


-- 20) 비행기를 자주 이용하시나요?
-- 반기
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (74, 60, 7);
-- 분기
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (75, 60, 10);
-- 연 1회
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (76, 60, 4);


-- 21) 기차를 자주 이용하시나요?
-- 월 1회
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (78, 58, 4);
-- 주 1회
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (79, 58, 7);
-- 매일
INSERT INTO answer_section (answer_id, section_id, score)
VALUES (80, 58, 10);