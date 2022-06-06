package com.yoo.core.listener;


import com.yoo.core.exception.base.BaseMap;

/**
 * 自定义消息监听
 */
public interface JeecgRedisListerer {

    void onMessage(BaseMap message);

}
