package cn.saatana.system.common;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurdRepository<Entity extends BaseEntity> extends JpaRepository<Entity, String> {
}
