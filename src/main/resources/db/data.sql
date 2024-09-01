-- 결과 페이지 확인용 샘플 데이터
INSERT INTO users (type) VALUES ('member');
INSERT INTO kind (kind_name, kind_text) VALUES ('성향1','성향1의 설명');
INSERT INTO kind (kind_name, kind_text) VALUES ('성향2','성향2의 설명');
INSERT INTO kind (kind_name, kind_text) VALUES ('성향3','성향3의 설명');
INSERT INTO user_kind (user_id, kind_id) VALUES (1, 1);