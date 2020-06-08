package site.licsber.shop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import site.licsber.shop.model.CustomConfig;
import site.licsber.shop.model.Res;
import site.licsber.shop.service.SingleImgUploadService;
import site.licsber.shop.utils.TokenUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@Service
public class SingleImgUploadServiceImpl implements SingleImgUploadService {

    private final File savePath;

    public SingleImgUploadServiceImpl(CustomConfig customConfig) {
        savePath = new File(customConfig.getImgUploadPath());
        if (!savePath.exists()) {
            boolean res = savePath.mkdir();
            if (!res) {
                log.error(savePath + " 创建失败");
                System.exit(0);
            }
        }
    }

    @Override
    public Res saveImg(MultipartFile file, String host) {
        Res res = new Res(400, "文件格式错误", null);
        if (!file.isEmpty()) {
            File f = new File(savePath, TokenUtils.genToken() +
                    Objects.requireNonNull(file.getOriginalFilename())
                            .substring(file.getOriginalFilename().length() - 4));
            try {
                file.transferTo(f);
                res.setCode(200);
                res.setMsg("文件保存成功");
                res.setData(host + "img/" + f.getName());
            } catch (IOException e) {
                res.setData(e.getMessage());
            }
        }
//        if (!f.getParentFile().exists())
//            f.getParentFile().mkdirs();
//        try {
//            file.transferTo(f);
//            String imgURL = "http://localhost:8443/api/file/" + f.getName();
//            return imgURL;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "";
//        }
        return res;
    }

}
