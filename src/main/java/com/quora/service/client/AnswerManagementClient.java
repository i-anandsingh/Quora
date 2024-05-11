package com.quora.service.client;

import com.quora.service.models.request.AnswerInputDTO;
import com.quora.service.models.request.ModifyAnswerInputDTO;
import com.quora.service.models.response.AnswerOutputDTO;
import com.quora.service.models.response.ModifyAnswerOutputDTO;
import org.springframework.stereotype.Component;

@Component
public interface AnswerManagementClient {
    AnswerOutputDTO postAnswer(AnswerInputDTO inputDTO);
    ModifyAnswerOutputDTO modifyAnswer(ModifyAnswerInputDTO inputDTO);
}
