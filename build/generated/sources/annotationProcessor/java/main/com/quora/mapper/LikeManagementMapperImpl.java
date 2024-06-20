package com.quora.mapper;

import com.quora.apimodels.request.LikeRequestDTO;
import com.quora.apimodels.response.LikeResponseDTO;
import com.quora.service.models.request.LikeInputDTO;
import com.quora.service.models.response.LikeOutputDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-20T17:49:43+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
public class LikeManagementMapperImpl implements LikeManagementMapper {

    @Override
    public LikeInputDTO mapRequestToInput(LikeRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        LikeInputDTO.LikeInputDTOBuilder likeInputDTO = LikeInputDTO.builder();

        likeInputDTO.userId( requestDTO.getUserId() );

        return likeInputDTO.build();
    }

    @Override
    public LikeResponseDTO mapOutputToResponse(LikeOutputDTO outputDTO) {
        if ( outputDTO == null ) {
            return null;
        }

        LikeResponseDTO.LikeResponseDTOBuilder likeResponseDTO = LikeResponseDTO.builder();

        likeResponseDTO.type( outputDTO.getType() );
        likeResponseDTO.id( outputDTO.getId() );
        likeResponseDTO.response( outputDTO.getResponse() );

        return likeResponseDTO.build();
    }
}
