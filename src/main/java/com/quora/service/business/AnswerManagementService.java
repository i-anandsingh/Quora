package com.quora.service.business;

import com.quora.mapper.AnswerManagementMapper;
import com.quora.repository.client.impl.AnswerManagementClientImpl;
import com.quora.service.models.request.AnswerInputDTO;
import com.quora.service.models.response.AnswerOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerManagementService {
    private AnswerManagementClientImpl answerManagementClientImpl;
    private AnswerManagementMapper answerManagementMapper = AnswerManagementMapper.INSTANCE;

    @Autowired
    private AnswerManagementService(AnswerManagementClientImpl answerManagementClientImpl){
        this.answerManagementClientImpl = answerManagementClientImpl;
    }

    public AnswerOutputDTO postAnswer(AnswerInputDTO inputDTO){
        return answerManagementClientImpl.postAnswer(inputDTO);
    }
}
