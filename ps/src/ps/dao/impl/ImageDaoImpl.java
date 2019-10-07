package ps.dao.impl;

import ps.bean.ImageBean;
import ps.dao.IImageDao;
import ps.util.ConnectionFactory;

import javax.xml.soap.SOAPConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ImageDaoImpl  implements IImageDao {
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    @Override
    public List<ImageBean> findImages() {
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet=null;
        Random rand = new Random();
        int totalcount=0;
        try {
            connection=ConnectionFactory.getConnection();
            StringBuffer sqltotal=new StringBuffer("select * from images");
            preparedStatement=connection.prepareStatement(sqltotal.toString());
            resultSet=preparedStatement.executeQuery();
            System.out.println(resultSet);
            List<ImageBean> images=new ArrayList<>();
            while(resultSet.next()){
                ImageBean image=new ImageBean();
                image.setBianhao(resultSet.getInt("bianhao"));
                image.setImages(resultSet.getString("images"));
                images.add(image);
                totalcount++;
            }
            return images;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConnectionFactory.close(connection,preparedStatement,resultSet);
        }
        return null;
    }

    @Override
    public Map<Integer,String> findTotal() {
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet=null;
        Random rand = new Random();
        int totalcount=0;
        Map<Integer,String> n=new HashMap<Integer,String>();
        try {
            connection=ConnectionFactory.getConnection();
            StringBuffer sqltotal=new StringBuffer("select * from images");
            preparedStatement=connection.prepareStatement(sqltotal.toString());
            resultSet=preparedStatement.executeQuery();
            System.out.println(resultSet);
            List<ImageBean> images=new ArrayList<>();
            while(resultSet.next()){
                totalcount++;
            }
           int randonshuzi=(int)(Math.random()*totalcount+1);
            String duiying=null;
            duiying=findImageName(randonshuzi);
            n.put(randonshuzi,duiying);
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConnectionFactory.close(connection,preparedStatement,resultSet);
        }
        return null;
    }

    @Override
    public Map<Integer, String> xiayizhang(Integer bianh) {
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet=null;
        Random rand = new Random();
        int totalcount=0;
        Map<Integer,String> n=new HashMap<Integer,String>();
        try {
            connection=ConnectionFactory.getConnection();
            StringBuffer sqltotal=new StringBuffer("select * from images where bianhao!=?");
            preparedStatement=connection.prepareStatement(sqltotal.toString());
            preparedStatement.setInt(1,bianh);
            resultSet=preparedStatement.executeQuery();
            System.out.println(resultSet);
            List<ImageBean> images=new ArrayList<>();
            while(resultSet.next()){
                totalcount++;
            }
            Random r=new Random();
            int randonshuzi=(int)(r.nextInt(totalcount)+1);
            String duiying=null;
            duiying=findImageName(randonshuzi);
            n.put(randonshuzi,duiying);
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConnectionFactory.close(connection,preparedStatement,resultSet);
        }
        return null;
    }

    public String findImageName(int id){
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet=null;
        Random rand = new Random();
        int totalcount=0;
        try {
            connection=ConnectionFactory.getConnection();
            StringBuffer sqltotal=new StringBuffer("select images from images where bianhao=?");
            preparedStatement=connection.prepareStatement(sqltotal.toString());
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            System.out.println(resultSet);
            ImageBean image=null;
            String imageName=null;
            while(resultSet.next()){
                imageName=resultSet.getString("images");
                totalcount++;
            }
                return imageName;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConnectionFactory.close(connection,preparedStatement,resultSet);
        }
        return null;
    }

}
