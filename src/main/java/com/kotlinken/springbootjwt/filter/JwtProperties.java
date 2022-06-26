package com.kotlinken.springbootjwt.filter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "jwt")
@Data
@Component
public class JwtProperties {
    private String secretKey;
    private int expirationTime;
    private String tokenPrefix;
    private String headerString;
}
