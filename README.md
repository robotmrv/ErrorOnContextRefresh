1. start application 
2. try to refresh context  
`curl -v -X POST http://localhost:9999/actuator/refresh`

Expected result:  
response with http status 200 OK, and context is refreshed 

Actual Result:  
response with http status 500 Internal Server Error, and context is not refreshed  
and error in logs 
```text
2020-01-27 16:55:36.794 ERROR 11560 --- [      elastic-2] a.w.r.e.AbstractErrorWebExceptionHandler : [535b7877] 500 Server Error for HTTP POST "/actuator/refresh"

org.springframework.context.ApplicationContextException: Unable to start reactive web server; nested exception is org.springframework.context.ApplicationContextException: Unable to start ReactiveWebApplicationContext due to missing ReactiveWebServerFactory bean.
	at org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.onRefresh(ReactiveWebServerApplicationContext.java:81) ~[spring-boot-2.1.12.RELEASE.jar:2.1.12.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:543) ~[spring-context-5.1.13.RELEASE.jar:5.1.13.RELEASE]
	at org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.refresh(ReactiveWebServerApplicationContext.java:66) ~[spring-boot-2.1.12.RELEASE.jar:2.1.12.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:744) ~[spring-boot-2.1.12.RELEASE.jar:2.1.12.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:391) ~[spring-boot-2.1.12.RELEASE.jar:2.1.12.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:312) ~[spring-boot-2.1.12.RELEASE.jar:2.1.12.RELEASE]
	at org.springframework.boot.builder.SpringApplicationBuilder.run(SpringApplicationBuilder.java:140) ~[spring-boot-2.1.12.RELEASE.jar:2.1.12.RELEASE]
	at org.springframework.cloud.context.refresh.ContextRefresher.addConfigFilesToEnvironment(ContextRefresher.java:113) ~[spring-cloud-context-2.1.4.RELEASE.jar:2.1.4.RELEASE]
	at org.springframework.cloud.context.refresh.ContextRefresher.refreshEnvironment(ContextRefresher.java:93) ~[spring-cloud-context-2.1.4.RELEASE.jar:2.1.4.RELEASE]
	at org.springframework.cloud.context.refresh.ContextRefresher.refresh(ContextRefresher.java:85) ~[spring-cloud-context-2.1.4.RELEASE.jar:2.1.4.RELEASE]
	at org.springframework.cloud.endpoint.RefreshEndpoint.refresh(RefreshEndpoint.java:41) ~[spring-cloud-context-2.1.4.RELEASE.jar:2.1.4.RELEASE]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
	at org.springframework.util.ReflectionUtils.invokeMethod(ReflectionUtils.java:282) ~[spring-core-5.1.13.RELEASE.jar:5.1.13.RELEASE]
	at org.springframework.boot.actuate.endpoint.invoke.reflect.ReflectiveOperationInvoker.invoke(ReflectiveOperationInvoker.java:76) ~[spring-boot-actuator-2.1.12.RELEASE.jar:2.1.12.RELEASE]
	at org.springframework.boot.actuate.endpoint.annotation.AbstractDiscoveredOperation.invoke(AbstractDiscoveredOperation.java:60) ~[spring-boot-actuator-2.1.12.RELEASE.jar:2.1.12.RELEASE]
	at org.springframework.boot.actuate.endpoint.web.reactive.AbstractWebFluxEndpointHandlerMapping$ElasticSchedulerInvoker.invoke(AbstractWebFluxEndpointHandlerMapping.java:233) ~[spring-boot-actuator-2.1.12.RELEASE.jar:2.1.12.RELEASE]
	at org.springframework.boot.actuate.endpoint.web.reactive.AbstractWebFluxEndpointHandlerMapping$ElasticSchedulerInvoker.lambda$null$0(AbstractWebFluxEndpointHandlerMapping.java:228) ~[spring-boot-actuator-2.1.12.RELEASE.jar:2.1.12.RELEASE]
	at reactor.core.scheduler.ElasticScheduler$DirectScheduleTask.run(ElasticScheduler.java:292) ~[reactor-core-3.2.14.RELEASE.jar:3.2.14.RELEASE]
	at reactor.core.scheduler.SchedulerTask.call(SchedulerTask.java:50) ~[reactor-core-3.2.14.RELEASE.jar:3.2.14.RELEASE]
	at reactor.core.scheduler.SchedulerTask.call(SchedulerTask.java:27) ~[reactor-core-3.2.14.RELEASE.jar:3.2.14.RELEASE]
	at java.base/java.util.concurrent.FutureTask.run$$$capture(FutureTask.java:264) ~[na:na]
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java) ~[na:na]
	at java.base/java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:304) ~[na:na]
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128) ~[na:na]
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628) ~[na:na]
	at java.base/java.lang.Thread.run(Thread.java:834) ~[na:na]
Caused by: org.springframework.context.ApplicationContextException: Unable to start ReactiveWebApplicationContext due to missing ReactiveWebServerFactory bean.
	at org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.getWebServerFactory(ReactiveWebServerApplicationContext.java:103) ~[spring-boot-2.1.12.RELEASE.jar:2.1.12.RELEASE]
	at org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.createWebServer(ReactiveWebServerApplicationContext.java:88) ~[spring-boot-2.1.12.RELEASE.jar:2.1.12.RELEASE]
	at org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.onRefresh(ReactiveWebServerApplicationContext.java:78) ~[spring-boot-2.1.12.RELEASE.jar:2.1.12.RELEASE]
	... 28 common frames omitted
```

