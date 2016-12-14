package com.xuguo.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.omg.CORBA.Current;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.druid.sql.parser.Token;
import com.xuguo.dao.BloggerDao;
import com.xuguo.entity.Blogger;
import com.xuguo.service.BloggerService;

/**
 * Realm
 * @author xu
 *
 */
public class MyRealm extends AuthorizingRealm{
	
	@Resource
	private BloggerService bloggerService;
	
	
	//����Ȩ�޺ͽ�ɫ
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//��½��֤
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		//ͨ���û������ʵ�壨���ݿ��װʵ�壩
		Blogger blogger = bloggerService.getByUserName(userName);
		if(blogger!=null){
			//password or userName can be wrong
			//ͨ��shiro�ṩ�ķ�����ȡsession
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", blogger);//���浱ǰ�û���Ϣ��session
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(blogger.getUserName(),blogger.getPassword(),"");
			return authenticationInfo;
		}else{		
			return null;
		}
	}

}
