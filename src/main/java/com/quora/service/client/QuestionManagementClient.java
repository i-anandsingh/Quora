package com.quora.service.client;

import com.quora.entity.QuestionEntity;
import com.quora.entity.TopicEntity;
import com.quora.entity.UserEntity;
import com.quora.exceptionHandler.CustomException;
import com.quora.mapper.QuestionManagementMapper;
import com.quora.repository.QuestionManagementRepository;
import com.quora.repository.TopicManagementRepository;
import com.quora.repository.UserManagementRepository;
import com.quora.service.business.TopicManagementService;
import com.quora.service.models.request.QuestionInputDTO;
import com.quora.service.models.request.TopicInputDTO;
import com.quora.service.models.response.QuestionOutputDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class QuestionManagementClient {
    private final QuestionManagementRepository questionManagementRepository;
    private final UserManagementRepository userManagementRepository;
    private final TopicManagementService topicManagementService;
    private final TopicManagementRepository topicManagementRepository;
    private final QuestionManagementMapper questionManagementMapper = QuestionManagementMapper.INSTANCE;


    public QuestionManagementClient(
            QuestionManagementRepository questionManagementRepository,
            UserManagementRepository userManagementRepository,
            TopicManagementService topicManagementService,
            TopicManagementRepository topicManagementRepository
    ){
        this.userManagementRepository = userManagementRepository;
        this.topicManagementService = topicManagementService;
        this.questionManagementRepository = questionManagementRepository;
        this.topicManagementRepository = topicManagementRepository;
    }


    public QuestionOutputDTO postQuestion(QuestionInputDTO inputDTO) {
        UserEntity user = userManagementRepository.findByUsername(inputDTO.getUsername());
        if (user == null) {
            throw new CustomException("Please create an account first.");
        }
        TopicInputDTO topicInputDTO = new TopicInputDTO();
        topicInputDTO.setTopics(inputDTO.getTopicTags());
        topicManagementService.saveTopics(topicInputDTO);

        QuestionEntity entity = questionManagementMapper.mapInputToEntity(inputDTO);
        entity.setId(UUID.randomUUID());
        entity.setUser(user);

        TopicEntity topicEntity = topicManagementRepository.fetchIdByTopicTag(inputDTO.getTopicTags());
        entity.setTopicTags(topicEntity);
        questionManagementRepository.save(entity);
        return questionManagementMapper.mapEntityToOutput(entity);
    }


    public List<QuestionEntity> searchQuestion(QuestionInputDTO inputDTO) {
        QuestionEntity entity = new QuestionEntity();
        entity.setTitle(inputDTO.getTitle());

        //TODO -> fix bug here
        entity.getTopicTags().setTopics(inputDTO.getTopicTags());
        return questionManagementRepository.findAll();
    }

    // TODO -> Implement all questions by user
}
