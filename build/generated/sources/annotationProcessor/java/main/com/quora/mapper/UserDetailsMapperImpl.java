package com.quora.mapper;

import com.quora.apimodels.request.UserDetailsRequestDTO;
import com.quora.entity.UserEntity;
import com.quora.service.models.request.UserDetailsInputDTO;
import com.quora.service.models.response.UserDetailsOutputDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-20T17:49:43+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
public class UserDetailsMapperImpl implements UserDetailsMapper {

    @Override
    public UserDetailsInputDTO mapRequestToInput(UserDetailsRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        UserDetailsInputDTO.UserDetailsInputDTOBuilder userDetailsInputDTO = UserDetailsInputDTO.builder();

        userDetailsInputDTO.username( requestDTO.getUsername() );
        userDetailsInputDTO.emailId( requestDTO.getEmailId() );
        userDetailsInputDTO.bio( requestDTO.getBio() );

        return userDetailsInputDTO.build();
    }

    @Override
    public UserEntity mapInputToEntity(UserDetailsInputDTO inputDTO) {
        if ( inputDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername( inputDTO.getUsername() );
        userEntity.setEmailId( inputDTO.getEmailId() );
        userEntity.setBio( inputDTO.getBio() );

        return userEntity;
    }

    @Override
    public UserDetailsOutputDTO mapEntityToOutput(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserDetailsOutputDTO.UserDetailsOutputDTOBuilder userDetailsOutputDTO = UserDetailsOutputDTO.builder();

        userDetailsOutputDTO.userId( entity.getUserId() );
        userDetailsOutputDTO.username( entity.getUsername() );
        userDetailsOutputDTO.emailId( entity.getEmailId() );
        userDetailsOutputDTO.bio( entity.getBio() );

        return userDetailsOutputDTO.build();
    }
}
