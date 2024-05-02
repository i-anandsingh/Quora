package com.quora.mapper;

import com.quora.apimodels.request.ModifyAnswerRequestDTO;
import com.quora.apimodels.response.ModifyAnswerResponseDTO;
import com.quora.entity.AnswerEntity;
import com.quora.service.models.request.ModifyAnswerInputDTO;
import com.quora.service.models.response.ModifyAnswerOutputDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T02:40:16+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
public class ModifyAnswerMapperImpl implements ModifyAnswerMapper {

    @Override
    public ModifyAnswerInputDTO mapRequestToInput(ModifyAnswerRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        ModifyAnswerInputDTO.ModifyAnswerInputDTOBuilder modifyAnswerInputDTO = ModifyAnswerInputDTO.builder();

        modifyAnswerInputDTO.answer( requestDTO.getAnswer() );

        return modifyAnswerInputDTO.build();
    }

    @Override
    public AnswerEntity mapInputToEntity(ModifyAnswerInputDTO inputDTO) {
        if ( inputDTO == null ) {
            return null;
        }

        AnswerEntity answerEntity = new AnswerEntity();

        answerEntity.setAnswerId( inputDTO.getAnswerId() );
        answerEntity.setAnswer( inputDTO.getAnswer() );

        return answerEntity;
    }

    @Override
    public ModifyAnswerOutputDTO mapEntityToOutput(AnswerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ModifyAnswerOutputDTO.ModifyAnswerOutputDTOBuilder modifyAnswerOutputDTO = ModifyAnswerOutputDTO.builder();

        modifyAnswerOutputDTO.answerId( entity.getAnswerId() );
        modifyAnswerOutputDTO.answer( entity.getAnswer() );

        return modifyAnswerOutputDTO.build();
    }

    @Override
    public ModifyAnswerResponseDTO mapOutputToResponse(ModifyAnswerOutputDTO outputDTO) {
        if ( outputDTO == null ) {
            return null;
        }

        ModifyAnswerResponseDTO.ModifyAnswerResponseDTOBuilder modifyAnswerResponseDTO = ModifyAnswerResponseDTO.builder();

        modifyAnswerResponseDTO.answerId( outputDTO.getAnswerId() );
        modifyAnswerResponseDTO.answer( outputDTO.getAnswer() );

        return modifyAnswerResponseDTO.build();
    }
}
