package cn.saatana.org.service;

import cn.saatana.common.CurdService;
import cn.saatana.entity.Org;
import cn.saatana.org.repository.OrgRepository;
import org.springframework.stereotype.Service;

@Service
public class OrgService extends CurdService<OrgRepository, Org> {

}
