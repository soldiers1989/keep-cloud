package cn.qidd.keep.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.net.InetAddress;
import java.net.UnknownHostException;

@EnableElasticsearchRepositories(basePackages = "cn.qidd.keep.common.repository.elastic")
@EnableMongoRepositories(basePackages = "cn.qidd.keep.common.repository.mongo")
@EnableJpaRepositories(basePackages = "cn.qidd.keep.common.repository.jpa")
@EntityScan("cn.qidd.keep.domain.entity")
@EnableDiscoveryClient
@SpringBootApplication
public class CommonApplication {

    private static final Logger logger = LoggerFactory.getLogger(CommonApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication application = new SpringApplication(CommonApplication.class);
        ConfigurableEnvironment env = application.run(args).getEnvironment();
        logger.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}\n\t" +
                        "External: \thttp://{}:{}\n\t" +
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getProperty("server.port"));
    }
}
