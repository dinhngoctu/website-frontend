package WS.BLG.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

//    @Bean
//    public JwtAccessTokenConverter accessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey("123");
//        return converter;
//    }


//    @Bean
//    public JwtTokenStore tokenStore() {
////        JdbcTokenStore store = new JdbcTokenStore(DataSource dataSource);
////        config lại chô này để luu token lên redis invalid token
//        return new JwtTokenStore(accessTokenConverter());
//    }


//    @Bean
//    public DefaultTokenServices tokenServices() {
//        DefaultTokenServices services = new DefaultTokenServices();
//        services.setTokenStore(tokenStore());
////        set clientdetailsv set tokenenhanser
//        return services;
//    }

    //    @Bean
//    public ResourceServerTokenServices tokenServices() {
//        final RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
//        remoteTokenServices.setClientId(clientId);
//        remoteTokenServices.setClientSecret(secret);
//        remoteTokenServices.setCheckTokenEndpointUrl(url);
//        return remoteTokenServices;
//    }


//      cau hinh restemplate cho feign client tu dong lay token them vao de gui internal request. co the nghien cuu cau hinh grpc
//    @Bean
//    public RequestInterceptor requestTokenBearerInterceptor() {
//        return new RequestInterceptor() {
//            @Override
//            public void apply(RequestTemplate requestTemplate) {
//                OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)
//                        SecurityContextHolder.getContext().getAuthentication().getDetails();
//                requestTemplate.header("Authorization", "Bearer" + " " + details.getTokenValue());
//            }
//        };
//    }

}
