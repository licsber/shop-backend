package site.licsber.shop.service;

import org.springframework.web.multipart.MultipartFile;
import site.licsber.shop.model.Res;

public interface SingleImgUploadService {

    Res saveImg(MultipartFile file, String host);

}
