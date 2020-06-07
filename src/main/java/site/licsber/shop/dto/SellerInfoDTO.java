package site.licsber.shop.dto;

import lombok.Data;

@Data
public class SellerInfoDTO {

    private String nick;
    private String mail;
    private Integer likeNum;
    private Integer disLikeNum;
    private String sellAddress;
    private Long createTime;

}
