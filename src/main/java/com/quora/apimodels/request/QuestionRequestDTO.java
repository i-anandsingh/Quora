package com.quora.apimodels.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequestDTO {
    private UUID user_Id;
    private String title;
    private String body;
    private List<String> topicTags;
}
