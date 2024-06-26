package com.quora.mapper;

import com.quora.apimodels.request.CommentRequestDTO;
import com.quora.entity.CommentEntity;
import com.quora.service.models.request.CommentInputDTO;
import com.quora.service.models.response.CommentOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, unmappedSourcePolicy = ReportingPolicy.WARN)
public interface CommentManagementMapper {
    CommentManagementMapper INSTANCE = Mappers.getMapper(CommentManagementMapper.class);
    CommentInputDTO mapRequestToInput(CommentRequestDTO requestDTO);
    CommentEntity mapInputToEntity(CommentInputDTO inputDTO);

    @Mapping(source = "entity.id", target = "commentId")
    CommentOutputDTO mapEntityToOutput(CommentEntity entity);
}
