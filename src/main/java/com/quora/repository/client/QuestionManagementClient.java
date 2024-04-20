package com.quora.repository.client;

import com.quora.service.models.request.QuestionInputDTO;
import com.quora.service.models.response.QuestionOutputDTO;
import org.springframework.stereotype.Component;

@Component
public interface QuestionManagementClient {
    QuestionOutputDTO postQuestion(QuestionInputDTO inputDTO);
}
