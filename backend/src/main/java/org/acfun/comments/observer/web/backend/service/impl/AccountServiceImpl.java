package org.acfun.comments.observer.web.backend.service.impl;

import org.acfun.comments.observer.web.backend.entity.Account;
import org.acfun.comments.observer.web.backend.mapper.AccountMapper;
import org.acfun.comments.observer.web.backend.service.IAccountService;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Wang Hongshuo
 * @since 2024-02-17
 */
@Service
@DS("acfuncommweb")
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
