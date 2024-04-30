package com.quora.apimodels.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModifyAnswerResponseDTO {
    private UUID answerId;
    private String answer;
}
