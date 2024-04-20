package com.quora.repository.client;

import com.quora.entity.QuestionEntity;
import com.quora.service.models.request.QuestionInputDTO;
import com.quora.service.models.response.QuestionOutputDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QuestionManagementClient {
    QuestionOutputDTO postQuestion(QuestionInputDTO inputDTO);
    List<QuestionEntity> searchQuestion(QuestionInputDTO inputDTO);
}
