package cn.saatana.system.file.service;

import cn.saatana.common.CurdService;
import cn.saatana.entity.Resource;
import cn.saatana.system.file.repository.ResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourceService extends CurdService<ResourceRepository, Resource> {

}
