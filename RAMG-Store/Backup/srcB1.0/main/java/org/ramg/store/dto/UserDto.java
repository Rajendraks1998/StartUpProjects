package org.ramg.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String store;
    private String address;
    private Long contact;
    private String email;
    private String password;
}
