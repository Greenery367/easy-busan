package com.easybusan.service;

import org.springframework.stereotype.Service;

import com.easybusan.repository.interfaces.ResultRepository;
import com.easybusan.repository.model.Kind;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResultService {

	private final ResultRepository resultRepository;
	
	/**
	 * 해당 유저의 성향 조회
	 */
	public Kind readKindByUserId(int userId) {
		Kind kindEntity = null;
		try {
			kindEntity = resultRepository.readKindByUserId(userId);
			if (kindEntity == null) {
				// TODO : 예외 처리
			} 
			return kindEntity;
		} catch (Exception e) {
			// TODO: 예외 처리 -> return 제거
			return null;
		}
	}
}
