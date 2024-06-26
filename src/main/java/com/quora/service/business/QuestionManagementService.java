package com.quora.service.business;

import com.quora.mapper.QuestionManagementMapper;
import com.quora.service.client.QuestionManagementClient;
import com.quora.service.models.request.QuestionInputDTO;
import com.quora.service.models.response.QuestionOutputDTO;
import org.springframework.stereotype.Service;

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

//    public List<QuestionOutputDTO> searchQuestion(QuestionInputDTO inputDTO){
//        List<QuestionEntity> entityList = questionManagementClient.searchQuestion(inputDTO);
//        return filterQuestions(entityList, inputDTO);
//    }

//    private List<QuestionOutputDTO> filterQuestions(List<QuestionEntity> entityList, QuestionInputDTO inputDTO) {
//        List<QuestionOutputDTO> outputDTOList = new ArrayList<>();
//        if(inputDTO.getTitle() == null && inputDTO.getTopicTags() == null){
//            return questionManagementMapper.mapEntityToOutputList(entityList);
//        }
//        if(inputDTO.getTitle() != null) {
//            List<QuestionOutputDTO> outputDTOText = filterBasedOnTitle(entityList, inputDTO.getTitle());
//            outputDTOList.addAll(outputDTOText);
//        }
//        if(inputDTO.getTopicTags() != null) {
//            List<QuestionOutputDTO> outputDTOTag = filterBasedOnTags(entityList, inputDTO.getTopicTags());
//            outputDTOList.addAll(outputDTOTag);
//        }
//        return outputDTOList;
//    }

//    private List<QuestionOutputDTO> filterBasedOnTags(List<QuestionEntity> entityList, String topicTags) {
//        List<QuestionOutputDTO> outputDTOList = new ArrayList<>();
//        for(QuestionEntity questionEntity : entityList) {
//            if(topicTags.equals(questionEntity.getTopicTags())){
//                QuestionOutputDTO outputDTO = questionManagementMapper.mapEntityToOutput(questionEntity);
//                outputDTOList.add(outputDTO);
//            }
//        }
//        if(outputDTOList.isEmpty()){
//            throw new CustomException("No matching topic tags found");
//        }
//        return outputDTOList;
//    }

//    private List<QuestionOutputDTO> filterBasedOnTitle(List<QuestionEntity> entityList, String title) {
//        List<QuestionOutputDTO> outputDTOList = new ArrayList<>();
//        for(QuestionEntity questionEntity : entityList){
//            if(title.equals(questionEntity.getTitle())){
//                QuestionOutputDTO outputDTO = questionManagementMapper.mapEntityToOutput(questionEntity);
//                outputDTOList.add(outputDTO);
//            }
//        }
//        if(outputDTOList.isEmpty()) {
//            throw new CustomException("No question based on text exists!!!");
//        }
//        return outputDTOList;
//    }
}
