package com.spring.server.api;

import com.spring.server.model.response.Response;
import com.spring.server.service.ServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;


/**
 * @author Do Quoc Viet
 * @version 1.0
 * @since July 21, 2022 - 23:30:02
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("api/servers/")
public class ServerController {

    private final ServerService serverService;

    @GetMapping("/list")
    public ResponseEntity<Response> getServers() {
        return ResponseEntity.ok(Response.builder()
                .timestamp(now())
                .data(Map.of("servers", serverService.list(30)))
                .message("Servers retrieved")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }
}
