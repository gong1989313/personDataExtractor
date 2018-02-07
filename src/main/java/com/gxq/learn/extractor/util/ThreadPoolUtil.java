package com.gxq.learn.extractor.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

import org.apache.activemq.util.ThreadPoolUtils;

import com.gxq.learn.extractor.constant.SystemConstant;

public class ThreadPoolUtil {
	private static final ExecutorService executorService = Executors.newFixedThreadPool(SystemConstant.threadPoolSize);

	public static ExecutorService getExecutorService() {
		return executorService;
	}

	private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(2, new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			Thread thread = new Thread(r);
			thread.setDaemon(true);
			return thread;
		}
	});

	public static <V> Future<V> submitTask(Callable<V> callable) {
		return EXECUTOR_SERVICE.submit(callable);
	}

	public static Future<?> submitTask(Runnable runnable) {
		return EXECUTOR_SERVICE.submit(runnable);
	}

	public static void shutdownGraceful() {
		ThreadPoolUtils.shutdownGraceful(executorService);
	}
}
