package org.summer.tiger.pojo;

import lombok.Builder;
import lombok.Data;
import org.summer.tiger.util.JSON;

@Data
@Builder
public class UserJWT {

    private String username;

    public String toJson() {
        return JSON.toJson(this);
    }
}
