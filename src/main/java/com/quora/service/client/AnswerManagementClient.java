package com.quora.service.client;

import com.quora.entity.AnswerEntity;
import com.quora.entity.QuestionEntity;
import com.quora.entity.UserEntity;
import com.quora.exceptionHandler.CustomException;
import com.quora.mapper.AnswerManagementMapper;
import com.quora.mapper.ModifyAnswerMapper;
import com.quora.repository.AnswerManagementRepository;
import com.quora.repository.QuestionManagementRepository;
import com.quora.repository.UserManagementRepository;
import com.quora.service.models.request.AnswerInputDTO;
import com.quora.service.models.request.ModifyAnswerInputDTO;
import com.quora.service.models.response.AnswerOutputDTO;
import com.quora.service.models.response.ModifyAnswerOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AnswerManagementClient {
    private final AnswerManagementRepository answerManagementRepository;
    private final UserManagementRepository userManagementRepository;
    private final QuestionManagementRepository questionManagementRepository;
    private final ModifyAnswerMapper modifyAnswerMapper = ModifyAnswerMapper.INSTANCE;
    private final AnswerManagementMapper answerManagementMapper = AnswerManagementMapper.INSTANCE;

    @Autowired
    private AnswerManagementClient(
            AnswerManagementRepository answerManagementRepository,
            UserManagementRepository userManagementRepository,
            QuestionManagementRepository questionManagementRepository
    ){
        this.answerManagementRepository = answerManagementRepository;
        this.userManagementRepository = userManagementRepository;
        this.questionManagementRepository = questionManagementRepository;
    }
    public AnswerOutputDTO postAnswer(AnswerInputDTO inputDTO) {
        UserEntity user = userManagementRepository.findByUsername(inputDTO.getUsername());
        if (user == null) {
            throw new CustomException("User not registered. Register to submit an answer.");
        }
        QuestionEntity question = questionManagementRepository.findQuestionEntityById(inputDTO.getQuestionId());
        if(question == null) {
            throw new CustomException("No question found with this questionId. Please enter a valid questionId.");
        }
        AnswerEntity entity = answerManagementMapper.mapInputToEntity(inputDTO);
        entity.setId(UUID.randomUUID());
        entity.setUser(user);
        entity.setQuestion(question);
        answerManagementRepository.save(entity);
        return answerManagementMapper.mapEntityToOutput(entity);
    }

    public ModifyAnswerOutputDTO modifyAnswer(ModifyAnswerInputDTO inputDTO){
        AnswerEntity entity = answerManagementRepository.findAnswerEntitiesById(inputDTO.getAnswerId());
        if(entity == null){
            throw new CustomException("No previous answer found.");
        }
        entity.setAnswer(inputDTO.getAnswer());
        answerManagementRepository.save(entity);
        return modifyAnswerMapper.mapEntityToOutput(entity);
    }

}
