package com.yoo.common.rabbitmq.service;

import com.yoo.common.rabbitmq.constant.Constants;
import com.yoo.common.rabbitmq.entity.BrokerMessageLog;
import com.yoo.common.rabbitmq.entity.Order;
import com.yoo.common.rabbitmq.mapper.BrokerMessageLogMapper;
import com.yoo.common.rabbitmq.mapper.OrderMapper;
import com.yoo.common.rabbitmq.producer.RabbitOrderSender;
import com.yoo.common.rabbitmq.utils.DateUtils;
import com.yoo.common.rabbitmq.utils.FastJsonConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private BrokerMessageLogMapper brokerMessageLogMapper;

    @Autowired
    private RabbitOrderSender rabbitOrderSender;

    public void createOrder(Order order) throws Exception {
        // 使用当前时间当做订单创建时间（为了模拟一下简化）
        Date orderTime = new Date();
        // 插入业务数据
        orderMapper.insert(order);
        // 插入消息记录表数据
        BrokerMessageLog brokerMessageLog = new BrokerMessageLog();
        // 消息唯一ID
        brokerMessageLog.setMessageId(order.getMessageId());
        // 保存消息整体 转为JSON 格式存储入库
        brokerMessageLog.setMessage(FastJsonConvertUtil.convertObjectToJSON(order));
        // 设置消息状态为0 表示发送中
        brokerMessageLog.setStatus("0");
        // 设置消息未确认超时时间窗口为 一分钟
        brokerMessageLog.setNextRetry(DateUtils.addMinutes(orderTime, Constants.ORDER_TIMEOUT));
        brokerMessageLog.setCreateTime(new Date());
        brokerMessageLog.setUpdateTime(new Date());
        brokerMessageLogMapper.insertSelective(brokerMessageLog);
        // 发送消息
        rabbitOrderSender.sendOrder(order);
    }

}

