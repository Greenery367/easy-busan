package com.easybusan.repository.interfaces;

import com.easybusan.repository.model.Kind;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KindRepository {

    Kind readKindById(int id);
}
