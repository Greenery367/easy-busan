package com.easybusan.repository.model;
import lombok.*;
import java.sql.Timestamp;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private Integer questionId;
    private String questionText;
    private Integer parentId;
    private String tip;
    private Timestamp createdAt;

}
