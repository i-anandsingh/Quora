package com.quora.mapper;

import com.quora.apimodels.request.QuestionRequestDTO;
import com.quora.entity.QuestionEntity;
import com.quora.service.models.request.QuestionInputDTO;
import com.quora.service.models.response.QuestionOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, unmappedSourcePolicy = ReportingPolicy.WARN)
public interface QuestionManagementMapper {

    QuestionManagementMapper INSTANCE = Mappers.getMapper(QuestionManagementMapper.class);

    @Mapping(source = "topicTags", target = "topicTags.topics")
    QuestionEntity mapInputToEntity(QuestionInputDTO inputDTO);

    QuestionInputDTO mapRequestToInput(QuestionRequestDTO requestDTO);

    @Mapping(source = "entity.id", target = "questionId")
    @Mapping(source = "topicTags.topics", target = "topicTags")
    QuestionOutputDTO mapEntityToOutput(QuestionEntity entity);

    List<QuestionOutputDTO> mapEntityToOutputList(List<QuestionEntity> entityList);
}
