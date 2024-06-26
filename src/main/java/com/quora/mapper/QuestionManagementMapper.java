package com.quora.mapper;

import com.quora.apimodels.request.QuestionRequestDTO;
import com.quora.entity.QuestionEntity;
import com.quora.entity.TopicEntity;
import com.quora.service.models.request.QuestionInputDTO;
import com.quora.service.models.response.QuestionOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, unmappedSourcePolicy = ReportingPolicy.WARN)
public interface QuestionManagementMapper {

    QuestionManagementMapper INSTANCE = Mappers.getMapper(QuestionManagementMapper.class);

    default QuestionEntity mapInputToEntity(QuestionInputDTO inputDTO) {
        QuestionEntity entity = new QuestionEntity();
        entity.setTitle(inputDTO.getTitle());
        entity.setBody(inputDTO.getBody());
        // Topic tags are set separately in the postQuestion method
        return entity;
    }

    QuestionInputDTO mapRequestToInput(QuestionRequestDTO requestDTO);

    default QuestionOutputDTO mapEntityToOutput(QuestionEntity entity) {
        return QuestionOutputDTO.builder()
                .questionId(entity.getId())
                .title(entity.getTitle())
                .body(entity.getBody())
                .topicTags(entity.getTopicTags().stream()
                        .map(TopicEntity::getTopics)
                        .collect(toList()))
                .build();
    }

    List<QuestionOutputDTO> mapEntityListToOutputList(List<QuestionEntity> entities);

}
