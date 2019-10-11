package cn.saatana.system.auth.service;

import cn.saatana.system.auth.entity.Authorizer;
import cn.saatana.system.auth.repository.AuthorizerRepository;
import cn.saatana.system.common.CurdService;
import org.springframework.stereotype.Service;

@Service
public class AuthorizerService extends CurdService<AuthorizerRepository, Authorizer> {
	public Authorizer getByUsername(String username) {
		return repository.getByUsername(username);
	}

	public Authorizer getByOpenId(String openId) {
		return repository.getByOpenId(openId);
	}

}
