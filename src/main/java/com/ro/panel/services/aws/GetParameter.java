package com.ro.panel.services.aws;

import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;
import software.amazon.awssdk.services.ssm.model.SsmException;

public class GetParameter {
    public static String getParaValue(SsmClient ssmClient, String paraName) {
        GetParameterResponse parameterResponse = null;
        try {
            GetParameterRequest parameterRequest = GetParameterRequest.builder()
                    .name(paraName)
                    .build();
            parameterResponse = ssmClient.getParameter(parameterRequest);
        } catch (SsmException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return parameterResponse.parameter().value();
    }
}
