package com.quora.repository.client;

import com.quora.service.models.request.AnswerInputDTO;
import com.quora.service.models.response.AnswerOutputDTO;
import org.springframework.stereotype.Component;

@Component
public interface AnswerManagementClient {
    AnswerOutputDTO postAnswer(AnswerInputDTO inputDTO);
}
