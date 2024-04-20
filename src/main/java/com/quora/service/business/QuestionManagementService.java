package com.quora.service.business;

import com.quora.repository.client.impl.QuestionManagementClientImpl;
import com.quora.service.models.request.QuestionInputDTO;
import com.quora.service.models.response.QuestionOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionManagementService {

    private final QuestionManagementClientImpl questionManagementClientImpl;

    @Autowired
    public QuestionManagementService(QuestionManagementClientImpl questionManagementClientImpl) {
        this.questionManagementClientImpl = questionManagementClientImpl;
    }

    public QuestionOutputDTO postQuestion(QuestionInputDTO inputDTO){
        return questionManagementClientImpl.postQuestion(inputDTO);
    }
}
