package com.ro.panel.configs.db;

import com.ro.panel.services.aws.ClientManager;
import com.ro.panel.services.aws.GetParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.ssm.SsmClient;

@Component
public class DataSourceCredentials {
    private final ClientManager clientManager;

    @Autowired
    public DataSourceCredentials(ClientManager clientManager) {
        this.clientManager = clientManager;
    }
    public String dataSourceCredentials(String param){
        SsmClient ssmClient = clientManager.getClientManager();
        return GetParameter.getParaValue(ssmClient, param);
    }

}
