package com.spring.server.service.implementation;

import com.spring.server.model.entity.Server;
import com.spring.server.repository.ServerRepository;
import com.spring.server.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

import static com.spring.server.model.enumeration.Status.SERVER_DOWN;
import static com.spring.server.model.enumeration.Status.SERVER_UP;
import static java.lang.Boolean.TRUE;

/**
 * @author Do Quoc Viet
 * @version 1.0
 * @since July 21, 2022 - 22:29:34
 */

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ServerServiceImpl implements ServerService {

    private final ServerRepository serverRepository;

    @Override
    public Server create(Server server) {
        log.info("Saving new server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepository.save(server);
    }

    @Override
    public Server ping(String ipAddress) {
        log.info("Pinging server IP: {}", ipAddress);
        Server server = serverRepository.findByIpAddress(ipAddress);
        try {
            server.setStatus(InetAddress
                    .getByName(ipAddress)
                    .isReachable(1000) ? SERVER_UP : SERVER_DOWN);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return serverRepository.save(server);
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fetching all servers");
        return serverRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("Fetching server by id: {}", id);
        return serverRepository.findById(id).orElseThrow();
    }

    @Override
    public Server update(Server server) {
        log.info("Updating server: {}", server.getName());
        return serverRepository.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting server by id: {}", id);
        serverRepository.deleteById(id);
        return TRUE;
    }

    private String setServerImageUrl() {
        String[] imageNames = {
                "server1",
                "server2",
                "server3",
                "server4"
        };
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("server/image/" + imageNames[new Random().nextInt(4)])
                .toUriString();
    }
}
