package com.quora.mapper;

import com.quora.apimodels.request.AnswerRequestDTO;
import com.quora.apimodels.response.AnswerResponseDTO;
import com.quora.entity.AnswerEntity;
import com.quora.service.models.request.AnswerInputDTO;
import com.quora.service.models.response.AnswerOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, unmappedSourcePolicy = ReportingPolicy.WARN)
public interface AnswerManagementMapper {
    AnswerManagementMapper INSTANCE = Mappers.getMapper(AnswerManagementMapper.class);
    AnswerInputDTO mapRequestToInputDTO(AnswerRequestDTO requestDTO);
    AnswerEntity mapInputToEntity(AnswerInputDTO inputDTO);

    @Mapping(source = "entity.id", target = "answerId")
    AnswerOutputDTO mapEntityToOutput(AnswerEntity entity);
    AnswerResponseDTO mapOutputToResponse(AnswerOutputDTO outputDTO);
}
