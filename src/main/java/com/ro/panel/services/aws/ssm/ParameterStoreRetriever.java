package com.ro.panel.services.aws.ssm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;
import software.amazon.awssdk.services.ssm.model.SsmException;

@Component
public class ParameterStoreRetriever {
    private final SsmClient ssmClient;
    public ParameterStoreRetriever(@Value("${aws.profile.name}") String awsProfile) {
        this.ssmClient = SsmClient.builder()
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();
    }

    public String getParamValue(String paraName) {
        GetParameterResponse parameterResponse = null;
        try {
            GetParameterRequest parameterRequest = GetParameterRequest.builder()
                    .name(paraName)
                    .withDecryption(Boolean.TRUE)
                    .build();
            parameterResponse = this.ssmClient.getParameter(parameterRequest);
        } catch (SsmException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return parameterResponse.parameter().value();
    }
}
