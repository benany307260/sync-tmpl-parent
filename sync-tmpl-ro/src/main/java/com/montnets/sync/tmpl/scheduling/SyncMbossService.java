package com.montnets.sync.tmpl.scheduling;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import com.montnets.sync.tmpl.config.SyncTmplConfig;
import com.montnets.sync.tmpl.service.SyncMbossTask;
 
/**
 * 同步模板通道绑定到mboss定时服务
 *
 */
@Configuration
@EnableScheduling
public class SyncMbossService implements SchedulingConfigurer {
 
    //private static Logger log = LoggerFactory.getLogger(SyncMbossService.class);
    
    @Autowired
    private SyncTmplConfig syncTmplConfig;
    
    @Autowired
    private SyncMbossTask syncMbossTask;
 
 
    
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                // 任务逻辑
            	syncMbossTask.run();
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                String s = syncTmplConfig.getSyncMbossCron();
                // 任务触发，可修改任务的执行周期
                CronTrigger trigger = new CronTrigger(s);
                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
            }
        });
    }
}