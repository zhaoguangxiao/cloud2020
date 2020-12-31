package com.atguigu.snowflake.write;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class IdGeneratorSnowFlake {

    //0-31
    private long workerld = 0;
    private long datacenterId = 1;


    private Snowflake snowflake = IdUtil.createSnowflake(workerld, datacenterId);

    //方法构造成执行---加载初始化工作
    @PostConstruct
    public void init() {
        try {
            workerld = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workerld = " + workerld);
        } catch (Exception e) {
            log.info("当前机器的workerld 获取失败" + e.getMessage());
            //获取字符串
            workerld = NetUtil.getLocalhostStr().hashCode();
        }
    }


    public synchronized long snowflake() {
        return snowflake.nextId();
    }


    public synchronized long snowflake(long workerId, long datacenterId) {
        return IdUtil.createSnowflake(workerId, datacenterId).nextId();
    }


}
