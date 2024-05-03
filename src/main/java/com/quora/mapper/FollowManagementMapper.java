package com.quora.mapper;

import com.quora.apimodels.response.FollowResponseDTO;
import com.quora.service.models.response.FollowOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, unmappedSourcePolicy = ReportingPolicy.WARN)
public interface FollowManagementMapper {
    FollowManagementMapper INSTANCE = Mappers.getMapper(FollowManagementMapper.class);
    FollowResponseDTO mapOutputToResponse(FollowOutputDTO outputDTO);
}
