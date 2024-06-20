package com.quora.mapper;

import com.quora.apimodels.request.CommentRequestDTO;
import com.quora.apimodels.response.CommentResponseDTO;
import com.quora.entity.CommentEntity;
import com.quora.service.models.request.CommentInputDTO;
import com.quora.service.models.response.CommentOutputDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-20T17:49:43+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
public class CommentManagementMapperImpl implements CommentManagementMapper {

    @Override
    public CommentInputDTO mapRequestToInput(CommentRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        CommentInputDTO.CommentInputDTOBuilder commentInputDTO = CommentInputDTO.builder();

        commentInputDTO.userId( requestDTO.getUserId() );
        commentInputDTO.comment( requestDTO.getComment() );

        return commentInputDTO.build();
    }

    @Override
    public CommentEntity mapInputToEntity(CommentInputDTO inputDTO) {
        if ( inputDTO == null ) {
            return null;
        }

        CommentEntity commentEntity = new CommentEntity();

        commentEntity.setComment( inputDTO.getComment() );

        return commentEntity;
    }

    @Override
    public CommentOutputDTO mapEntityToOutput(CommentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CommentOutputDTO.CommentOutputDTOBuilder commentOutputDTO = CommentOutputDTO.builder();

        commentOutputDTO.commentId( entity.getCommentId() );
        commentOutputDTO.comment( entity.getComment() );

        return commentOutputDTO.build();
    }

    @Override
    public CommentResponseDTO mapOutputToResponse(CommentOutputDTO outputDTO) {
        if ( outputDTO == null ) {
            return null;
        }

        CommentResponseDTO.CommentResponseDTOBuilder commentResponseDTO = CommentResponseDTO.builder();

        commentResponseDTO.answerId( outputDTO.getAnswerId() );
        commentResponseDTO.commentId( outputDTO.getCommentId() );
        commentResponseDTO.comment( outputDTO.getComment() );

        return commentResponseDTO.build();
    }
}
