package com.montnets.sync.tmpl.scheduling;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import com.montnets.sync.tmpl.config.SyncTmplConfig;
import com.montnets.sync.tmpl.service.PushTmplTask;
import com.montnets.sync.tmpl.service.impl.PushTmplImpl;
 
/**
 * 上报模板到第三方运营商服务
 *
 */
@Configuration
@EnableScheduling
public class PushTmplService implements SchedulingConfigurer {
 
    //private static Logger log = LoggerFactory.getLogger(PushTmplService.class);
    
    @Autowired
    private SyncTmplConfig syncTmplConfig;
    
    @Autowired
    private PushTmplTask pushTmplTask;
    
    @Autowired
    private PushTmplImpl pushTmplImpl;
 
 
    
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
            	pushTmplTask.setPushTmplService(pushTmplImpl);
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