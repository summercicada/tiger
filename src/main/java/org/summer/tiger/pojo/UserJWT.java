package org.summer.tiger.pojo;

import lombok.Data;
import org.summer.tiger.util.JSON;

@Data
public class UserJWT {

    private String username;

    public String toJson() {
        return JSON.toJson(this);
    }
}
