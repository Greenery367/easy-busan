package com.easybusan.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectionCategory {
    private Integer sectionCategoryId;
    private String sectionCategoryName;
}
