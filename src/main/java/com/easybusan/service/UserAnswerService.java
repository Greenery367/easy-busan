package com.easybusan.service;

import com.easybusan.repository.interfaces.UserAnswerRespository;
import com.easybusan.repository.interfaces.UserKindRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserAnswerService {

    private final UserAnswerRespository userAnswerRespository;
    private final UserKindRepository userKindRepository;

    /**
     * 유저 응답 생성
     * @param userId
     * @param answerId
     * @return
     */
    @Transactional
    public boolean createUserAnswer(int userId, int answerId) {
        int result = 0;
        try {
            int userKindId = userKindRepository.readUserKindIdByUserIdAndKindIdIsNull(userId);
            result = userAnswerRespository.createUserAnswer(userId, answerId, userKindId);
        } catch (Exception e) {
            return false;
        }
        if (result == 0){
            return false;
        }
        return true;
    }
}
