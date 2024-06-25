package com.quora.service.client;

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

@Component
public class AnswerManagementClient {
    private AnswerManagementRepository answerManagementRepository;
    private UserManagementRepository userManagementRepository;
    private QuestionManagementRepository questionManagementRepository;
    private ModifyAnswerMapper modifyAnswerMapper = ModifyAnswerMapper.INSTANCE;
    private AnswerManagementMapper answerManagementMapper = AnswerManagementMapper.INSTANCE;

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
//        UserEntity user = userManagementRepository.findByUsername(inputDTO.getUsername());
//        QuestionEntity question = questionManagementRepository.findByQuestionId(inputDTO.getQuestionId());
//        if (user == null) {
//            throw new CustomException("Register yourself first.");
//        }
//        AnswerEntity entity = answerManagementMapper.mapInputToEntity(inputDTO);
//        entity.setId(UUID.randomUUID());
//        entity.setUser(user);
//        entity.setQuestion(question);
//        answerManagementRepository.save(entity);
//        return answerManagementMapper.mapEntityToOutput(entity);
        return null;
    }

    public ModifyAnswerOutputDTO modifyAnswer(ModifyAnswerInputDTO inputDTO){
//        AnswerEntity entity = answerManagementRepository.findByAerId(inputDTO.getAnswerId());
//        if(entity == null){
//            // TODO -> return an exception
//            return null;
//        }
//        entity.setAnswer(inputDTO.getAnswer());
//        answerManagementRepository.save(entity);
//        return modifyAnswerMapper.mapEntityToOutput(entity);
        return null;
    }

}
