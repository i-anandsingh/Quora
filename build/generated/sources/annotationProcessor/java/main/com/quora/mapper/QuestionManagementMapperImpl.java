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
    date = "2024-05-03T02:40:16+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
public class QuestionManagementMapperImpl implements QuestionManagementMapper {

    @Override
    public QuestionEntity mapInputToEntity(QuestionInputDTO inputDTO) {
        if ( inputDTO == null ) {
            return null;
        }

        QuestionEntity questionEntity = new QuestionEntity();

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

        questionResponseDTO.questionId( outputDTO.getQuestionId() );
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

        questionInputDTO.user_Id( requestDTO.getUser_Id() );
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

        questionOutputDTO.questionId( entity.getQuestionId() );
        questionOutputDTO.title( entity.getTitle() );
        questionOutputDTO.body( entity.getBody() );
        List<String> list = entity.getTopicTags();
        if ( list != null ) {
            questionOutputDTO.topicTags( new ArrayList<String>( list ) );
        }

        return questionOutputDTO.build();
    }

    @Override
    public List<QuestionOutputDTO> mapEntityToOutputList(List<QuestionEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<QuestionOutputDTO> list = new ArrayList<QuestionOutputDTO>( entityList.size() );
        for ( QuestionEntity questionEntity : entityList ) {
            list.add( mapEntityToOutput( questionEntity ) );
        }

        return list;
    }

    @Override
    public List<QuestionResponseDTO> mapOutputToResponseList(List<QuestionOutputDTO> outputDTOList) {
        if ( outputDTOList == null ) {
            return null;
        }

        List<QuestionResponseDTO> list = new ArrayList<QuestionResponseDTO>( outputDTOList.size() );
        for ( QuestionOutputDTO questionOutputDTO : outputDTOList ) {
            list.add( mapOutputToResponse( questionOutputDTO ) );
        }

        return list;
    }
}
