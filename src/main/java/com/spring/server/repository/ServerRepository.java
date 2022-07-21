package com.spring.server.repository;

import com.spring.server.model.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Do Quoc Viet
 * @version 1.0
 * @since July 21, 2022 - 22:22:51
 */
public interface ServerRepository extends JpaRepository<Server, Long> {
    Server findByIpAddress(String ipAddress);
}
