//package com.snomyc.sys.task;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SchedulerTask {
//	private int count=0;
//
//    @Scheduled(cron="*/6 * * * * ?")
//    private void process(){
//        System.out.println("this is scheduler task runing  "+(count++));
//    }
//    
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//
//    /**
//     * 
//    @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
//    @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
//    @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
//     * 方法说明:
//    
//     * 创立日期:2018年6月1日 下午5:38:02
//     * 创建人:yangcan
//    
//     */
//    @Scheduled(fixedRate = 6000)
//    public void reportCurrentTime() {
//        System.out.println("现在时间：" + dateFormat.format(new Date()));
//    }
//}
