package com.quora.mapper;

import com.quora.apimodels.request.LikeRequestDTO;
import com.quora.apimodels.response.LikeResponseDTO;
import com.quora.service.models.request.LikeInputDTO;
import com.quora.service.models.response.LikeOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, unmappedSourcePolicy = ReportingPolicy.WARN)
public interface LikeManagementMapper {
    LikeManagementMapper INSTANCE = Mappers.getMapper(LikeManagementMapper.class);
    LikeInputDTO mapRequestToInput(LikeRequestDTO requestDTO);
    LikeResponseDTO mapOutputToResponse(LikeOutputDTO outputDTO);
}
