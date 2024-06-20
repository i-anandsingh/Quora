package com.quora.mapper;

import com.quora.apimodels.request.TopicRequestDTO;
import com.quora.entity.TopicEntity;
import com.quora.service.models.request.TopicInputDTO;
import com.quora.service.models.response.TopicOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface TopicManagementMapper {
    TopicManagementMapper INSTANCE = Mappers.getMapper(TopicManagementMapper.class);
    TopicInputDTO mapRequestToInput(TopicRequestDTO requestDTO);
    TopicOutputDTO mapEntityToOutput(TopicEntity entity);
}
