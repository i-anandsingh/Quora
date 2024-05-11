package com.quora.service.client.impl;

import com.quora.entity.FollowEntity;
import com.quora.entity.UserEntity;
import com.quora.mapper.FollowManagementMapper;
import com.quora.repository.FollowManagementRepository;
import com.quora.repository.UserManagementRepository;
import com.quora.service.client.FollowManagementClient;
import com.quora.service.models.request.FollowInputDTO;
import com.quora.service.models.response.FollowOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FollowManagementClientImpl implements FollowManagementClient {
    private final UserManagementRepository userManagementRepository;
    private final FollowManagementRepository followManagementRepository;
    private final FollowManagementMapper followManagementMapper = FollowManagementMapper.INSTANCE;

    @Autowired
    private FollowManagementClientImpl(
            UserManagementRepository userManagementRepository,
            FollowManagementRepository followManagementRepository
    ) {
        this.userManagementRepository = userManagementRepository;
        this.followManagementRepository = followManagementRepository;
    }
    @Override
    public FollowOutputDTO follow(FollowInputDTO inputDTO) {
        UserEntity follower = userManagementRepository.findByUserId(inputDTO.getFollower());
        UserEntity following = userManagementRepository.findByUserId(inputDTO.getFollowing());

        FollowEntity entity = new FollowEntity();
        entity.setFollowing(following);
        entity.setFollower(follower);
        entity.setId(UUID.randomUUID());
        followManagementRepository.save(entity);

        FollowOutputDTO outputDTO = new FollowOutputDTO();
        outputDTO.setFollower(follower.getUserId());
        outputDTO.setFollowing(following.getUserId());
        outputDTO.setResponse("User Followed!!");
        return outputDTO;
    }
}
