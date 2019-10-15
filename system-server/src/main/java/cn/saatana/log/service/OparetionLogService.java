package cn.saatana.log.service;

import cn.saatana.common.CurdService;
import cn.saatana.entity.OparetionLog;
import cn.saatana.log.repository.OparetionLogRepository;
import org.springframework.stereotype.Service;

@Service
public class OparetionLogService extends CurdService<OparetionLogRepository, OparetionLog> {
}
