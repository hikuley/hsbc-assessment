package com.hsbc.gateaway;

import com.hsbc.gateaway.filters.ErrorFilter;
import com.hsbc.gateaway.filters.PostFilter;
import com.hsbc.gateaway.filters.PreFilter;
import com.hsbc.gateaway.filters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ApıGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApıGatewayApplication.class, args);
    }

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }

}
