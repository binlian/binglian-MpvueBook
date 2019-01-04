package com.binglian.config;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.binglian.service.impl.CustomRealm;

@Configuration
public class ShiroConfig {
	
	
	/**
	 * 1.构建securityManager环境
		DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
		defaultSecurityManager.setRealm(customRealm);
		
		HashedCredentialsMatcher matcher=new HashedCredentialsMatcher();//加密配置
		matcher.setHashAlgorithmName("MD5");//使用算法md5
		matcher.setHashIterations(1);//加密次数
		
		customRealm.setCredentialsMatcher(matcher);//对自定义Realm进行加密配置
		
	 */
	
	
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
		ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 拦截器。匹配原则是最上面的最优先匹配
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        // 配置不会被拦截的链接 顺序判断
     	filterChainDefinitionMap.put("/css/**", "anon");
     	filterChainDefinitionMap.put("/image/**", "anon");
     	filterChainDefinitionMap.put("/js/**", "anon");
     	filterChainDefinitionMap.put("/wangEditor/**", "anon");
     	filterChainDefinitionMap.put("https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css", "anon");
     	filterChainDefinitionMap.put("https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js", "anon");
     	
     	filterChainDefinitionMap.put("/admin/login", "anon");
        filterChainDefinitionMap.put("/admins/login", "anon");
        filterChainDefinitionMap.put("/yan/getVerify", "anon");
        filterChainDefinitionMap.put("/book/list", "anon");
        filterChainDefinitionMap.put("/regist", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        // 剩余请求需要身份认证
        filterChainDefinitionMap.put("/**", "authc");
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/admin/login");
        
//        // 登录成功后要跳转的链接
//     	shiroFilterFactoryBean.setSuccessUrl("/admin/index");
//
//     	//未授权界面;
//     	shiroFilterFactoryBean.setUnauthorizedUrl("/403");
//     	shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//     		
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
	}
	
	public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
	    @Override
	    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
	        String successUrl = "/admin/index";
	        WebUtils.issueRedirect(request,response,successUrl);
	        return false;
	    }
	}
	
	@Bean
    public CustomRealm myShiroRealm(HashedCredentialsMatcher matcher){
        CustomRealm myShiroRealm = new CustomRealm();
        myShiroRealm.setCredentialsMatcher(matcher);
        return myShiroRealm;
    }


    @Bean
    public SecurityManager securityManager(HashedCredentialsMatcher matcher){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm(matcher));
        return securityManager;
    }

    /**
     * 密码加密配置
     * 加密次数
     * 并给realm
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 采用MD5方式加密
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        // 设置加密次数
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }
    
    /**
     *  开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
  
    /**
     * 开启aop注解支持
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    
}
