package com.quora.service.client;

import com.quora.entity.FollowEntity;
import com.quora.entity.UserEntity;
import com.quora.repository.FollowManagementRepository;
import com.quora.repository.UserManagementRepository;
import com.quora.service.models.request.FollowInputDTO;
import com.quora.service.models.response.FollowOutputDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FollowManagementClient {
    private final UserManagementRepository userManagementRepository;
    private final FollowManagementRepository followManagementRepository;

    private FollowManagementClient(
            UserManagementRepository userManagementRepository,
            FollowManagementRepository followManagementRepository
    ) {
        this.userManagementRepository = userManagementRepository;
        this.followManagementRepository = followManagementRepository;
    }

    public FollowOutputDTO follow(FollowInputDTO inputDTO) {
        UserEntity follower = userManagementRepository.findByUsername(inputDTO.getFollower());
        UserEntity following = userManagementRepository.findByUsername(inputDTO.getFollowing());

        FollowEntity entity = new FollowEntity();
        entity.setFollowing(following);
        entity.setFollower(follower);
        entity.setId(UUID.randomUUID());
        followManagementRepository.save(entity);

        FollowOutputDTO outputDTO = new FollowOutputDTO();
        outputDTO.setResponse("User Followed!!");
        return outputDTO;
    }
}
