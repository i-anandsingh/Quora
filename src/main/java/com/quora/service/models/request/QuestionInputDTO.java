package com.quora.service.models.request;

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
public class QuestionInputDTO {
    private UUID id;
    private String title;
    private String body;
    private String text;
    private List<String> topicTags;
}
