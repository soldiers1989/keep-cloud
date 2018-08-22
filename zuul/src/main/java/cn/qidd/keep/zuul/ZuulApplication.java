package cn.qidd.keep.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringCloudApplication
@EnableZuulProxy
public class ZuulApplication {

    private final static Logger logger = LoggerFactory.getLogger(ZuulApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication application = new SpringApplication(ZuulApplication.class);
        ConfigurableEnvironment env = application.run(args).getEnvironment();
        logger.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}\n\t" +
                        "External: \thttp://{}:{}\n\t" +
                        "Swagger-ui: \thttp://localhost:{}/swagger-ui.html\n\t" +
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getProperty("server.port"),
                env.getProperty("server.port"));
    }
}
