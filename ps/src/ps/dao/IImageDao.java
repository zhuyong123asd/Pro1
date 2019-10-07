package ps.dao;

import ps.bean.ImageBean;

import java.util.List;
import java.util.Map;

public interface IImageDao {
    List<ImageBean> findImages();

    Map<Integer,String> findTotal();

    Map<Integer, String> xiayizhang(Integer bianh);
}
