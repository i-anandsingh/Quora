package com.quora.mapper;

import com.quora.apimodels.request.UserDetailsRequestDTO;
import com.quora.entity.UserEntity;
import com.quora.service.models.request.UserDetailsInputDTO;
import com.quora.service.models.response.UserDetailsOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserDetailsMapper {
    UserDetailsMapper INSTANCE = Mappers.getMapper(UserDetailsMapper.class);
    UserDetailsInputDTO mapRequestToInput(UserDetailsRequestDTO requestDTO);
    UserEntity mapInputToEntity(UserDetailsInputDTO inputDTO);
    @Mapping(source = "entity.id", target = "userId")
    UserDetailsOutputDTO mapEntityToOutput(UserEntity entity);
}
