package com.hnuc;


import com.hnuc.interceptor.MiniInterceptor;
import com.hnuc.common.util.Constant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMVCConfig extends WebMvcConfigurationSupport {

    @Bean
    public MiniInterceptor newInterceptor(){
        return new MiniInterceptor();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("file:"+Constant.USER_DATA_ROOT_PATH  + "/");
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(newInterceptor())
                .addPathPatterns("/video/*")
                .addPathPatterns("/user/*")
                .excludePathPatterns("/video/query*")
                .excludePathPatterns("/user/query*");
        super.addInterceptors(registry);
    }
}
