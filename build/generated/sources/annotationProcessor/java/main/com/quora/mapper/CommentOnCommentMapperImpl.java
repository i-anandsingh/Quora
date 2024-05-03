package com.quora.mapper;

import com.quora.apimodels.request.CommentOnCommentRequestDTO;
import com.quora.apimodels.response.CommentOnCommentResponseDTO;
import com.quora.entity.CommentEntity;
import com.quora.service.models.request.CommentOnCommentInputDTO;
import com.quora.service.models.response.CommentOnCommentOutputDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-04T00:20:56+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
public class CommentOnCommentMapperImpl implements CommentOnCommentMapper {

    @Override
    public CommentOnCommentInputDTO mapRequestToInput(CommentOnCommentRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        CommentOnCommentInputDTO.CommentOnCommentInputDTOBuilder commentOnCommentInputDTO = CommentOnCommentInputDTO.builder();

        commentOnCommentInputDTO.userId( requestDTO.getUserId() );
        commentOnCommentInputDTO.comment( requestDTO.getComment() );

        return commentOnCommentInputDTO.build();
    }

    @Override
    public CommentEntity mapInputToEntity(CommentOnCommentInputDTO inputDTO) {
        if ( inputDTO == null ) {
            return null;
        }

        CommentEntity commentEntity = new CommentEntity();

        commentEntity.setCommentId( inputDTO.getCommentId() );
        commentEntity.setComment( inputDTO.getComment() );

        return commentEntity;
    }

    @Override
    public CommentOnCommentOutputDTO mapEntityToOutput(CommentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CommentOnCommentOutputDTO.CommentOnCommentOutputDTOBuilder commentOnCommentOutputDTO = CommentOnCommentOutputDTO.builder();

        commentOnCommentOutputDTO.commentId( entity.getCommentId() );
        commentOnCommentOutputDTO.comment( entity.getComment() );

        return commentOnCommentOutputDTO.build();
    }

    @Override
    public CommentOnCommentResponseDTO mapOutputToResponse(CommentOnCommentOutputDTO outputDTO) {
        if ( outputDTO == null ) {
            return null;
        }

        CommentOnCommentResponseDTO.CommentOnCommentResponseDTOBuilder commentOnCommentResponseDTO = CommentOnCommentResponseDTO.builder();

        commentOnCommentResponseDTO.commentId( outputDTO.getCommentId() );
        commentOnCommentResponseDTO.comment( outputDTO.getComment() );

        return commentOnCommentResponseDTO.build();
    }
}
