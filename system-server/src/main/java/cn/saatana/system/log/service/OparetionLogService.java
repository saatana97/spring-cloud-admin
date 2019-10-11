package cn.saatana.system.log.service;

import cn.saatana.system.common.CurdService;
import cn.saatana.system.log.entity.OparetionLog;
import cn.saatana.system.log.repository.OparetionLogRepository;
import org.springframework.stereotype.Service;

@Service
public class OparetionLogService extends CurdService<OparetionLogRepository, OparetionLog> {
}
