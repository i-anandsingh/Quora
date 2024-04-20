package com.quora.mapper;

import com.quora.apimodels.request.QuestionRequestDTO;
import com.quora.apimodels.response.QuestionResponseDTO;
import com.quora.entity.QuestionEntity;
import com.quora.service.models.request.QuestionInputDTO;
import com.quora.service.models.response.QuestionOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, unmappedSourcePolicy = ReportingPolicy.WARN)
public interface QuestionManagementMapper {
    QuestionManagementMapper INSTANCE = Mappers.getMapper(QuestionManagementMapper.class);
    QuestionEntity mapInputToEntity(QuestionInputDTO inputDTO);
    QuestionResponseDTO mapOutputToResponse(QuestionOutputDTO outputDTO);
    QuestionInputDTO mapRequestToInput(QuestionRequestDTO requestDTO);
    QuestionOutputDTO mapEntityToOutput(QuestionEntity entity);
}
