package com.quora.mapper;

import com.quora.apimodels.response.FollowResponseDTO;
import com.quora.service.models.response.FollowOutputDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-20T17:49:42+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
public class FollowManagementMapperImpl implements FollowManagementMapper {

    @Override
    public FollowResponseDTO mapOutputToResponse(FollowOutputDTO outputDTO) {
        if ( outputDTO == null ) {
            return null;
        }

        FollowResponseDTO.FollowResponseDTOBuilder followResponseDTO = FollowResponseDTO.builder();

        followResponseDTO.follower( outputDTO.getFollower() );
        followResponseDTO.following( outputDTO.getFollowing() );
        followResponseDTO.response( outputDTO.getResponse() );

        return followResponseDTO.build();
    }
}
