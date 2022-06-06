package com.yoo.gateway.handler;

import com.yoo.core.exception.base.BaseMap;
import com.yoo.core.listener.JeecgRedisListerer;
import com.yoo.gateway.loader.DynamicRouteLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 路由刷新监听
 */
@Slf4j
@Component
public class LoderRouderHandler implements JeecgRedisListerer {

    @Resource
    private DynamicRouteLoader dynamicRouteLoader;


    @Override
    public void onMessage(BaseMap message) {
        dynamicRouteLoader.refresh(message);
    }

}