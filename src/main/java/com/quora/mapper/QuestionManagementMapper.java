package com.quora.mapper;

import com.quora.apimodels.request.QuestionRequestDTO;
import com.quora.apimodels.response.QuestionResponseDTO;
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
    QuestionEntity mapInputToEntity(QuestionInputDTO inputDTO);
    QuestionResponseDTO mapOutputToResponse(QuestionOutputDTO outputDTO);
    @Mapping(source = "user_Id", target = "id")
    QuestionInputDTO mapRequestToInput(QuestionRequestDTO requestDTO);
    QuestionOutputDTO mapEntityToOutput(QuestionEntity entity);
    List<QuestionOutputDTO> mapEntityToOutputList(List<QuestionEntity> entityList);
    List<QuestionResponseDTO> mapOutputToResponseList(List<QuestionOutputDTO> outputDTOList);
}
