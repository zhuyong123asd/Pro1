package ps.service.impl;

import ps.bean.ImageBean;
import ps.dao.IImageDao;
import ps.dao.impl.ImageDaoImpl;
import ps.service.IImageService;

import java.util.List;
import java.util.Map;

public class ImageServiceImpl implements IImageService {
    IImageDao imgDao=new ImageDaoImpl();
    @Override
    public List<ImageBean> findImages() {
       return imgDao.findImages();
    }

    @Override
    public Map<Integer,String> findTotal() {
        return imgDao.findTotal();
    }

    @Override
    public Map<Integer, String> xiayizhang(Integer bianh) {
        return imgDao.xiayizhang(bianh);
    }
}
