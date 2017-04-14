package com.chinawiserv.dsp.dcm.service.impl;

import com.chinawiserv.dsp.dcm.entity.User;
import com.chinawiserv.dsp.dcm.mapper.UserMapper;
import com.chinawiserv.dsp.dcm.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
}
