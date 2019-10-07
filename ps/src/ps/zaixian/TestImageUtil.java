package ps.zaixian;

import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;


import ps.zaixian.ImageUtil;

public class TestImageUtil {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

        public void testShiftSaturability(int i,Mat imread) {
            ImageUtil.Base.shiftSaturability(imread, i);
        }


        public void testShiftContrast(int i,Mat imread) {
            ImageUtil.Base.shiftContrast(imread, i);
        }

        public void testShiftBrightness(Mat imread) {
            for (int i = 0; i <= 255; i += 50) {
                ImageUtil.Base.shiftBrightness(imread,i);
            }
        }


        public void testTransposition(Mat imread) {
        ImageUtil.Base.transposition(imread);
        }

    public void testGaussianFiltering(Mat imread) {
        for (int i = 3; i < 20; i += 2) {
            ImageUtil.Filter.gaussianFiltering(imread, i, 100);
            System.out.println(i);
        }
    }


    public void testAverageFiltering(Mat imread) {
        for (int i = 3; i < 20; i += 2) {
            ImageUtil.Filter.averageFiltering(imread, i);
            System.out.println(i);
        }
    }


    public void testSharpen(Mat imread) {
        for (int i = 3; i < 20; i += 2) {
            ImageUtil.Filter.sharpen(imread, i, 2);
            System.out.println(i);
        }
    }


    public void testDisFog(Mat imread) {
        ImageUtil.Filter.disFog(imread, 20);
    }


    public void testEdgeDetection(Mat imread) {
        ImageUtil.Filter.edgeDetection(imread);
    }



    public void testOilPainting(Mat imread) {
        ImageUtil.Filter.oilPainting(imread);
    }

    public static void main(String[] args) {

    }

    }





