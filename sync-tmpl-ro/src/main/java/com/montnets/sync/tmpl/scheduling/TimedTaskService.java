package com.montnets.sync.tmpl.scheduling;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import com.montnets.sync.tmpl.config.SyncTmplConfig;
import com.montnets.sync.tmpl.service.PushTmplTask;
 
 
@Lazy(false)
@Service
@EnableScheduling
public class TimedTaskService implements SchedulingConfigurer {
 
    private static Logger log = LoggerFactory.getLogger(TimedTaskService.class);
    
    @Autowired
    private SyncTmplConfig syncTmplConfig;
    
    @Autowired
    private PushTmplTask pushTmplTask;
 
 
    
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                // 任务逻辑
            	pushTmplTask.run();
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                String s = syncTmplConfig.getPushTpmlCron();
                // 任务触发，可修改任务的执行周期
                CronTrigger trigger = new CronTrigger(s);
                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
            }
        });
    }
}