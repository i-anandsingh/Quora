package com.quora.service.client;

import com.quora.entity.Like;
import com.quora.entity.LikeEntity;
import com.quora.entity.UserEntity;
import com.quora.exceptionHandler.CustomException;
import com.quora.repository.LikeManagementRepository;
import com.quora.repository.UserManagementRepository;
import com.quora.service.models.request.LikeInputDTO;
import com.quora.service.models.response.LikeOutputDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LikeManagementClient {
    private final LikeManagementRepository likeManagementRepository;
    private final UserManagementRepository userManagementRepository;


    private LikeManagementClient(
            LikeManagementRepository likeManagementRepository,
            UserManagementRepository userManagementRepository
    ){
        this.likeManagementRepository = likeManagementRepository;
        this.userManagementRepository = userManagementRepository;
    }

    public LikeOutputDTO doLike(LikeInputDTO inputDTO) {
        String type = inputDTO.getType();
        UUID id = inputDTO.getId();
        if(type == null || id == null){
            throw new CustomException("Invalid like type or item ID provided.");
        }
        UserEntity entity = userManagementRepository.findByUsername(inputDTO.getUsername());
        if(entity == null){
            throw new CustomException("No User Exists.");
        }
        Like likeType = Like.valueOf(type.toUpperCase());
        LikeEntity likeEntity = new LikeEntity();
        likeEntity.setId(UUID.randomUUID());
        likeEntity.setType(likeType);
        likeEntity.setUser(entity);

        likeManagementRepository.save(likeEntity);

        LikeOutputDTO outputDTO = new LikeOutputDTO();
        outputDTO.setId(inputDTO.getId());
        outputDTO.setType(inputDTO.getType());
        outputDTO.setResponse("Liked Successfully!!");

        return outputDTO;
    }
}
