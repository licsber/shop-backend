package site.licsber.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Res {

    private int code;

    private String message;

    private Object data;
    
}
