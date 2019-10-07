package ps.service;

import ps.bean.ImageBean;

import java.util.List;
import java.util.Map;

public interface IImageService {
    List<ImageBean> findImages();
    Map<Integer,String> findTotal();

    Map<Integer,String> xiayizhang(Integer bianh);
}
