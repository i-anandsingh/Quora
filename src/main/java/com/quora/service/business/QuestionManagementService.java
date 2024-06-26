package com.quora.service.business;

import com.quora.mapper.QuestionManagementMapper;
import com.quora.service.client.QuestionManagementClient;
import com.quora.service.models.request.QuestionInputDTO;
import com.quora.service.models.response.QuestionOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionManagementService {

    private final QuestionManagementClient questionManagementClient;
    private final QuestionManagementMapper questionManagementMapper = QuestionManagementMapper.INSTANCE;


    public QuestionManagementService(QuestionManagementClient questionManagementClient) {
        this.questionManagementClient = questionManagementClient;
    }

    public QuestionOutputDTO postQuestion(QuestionInputDTO inputDTO){
        return questionManagementClient.postQuestion(inputDTO);
    }

    public List<QuestionOutputDTO> searchQuestion(QuestionInputDTO inputDTO){
        return questionManagementClient.searchQuestion(inputDTO);
    }
}
