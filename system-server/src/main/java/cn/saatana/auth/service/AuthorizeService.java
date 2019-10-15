package cn.saatana.auth.service;

import cn.saatana.common.CurdService;
import cn.saatana.entity.Authorize;
import cn.saatana.auth.repository.AuthorizeRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeService extends CurdService<AuthorizeRepository, Authorize> {
	public Authorize getByUsername(String username) {
		return repository.getByUsername(username);
	}

	public Authorize getByOpenId(String openId) {
		return repository.getByOpenId(openId);
	}

}
