package com.commity.backmethod.dto;

import com.commity.backmethod.dto.base.OutputConverter;
import com.commity.backmethod.pojo.AdminRole;
import com.commity.backmethod.pojo.UserLogin;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserDTO implements OutputConverter<UserDTO, UserLogin> {

    private String idCard;
    private String username;
    private String name;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    private boolean enabled;

    private List<AdminRole> roles;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<AdminRole> getRoles() {
        return roles;
    }

    public void setRoles(List<AdminRole> roles) {
        this.roles = roles;
    }
}
