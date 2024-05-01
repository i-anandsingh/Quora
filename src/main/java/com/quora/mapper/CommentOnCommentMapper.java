package com.quora.mapper;

import com.quora.apimodels.request.CommentOnCommentRequestDTO;
import com.quora.apimodels.response.CommentOnCommentResponseDTO;
import com.quora.entity.CommentEntity;
import com.quora.service.models.request.CommentOnCommentInputDTO;
import com.quora.service.models.response.CommentOnCommentOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CommentOnCommentMapper {
    CommentOnCommentMapper INSTANCE = Mappers.getMapper(CommentOnCommentMapper.class);
    CommentOnCommentInputDTO mapRequestToInput(CommentOnCommentRequestDTO requestDTO);
    CommentEntity mapInputToEntity(CommentOnCommentInputDTO inputDTO);
    CommentOnCommentOutputDTO mapEntityToOutput(CommentEntity entity);
    CommentOnCommentResponseDTO mapOutputToResponse(CommentOnCommentOutputDTO outputDTO);
}
