package cn.saatana.file.service;

import cn.saatana.common.CurdService;
import cn.saatana.entity.Resource;
import cn.saatana.file.repository.ResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourceService extends CurdService<ResourceRepository, Resource> {

}
