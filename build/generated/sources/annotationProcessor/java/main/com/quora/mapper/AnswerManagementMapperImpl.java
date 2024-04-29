package com.quora.mapper;

import com.quora.apimodels.request.AnswerRequestDTO;
import com.quora.apimodels.response.AnswerResponseDTO;
import com.quora.entity.AnswerEntity;
import com.quora.service.models.request.AnswerInputDTO;
import com.quora.service.models.response.AnswerOutputDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-30T01:03:28+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
public class AnswerManagementMapperImpl implements AnswerManagementMapper {

    @Override
    public AnswerInputDTO mapRequestToInputDTO(AnswerRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        AnswerInputDTO.AnswerInputDTOBuilder answerInputDTO = AnswerInputDTO.builder();

        answerInputDTO.question_id( requestDTO.getQuestion_id() );
        answerInputDTO.answer( requestDTO.getAnswer() );

        return answerInputDTO.build();
    }

    @Override
    public AnswerEntity mapInputToEntity(AnswerInputDTO inputDTO) {
        if ( inputDTO == null ) {
            return null;
        }

        AnswerEntity answerEntity = new AnswerEntity();

        answerEntity.setAnswer( inputDTO.getAnswer() );

        return answerEntity;
    }

    @Override
    public AnswerOutputDTO mapOutputToEntity(AnswerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AnswerOutputDTO.AnswerOutputDTOBuilder answerOutputDTO = AnswerOutputDTO.builder();

        answerOutputDTO.answer_id( entity.getAnswer_id() );
        answerOutputDTO.user_id( entity.getUser_id() );
        answerOutputDTO.createdAt( entity.getCreatedAt() );

        return answerOutputDTO.build();
    }

    @Override
    public AnswerResponseDTO mapOutputToResponse(AnswerOutputDTO outputDTO) {
        if ( outputDTO == null ) {
            return null;
        }

        AnswerResponseDTO.AnswerResponseDTOBuilder answerResponseDTO = AnswerResponseDTO.builder();

        answerResponseDTO.answer_id( outputDTO.getAnswer_id() );
        answerResponseDTO.question_id( outputDTO.getQuestion_id() );
        answerResponseDTO.user_id( outputDTO.getUser_id() );
        answerResponseDTO.text( outputDTO.getText() );
        answerResponseDTO.createdAt( outputDTO.getCreatedAt() );

        return answerResponseDTO.build();
    }
}
