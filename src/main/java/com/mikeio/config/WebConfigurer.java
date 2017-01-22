package com.mikeio.config;


import com.mikeio.util.CachingHttpHeadersFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.MimeMappings;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.inject.Inject;
import javax.servlet.*;
import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.EnumSet;

/**
 * Configuration of web application with Servlet 3.0 APIs.
 */
@Configuration
public class WebConfigurer implements ServletContextInitializer
//        , EmbeddedServletContainerCustomizer
{

    private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);

    @Inject
    private Environment env;



    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        if (env.getActiveProfiles().length != 0) {
            log.info("Web application configuration, using profiles: {}", Arrays.toString(env.getActiveProfiles()));
        }

        log.info("Web application fully configured");
    }

//    /**
//     * Customize the Servlet engine: Mime types, the document root, the cache.
//     */
//    @Override
//    public void customize(ConfigurableEmbeddedServletContainer container) {
//        MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
//        // IE issue, see https://github.com/jhipster/generator-jhipster/pull/711
//        mappings.add("html", "text/html;charset=utf-8");
//        // CloudFoundry issue, see https://github.com/cloudfoundry/gorouter/issues/64
//        mappings.add("json", "text/html;charset=utf-8");
//        container.setMimeMappings(mappings);
//        // When running in an IDE or with ./mvnw spring-boot:run, set location of the static web assets.
//        setLocationForStaticAssets(container);
//    }

//    private void setLocationForStaticAssets(ConfigurableEmbeddedServletContainer container) {
//        File root;
//        String prefixPath = resolvePathPrefix();
//        if (env.acceptsProfiles(Constants.SPRING_PROFILE_PRODUCTION)) {
//            root = new File(prefixPath + "target/www/");
//        } else {
//            root = new File(prefixPath + "src/main/webapp/");
//        }
//        if (root.exists() && root.isDirectory()) {
//            container.setDocumentRoot(root);
//        }
//    }

//    /**
//     *  Resolve path prefix to static resources.
//     */
//    private String resolvePathPrefix() {
//        String fullExecutablePath = this.getClass().getResource("").getPath();
//        String rootPath = Paths.get(".").toUri().normalize().getPath();
//        String extractedPath = fullExecutablePath.replace(rootPath, "");
//        int extractionEndIndex = extractedPath.indexOf("target/");
//        if(extractionEndIndex <= 0) {
//            return "";
//        }
//        return extractedPath.substring(0, extractionEndIndex);
//    }

//    /**
//     * Initializes the caching HTTP Headers Filter.
//     */
//    private void initCachingHttpHeadersFilter(ServletContext servletContext,
//                                              EnumSet<DispatcherType> disps) {
//        log.debug("Registering Caching HTTP Headers Filter");
//        FilterRegistration.Dynamic cachingHttpHeadersFilter =
//            servletContext.addFilter("cachingHttpHeadersFilter",
//                new CachingHttpHeadersFilter());
//
//        cachingHttpHeadersFilter.addMappingForUrlPatterns(disps, true, "/content/*");
//        cachingHttpHeadersFilter.addMappingForUrlPatterns(disps, true, "/app/*");
//        cachingHttpHeadersFilter.setAsyncSupported(true);
//    }



//    @Bean
//    @ConditionalOnProperty(name = "jhipster.cors.allowed-origins")
//    public CorsFilter corsFilter() {
//        log.debug("Registering CORS filter");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = jHipsterProperties.getCors();
//        source.registerCorsConfiguration("/api/**", config);
//        source.registerCorsConfiguration("/v2/api-docs", config);
//        source.registerCorsConfiguration("/oauth/**", config);
//        return new CorsFilter(source);
//    }


}
