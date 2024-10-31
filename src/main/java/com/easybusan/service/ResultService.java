package com.easybusan.service;

import java.util.List;

import com.easybusan.dto.KindDTO;
import com.easybusan.exception.errors.Exception500;
import com.easybusan.exception.errorsRest.RestException400;
import com.easybusan.repository.interfaces.SectionCategoryRepository;
import com.easybusan.repository.model.SectionCategory;
import org.springframework.stereotype.Service;

import com.easybusan.repository.interfaces.ResultRepository;
import com.easybusan.repository.model.Kind;
import com.easybusan.repository.model.Section;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResultService {

	private final ResultRepository resultRepository;
	private final SectionCategoryRepository sectionCategoryRepository;

	/**
	 * 해당 유저의 성향 조회
	 */
	public KindDTO.ResponseDTO readKindByUserId(int userId) {
		Kind kindEntity = null;
		try {
			kindEntity = resultRepository.readKindByUserId(userId);
			List<SectionCategory> sectionCategoryList = sectionCategoryRepository.readAll();
			if (kindEntity == null) {
				return KindDTO.ResponseDTO.builder().noResult(true).build();
			}
			return KindDTO.ResponseDTO.of(kindEntity, sectionCategoryList);
		} catch (Exception e) {
			throw new Exception500("서버 오류 발생");
		}
	}

}
