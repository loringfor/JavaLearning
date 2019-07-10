package com.loring.rpc.jmx;

import com.loring.rpc.core.recv.MessageRecvExecutor;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.*;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;
import org.springframework.jmx.support.MBeanServerFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;
import javax.management.*;
import java.io.IOException;

@Configuration
@EnableMBeanExport
@ComponentScan("com.loring.rpc.jmx")
public class ThreadPoolMonitorProvider {
    public final static String DELIMITER = ":";
    public static String url;
    public static String jmxPoolSizeMethod = "setPoolSize";
    public static String jmxActiveCountMethod = "setActiveCount";
    public static String jmxCorePoolSizeMethod = "setCorePoolSize";
    public static String jmxMaximumPoolSizeMethod = "setMaximumPoolSize";
    public static String jmxLargestPoolSizeMethod = "setLargestPoolSize";
    public static String jmxTaskCountMethod = "setTaskCount";
    public static String jmxCompletedTaskCountMethod = "setCompletedTaskCount";

    @Bean
    public ThreadPoolStatus threadPoolStatus() {
        return new ThreadPoolStatus();
    }

    @Bean
    public MBeanServerFactoryBean mbeanServer() {
        return new MBeanServerFactoryBean();
    }

    @Bean
    public RmiRegistryFactoryBean registry() {
        return new RmiRegistryFactoryBean();
    }

    @Bean
    @DependsOn("registry")
    public ConnectorServerFactoryBean connectorServer() throws MalformedObjectNameException {
        MessageRecvExecutor ref = MessageRecvExecutor.getInstance();
        String ipAddr = StringUtils.isNotEmpty(ref.getServerAddress()) ? StringUtils.substringBeforeLast(ref.getServerAddress(), DELIMITER) : "localhost";
        url = "META-INF.META-INF:jmx:rmi://" + ipAddr + "/jndi/rmi://" + ipAddr + ":1099/nettyrpcstatus";
        System.out.println("NettyRPC JMX MonitorURL : [" + url + "]");
        ConnectorServerFactoryBean connectorServerFactoryBean = new ConnectorServerFactoryBean();
        connectorServerFactoryBean.setObjectName("connector:name=rmi");
        connectorServerFactoryBean.setServiceUrl(url);
        return connectorServerFactoryBean;
    }

    public static void monitor(ThreadPoolStatus status) throws IOException, MalformedObjectNameException, ReflectionException, MBeanException, InstanceNotFoundException {
        MBeanServerConnectionFactoryBean mBeanServerConnectionFactoryBean = new MBeanServerConnectionFactoryBean();
        mBeanServerConnectionFactoryBean.setServiceUrl(url);
        mBeanServerConnectionFactoryBean.afterPropertiesSet();
        MBeanServerConnection connection = mBeanServerConnectionFactoryBean.getObject();
        ObjectName objectName = new ObjectName("com.newlandframework.rpc.parallel.jmx:name=threadPoolStatus,type=ThreadPoolStatus");

        connection.invoke(objectName, jmxPoolSizeMethod, new Object[]{status.getPoolSize()}, new String[]{int.class.getName()});
        connection.invoke(objectName, jmxActiveCountMethod, new Object[]{status.getActiveCount()}, new String[]{int.class.getName()});
        connection.invoke(objectName, jmxCorePoolSizeMethod, new Object[]{status.getCorePoolSize()}, new String[]{int.class.getName()});
        connection.invoke(objectName, jmxMaximumPoolSizeMethod, new Object[]{status.getMaximumPoolSize()}, new String[]{int.class.getName()});
        connection.invoke(objectName, jmxLargestPoolSizeMethod, new Object[]{status.getLargestPoolSize()}, new String[]{int.class.getName()});
        connection.invoke(objectName, jmxTaskCountMethod, new Object[]{status.getTaskCount()}, new String[]{long.class.getName()});
        connection.invoke(objectName, jmxCompletedTaskCountMethod, new Object[]{status.getCompletedTaskCount()}, new String[]{long.class.getName()});
    }
}
