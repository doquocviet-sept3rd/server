package com.spring.server.service;

import com.spring.server.model.entity.Server;

import java.io.IOException;
import java.util.Collection;

/**
 * @author Do Quoc Viet
 * @version 1.0
 * @since July 21, 2022 - 22:29:16
 */
public interface ServerService {

    Server create(Server server);

    Server ping(String ipAddress);

    Collection<Server> list(int limit);

    Server get(Long id);

    Server update(Server server);

    Boolean delete(Long id);
}
