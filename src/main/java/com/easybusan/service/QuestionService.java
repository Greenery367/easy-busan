package com.easybusan.service;

import com.easybusan.dto.UserKindTestDTO;
import com.easybusan.repository.interfaces.AnswerRepository;
import com.easybusan.repository.interfaces.QuestionRepository;
import com.easybusan.repository.interfaces.UserKindRepository;
import com.easybusan.repository.model.Answer;
import com.easybusan.repository.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final UserKindRepository userKindRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    /**
     * 질문 페이지에 처음 들어왔을 때 호출
     * @param userId
     * @return
     */
    @Transactional
    public UserKindTestDTO.ResponseDTO firstQuestion(int userId) {
        // 해당 유저가 진행중인 테스트가 있는지 확인
        Integer userKindId = userKindRepository.readUserKindIdByUserIdAndKindIdIsNull(userId);
        // 진행중인 테스트가 존재
        if (userKindId != null) {
            return UserKindTestDTO.ResponseDTO.builder().newTest(false).build();
        }
        UserKindTestDTO.ResponseDTO resDTO = null;
        try {
            // 유저 아이디로 테스트 생성 (userKind 생성은 테스트 시작과 같은 의미)
            userKindRepository.create(userId);
            // 최초 이기 때문에 userKindId 있으나 없으나 결과 동일 즉, 아무 질문 가져옴
            Question questionEntity = questionRepository.readQuestionByUserKindId(null);
            System.out.println(questionEntity.getQuestionId());
            List<Answer> answerEntityList = answerRepository.findAnswersByQuestionId(questionEntity.getQuestionId());
            resDTO = UserKindTestDTO.ResponseDTO.of(questionEntity, answerEntityList);
        } catch (Exception e) {
            // TODO 예외 처리
            e.printStackTrace();
        }
        return resDTO;
    }

    /**
     * 다음 질문 호출
     * @param userId
     * @return
     */
    @Transactional
    public UserKindTestDTO.ResponseDTO nextQuestion(int userId) {
        // 현재 진행중인 테스트의 id 받아옴
        UserKindTestDTO.ResponseDTO resDTO = null;
        try {
            Integer userKindId = userKindRepository.readUserKindIdByUserIdAndKindIdIsNull(userId);
            Question questionEntity = questionRepository.readQuestionByUserKindId(userKindId);
            // 해당 테스트에 남은 질문이 없는 경우 즉, 이전 질문이 마지막 질문이었을경우
            if (questionEntity == null) {
                // TODO 성향 매칭 로직 짜야함
                matchUserKind(userKindId, userId);
                return UserKindTestDTO.ResponseDTO.builder().last(true).build();
            }
            List<Answer> answerEntityList = answerRepository.findAnswersByQuestionId(questionEntity.getQuestionId());
            resDTO = UserKindTestDTO.ResponseDTO.of(questionEntity, answerEntityList);
        } catch (Exception e) {
            // TODO 예외 처리
            return null;
        }
        return resDTO;
    }

    private void matchUserKind(Integer userKindId, int userId) {
        // TODO 로직 작성 필요
        // 유저와 맞는 성향(kind) id 받아서 update해야함
    }

}
