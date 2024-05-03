package com.quora.mapper;

import com.quora.apimodels.request.AnswerRequestDTO;
import com.quora.apimodels.response.AnswerResponseDTO;
import com.quora.entity.AnswerEntity;
import com.quora.service.models.request.AnswerInputDTO;
import com.quora.service.models.response.AnswerOutputDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-04T00:20:56+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
public class AnswerManagementMapperImpl implements AnswerManagementMapper {

    @Override
    public AnswerInputDTO mapRequestToInputDTO(AnswerRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        AnswerInputDTO.AnswerInputDTOBuilder answerInputDTO = AnswerInputDTO.builder();

        answerInputDTO.userId( requestDTO.getUserId() );
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
    public AnswerOutputDTO mapEntityToOutput(AnswerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AnswerOutputDTO.AnswerOutputDTOBuilder answerOutputDTO = AnswerOutputDTO.builder();

        answerOutputDTO.answerId( entity.getAnswerId() );
        answerOutputDTO.answer( entity.getAnswer() );

        return answerOutputDTO.build();
    }

    @Override
    public AnswerResponseDTO mapOutputToResponse(AnswerOutputDTO outputDTO) {
        if ( outputDTO == null ) {
            return null;
        }

        AnswerResponseDTO.AnswerResponseDTOBuilder answerResponseDTO = AnswerResponseDTO.builder();

        answerResponseDTO.answerId( outputDTO.getAnswerId() );
        answerResponseDTO.answer( outputDTO.getAnswer() );

        return answerResponseDTO.build();
    }
}
