package com.ro.panel.services.aws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.services.ssm.SsmClient;

@Component
public class ClientManager {
    @Value("${aws.profile.name}")
    private String awsProfile;

    public SsmClient getClientManager(){
        return SsmClient.builder()
                .credentialsProvider(ProfileCredentialsProvider.create(awsProfile))
                .build();
    }
}
