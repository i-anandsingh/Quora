package com.quora.service.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerOutputDTO {
    private UUID answer_id;
    private UUID question_id;
    private UUID user_id;
    private String text;
    private Date createdAt;
}
