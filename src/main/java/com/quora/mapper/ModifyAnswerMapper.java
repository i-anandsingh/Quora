package com.quora.mapper;

import com.quora.apimodels.request.ModifyAnswerRequestDTO;
import com.quora.apimodels.response.ModifyAnswerResponseDTO;
import com.quora.entity.AnswerEntity;
import com.quora.service.models.request.ModifyAnswerInputDTO;
import com.quora.service.models.response.ModifyAnswerOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ModifyAnswerMapper {
    ModifyAnswerMapper INSTANCE = Mappers.getMapper(ModifyAnswerMapper.class);
    ModifyAnswerInputDTO mapRequestToInput(ModifyAnswerRequestDTO requestDTO);
    AnswerEntity mapInputToEntity(ModifyAnswerInputDTO inputDTO);
    ModifyAnswerOutputDTO mapEntityToOutput(AnswerEntity entity);
    ModifyAnswerResponseDTO mapOutputToResponse(ModifyAnswerOutputDTO outputDTO);
}
