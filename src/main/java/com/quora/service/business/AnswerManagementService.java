package com.quora.service.business;

import com.quora.service.client.AnswerManagementClient;
import com.quora.service.models.request.AnswerInputDTO;
import com.quora.service.models.request.ModifyAnswerInputDTO;
import com.quora.service.models.response.AnswerOutputDTO;
import com.quora.service.models.response.ModifyAnswerOutputDTO;
import org.springframework.stereotype.Service;

@Service
public class AnswerManagementService {
    private final AnswerManagementClient answerManagementClient;

    private AnswerManagementService(AnswerManagementClient answerManagementClient){
        this.answerManagementClient = answerManagementClient;
    }

    public AnswerOutputDTO postAnswer(AnswerInputDTO inputDTO){
        return answerManagementClient.postAnswer(inputDTO);
    }

    public ModifyAnswerOutputDTO modifyAnswer(ModifyAnswerInputDTO inputDTO){
        return answerManagementClient.modifyAnswer(inputDTO);
    }
}
