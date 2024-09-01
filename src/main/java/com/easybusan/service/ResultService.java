package com.easybusan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.easybusan.repository.interfaces.ResultRepository;
import com.easybusan.repository.model.Kind;
import com.easybusan.repository.model.Section;

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

	/**
	 * 해당 유저의 우선도 높은 섹션 3가지 조회
	 */
	public List<Section> readSectionsByUserId(int userId) {
		List<Section> sectionListEntity = null;
		try {
			sectionListEntity = resultRepository.readSectionsByUserId(userId);
			if (sectionListEntity.isEmpty()) {
				// TODO : 예외 처리
			}
			return sectionListEntity;
		} catch (Exception e) {
			// TODO: 예외 처리 -> return 제거
			return null;
		}
	}
}
