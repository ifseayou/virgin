package com.isea.clitoris.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author isea_you
 * @date 2019/11/4
 * @time 8:22
 * @target: 看看Executor 是怎么玩的
 */
class ExecutorCase {
    public static void main(String[] args) {
        // 创建一个任务执行工具
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(()->{
            for (int i = 0;i < 10 ; i ++) System.out.print(i + " ");
        });

        // 用完之后必须停止，否则虚拟机不会退出
        exec.shutdown();
    }
}
