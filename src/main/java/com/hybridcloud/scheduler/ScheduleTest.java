package com.hybridcloud.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleTest
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
     * 定时器测试，20秒执行一次
     */
    @Scheduled(cron = "0/20 * * * * ?")
    public void scheduler()
    {
        logger.info("==================ScheduleTest 20 seconds==================");
    }
}
