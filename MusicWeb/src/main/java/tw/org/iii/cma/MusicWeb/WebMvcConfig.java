package tw.org.iii.cma.MusicWeb;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang"); 
		//和jsp name一致
		registry.addInterceptor(interceptor);
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//文件磁盘图片url 映射
		//配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
		registry.addResourceHandler("/imgs/**").addResourceLocations("classpath:/imgs/");
		}
	
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver= new CookieLocaleResolver();
		resolver.setDefaultLocale(Locale.TAIWAN);
		resolver.setCookieMaxAge(86400);
		resolver.setCookieName("langCookie");
		return resolver;
	}
//	@Autowired
//	private TryInterceptor tryInterceptor;
	
	@Override // 處理圖片看不到的問題
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:8081");
//		WebMvcConfigurer.super.addCorsMappings(registry);
	}
	
}



