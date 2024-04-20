package com.quora.mapper;

import com.quora.apimodels.request.QuestionRequestDTO;
import com.quora.apimodels.response.QuestionResponseDTO;
import com.quora.entity.QuestionEntity;
import com.quora.service.models.request.QuestionInputDTO;
import com.quora.service.models.response.QuestionOutputDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-20T09:19:20+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
public class QuestionManagementMapperImpl implements QuestionManagementMapper {

    @Override
    public QuestionEntity mapInputToEntity(QuestionInputDTO inputDTO) {
        if ( inputDTO == null ) {
            return null;
        }

        QuestionEntity questionEntity = new QuestionEntity();

        questionEntity.setUserId( inputDTO.getUserId() );
        questionEntity.setTitle( inputDTO.getTitle() );
        questionEntity.setBody( inputDTO.getBody() );
        List<String> list = inputDTO.getTopicTags();
        if ( list != null ) {
            questionEntity.setTopicTags( new ArrayList<String>( list ) );
        }

        return questionEntity;
    }

    @Override
    public QuestionResponseDTO mapOutputToResponse(QuestionOutputDTO outputDTO) {
        if ( outputDTO == null ) {
            return null;
        }

        QuestionResponseDTO.QuestionResponseDTOBuilder questionResponseDTO = QuestionResponseDTO.builder();

        questionResponseDTO.userId( outputDTO.getUserId() );
        questionResponseDTO.title( outputDTO.getTitle() );
        questionResponseDTO.body( outputDTO.getBody() );
        List<String> list = outputDTO.getTopicTags();
        if ( list != null ) {
            questionResponseDTO.topicTags( new ArrayList<String>( list ) );
        }

        return questionResponseDTO.build();
    }

    @Override
    public QuestionInputDTO mapRequestToInput(QuestionRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        QuestionInputDTO.QuestionInputDTOBuilder questionInputDTO = QuestionInputDTO.builder();

        questionInputDTO.userId( requestDTO.getUserId() );
        questionInputDTO.title( requestDTO.getTitle() );
        questionInputDTO.body( requestDTO.getBody() );
        List<String> list = requestDTO.getTopicTags();
        if ( list != null ) {
            questionInputDTO.topicTags( new ArrayList<String>( list ) );
        }

        return questionInputDTO.build();
    }

    @Override
    public QuestionOutputDTO mapEntityToOutput(QuestionEntity entity) {
        if ( entity == null ) {
            return null;
        }

        QuestionOutputDTO.QuestionOutputDTOBuilder questionOutputDTO = QuestionOutputDTO.builder();

        questionOutputDTO.userId( entity.getUserId() );
        questionOutputDTO.title( entity.getTitle() );
        questionOutputDTO.body( entity.getBody() );
        List<String> list = entity.getTopicTags();
        if ( list != null ) {
            questionOutputDTO.topicTags( new ArrayList<String>( list ) );
        }

        return questionOutputDTO.build();
    }
}
