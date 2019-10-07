package ps.bean;

public class ImageBean {
    private int bianhao;
    private String images;

    @Override
    public String toString() {
        return "ImageBean{" +
                "bianhao=" + bianhao +
                ", images='" + images + '\'' +
                '}';
    }

    public int getBianhao() {
        return bianhao;
    }

    public void setBianhao(int bianhao) {
        this.bianhao = bianhao;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
