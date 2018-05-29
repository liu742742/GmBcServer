package com;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.common.MyFilter;
import com.common.MyInterceptor;

@SuppressWarnings("deprecation")
@SpringBootApplication
@MapperScan("com.dao")
public class GmBcServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmBcServerApplication.class, args);
    }
    
//    //mvc控制器
//    //@Configuration
//    static class WebMvcConfigurer extends WebMvcConfigurerAdapter{
//        //增加拦截器
//        public void addInterceptors(InterceptorRegistry registry){
//            registry.addInterceptor(new MyInterceptor())    //指定拦截器类
//                    .addPathPatterns("/");        //指定该类拦截的url
//        }
//    }
    
//    //过滤器
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        List<String> urlPatterns = new ArrayList<String>();
//        MyFilter testFilter = new MyFilter();   //new过滤器
//        urlPatterns.add("/");      //指定需要过滤的url
//        filterRegistrationBean.setFilter(testFilter);       //set
//        filterRegistrationBean.setUrlPatterns(urlPatterns);     //set
//        return filterRegistrationBean;
//    }
    
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1. 需要定义一个converter转换消息的对象
        FastJsonHttpMessageConverter fasHttpMessageConverter = new FastJsonHttpMessageConverter();

        // 2. 添加fastjson的配置信息，比如:是否需要格式化返回的json的数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        // 3. 在converter中添加配置信息
        fasHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fasHttpMessageConverter;
        return new HttpMessageConverters(converter);
    }
}
