package cn.saatana.auth.repository;

import cn.saatana.common.CurdRepository;
import cn.saatana.entity.Authorize;
import org.springframework.stereotype.Component;

@Component
public interface AuthorizeRepository extends CurdRepository<Authorize> {

	Authorize getByUsername(String username);

	Authorize getByOpenId(String openId);
}
