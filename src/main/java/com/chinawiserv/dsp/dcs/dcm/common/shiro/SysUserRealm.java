package com.chinawiserv.dsp.dcs.dcm.common.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysMenu;
import com.chinawiserv.dsp.dcs.dcm.entity.po.system.SysUser;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysMenuService;
import com.chinawiserv.dsp.dcs.dcm.service.system.ISysUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * 认证
 */
public class SysUserRealm extends AuthorizingRealm {
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysMenuService sysMenuService;
    
    /**
     * 授权(验证权限时调用)
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
		SysUser user = (SysUser)principals.getPrimaryPrincipal();
		String userId = user.getId();

		List<String> permsList;
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//系统管理员，拥有最高权限
		//todo xxx
        try {
            if("1".equals(userId)){
                List<SysMenu> menuList = sysMenuService.selectList(new EntityWrapper<SysMenu>());
                permsList = new ArrayList<>(menuList.size());
                for(SysMenu menu : menuList){
                    permsList.add(menu.getResourceName());
                }
            } else{
                permsList = sysMenuService.selectMenuIdsByuserId(userId);
            }
            //用户权限列表
            Set<String> permsSet = new HashSet<String>();
            for(String perms : permsList){
                if(StringUtils.isBlank(perms)){
                    continue;
                }
                permsSet.addAll(Arrays.asList(perms.trim().split(",")));
            }

            info.setStringPermissions(permsSet);
        }catch (Exception e){
            e.printStackTrace();
        }
		return info;
	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        
        //查询用户信息
		SysUser user =  sysUserService.selectOne(new EntityWrapper<SysUser>().eq("user_name", userName));

//		SysUser user = sysUserService.queryByUserName(username);
        
        //账号不存在
        if(user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        
        //密码错误
        if(!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        
        //账号锁定
		//todo xxx
//        if(user.getStatus() == 0){
//        	throw new LockedAccountException("账号已被锁定,请联系管理员");
//        }
        
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
	}

}
