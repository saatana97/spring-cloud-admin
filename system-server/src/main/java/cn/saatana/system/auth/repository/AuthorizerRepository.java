package cn.saatana.system.auth.repository;

import cn.saatana.system.auth.entity.Authorizer;
import cn.saatana.system.common.CurdRepository;
import org.springframework.stereotype.Component;

@Component
public interface AuthorizerRepository extends CurdRepository<Authorizer> {

	Authorizer getByUsername(String username);

	Authorizer getByOpenId(String openId);
}
