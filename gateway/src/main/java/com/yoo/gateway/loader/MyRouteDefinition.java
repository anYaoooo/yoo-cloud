package com.yoo.gateway.loader;

import org.springframework.cloud.gateway.route.RouteDefinition;

/**
 * 自定义RouteDefinition
 * @author anYoooo
 */
public class MyRouteDefinition extends RouteDefinition {
    /**
     * 路由状态
     */
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
