package site.licsber.shop.model.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import site.licsber.shop.model.entity.User;

@Data
public class SubmitCommentForm {

    private Integer itemId;

    private String msg;

    @JsonIgnore
    private User user;

}
