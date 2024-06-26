package com.quora.service.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionInputDTO {
    private String username;
    private String title;
    private String body;
    private List<String> topicTags;
}
