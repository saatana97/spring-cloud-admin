package cn.saatana.system.dict.repository;

import cn.saatana.system.common.CurdRepository;
import cn.saatana.system.dict.entity.Dictionary;
import org.springframework.stereotype.Component;

@Component
public interface DictionaryRepository extends CurdRepository<Dictionary> {

}
