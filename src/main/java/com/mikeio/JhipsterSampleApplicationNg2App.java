package com.mikeio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;


@ComponentScan
@EnableAutoConfiguration
@EnableTransactionManagement
public class JhipsterSampleApplicationNg2App {

    private static final Logger log = LoggerFactory.getLogger(JhipsterSampleApplicationNg2App.class);

    private final Environment env;

    public JhipsterSampleApplicationNg2App(Environment env) {
        this.env = env;
    }



    /**
     * Main method, used to run the application.
     *
     * @param args the command line arguments
     * @throws UnknownHostException if the local host name could not be resolved into an address
     */
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(JhipsterSampleApplicationNg2App.class);

        Map<String, Object> defProperties =  new HashMap<>();
        /*
        * The default profile to use when no other profiles are defined
        * This cannot be set in the <code>application.yml</code> file.
        * See https://github.com/spring-projects/spring-boot/issues/1219
        */
        defProperties.put("spring.profiles.default", "dev");
        app.setDefaultProperties(defProperties);

        Environment env = app.run(args).getEnvironment();

    }
}
