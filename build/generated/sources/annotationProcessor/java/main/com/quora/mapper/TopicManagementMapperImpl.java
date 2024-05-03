package com.quora.mapper;

import com.quora.apimodels.request.TopicRequestDTO;
import com.quora.apimodels.response.TopicResponseDTO;
import com.quora.entity.TopicEntity;
import com.quora.service.models.request.TopicInputDTO;
import com.quora.service.models.response.TopicOutputDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-03T10:12:07+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
public class TopicManagementMapperImpl implements TopicManagementMapper {

    @Override
    public TopicInputDTO mapRequestToInput(TopicRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        TopicInputDTO.TopicInputDTOBuilder topicInputDTO = TopicInputDTO.builder();

        List<String> list = requestDTO.getTopics();
        if ( list != null ) {
            topicInputDTO.topics( new ArrayList<String>( list ) );
        }

        return topicInputDTO.build();
    }

    @Override
    public TopicOutputDTO mapEntityToOutput(TopicEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TopicOutputDTO.TopicOutputDTOBuilder topicOutputDTO = TopicOutputDTO.builder();

        List<String> list = entity.getTopics();
        if ( list != null ) {
            topicOutputDTO.topics( new ArrayList<String>( list ) );
        }
        topicOutputDTO.id( entity.getId() );

        return topicOutputDTO.build();
    }

    @Override
    public TopicResponseDTO mapOutputToResponse(TopicOutputDTO outputDTO) {
        if ( outputDTO == null ) {
            return null;
        }

        TopicResponseDTO.TopicResponseDTOBuilder topicResponseDTO = TopicResponseDTO.builder();

        topicResponseDTO.id( outputDTO.getId() );
        List<String> list = outputDTO.getTopics();
        if ( list != null ) {
            topicResponseDTO.topics( new ArrayList<String>( list ) );
        }

        return topicResponseDTO.build();
    }
}
