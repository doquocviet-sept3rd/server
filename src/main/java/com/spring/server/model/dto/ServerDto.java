package com.spring.server.model.dto;

import com.spring.server.model.enumeration.Status;

import javax.validation.constraints.NotEmpty;

/**
 * @author Do Quoc Viet
 * @version 1.0
 * @since July 21, 2022 - 22:18:01
 */


public class ServerDto {
    private Long id;

    @NotEmpty(message = "IP Address cannot be empty or null")
    private String ipAddress;
    private String name;
    private String memory;
    private String type;
    private String image;
    private Status status;
}
