package com.yoo.common.rabbitmq.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/**
 * @author anYoooo
 * @date 2022/06/06
 * 路由配置信息
 */
@Component
@Configuration
public class NacosConfiguration {

    public static final long DEFAULT_TIMEOUT = 30000;

    public static String SERVER_ADDR;

    public static String NAMESPACE;

    public static String USERNAME;

    public static String PASSWORD;
    @Value("${spring.cloud.nacos.discovery.server-addr}")
    public void setServerAddr(String serverAddr) {
        SERVER_ADDR = serverAddr;
    }
    @Value("${spring.cloud.nacos.discovery.namespace}")
    public void setNamespace(String namespace) {
        NAMESPACE = namespace;
    }
    @Value("${spring.cloud.nacos.discovery.username}")
    public void setUsername(String username) {
        USERNAME = username;
    }
    @Value("${spring.cloud.nacos.discovery.password}")
    public void setPassword(String password) {
        PASSWORD = password;
    }


    NacosConfiguration(){
        System.out.println("``````````````````````````````````````````````````````````````");
        System.out.println("``````````````````````````````````````````````````````````````");
        System.out.println(SERVER_ADDR);
        System.out.println("``````````````````````````````````````````````````````````````");
        System.out.println("``````````````````````````````````````````````````````````````");
    }

}
