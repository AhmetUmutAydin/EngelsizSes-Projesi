import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
 
public class post_image {
	public Mat take_p() throws Exception {
		
				System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
				Mat imageArray = new Mat();
				VideoCapture videoDevice = new VideoCapture();
				videoDevice.open(0);
				if (videoDevice.isOpened()) {
					videoDevice.read(imageArray);

					videoDevice.release();
					
				} else {
					System.out.println("Video aygitina Baglanamadi.");
				}
				
				return imageArray;
		
	}
	
	/*
	 
	 
	    */
	
	public  BufferedImage Mat2BufferedImage(Mat matrix)throws Exception {        
	    MatOfByte mob=new MatOfByte();
	    Imgcodecs.imencode(".jpg", matrix, mob);
	    byte ba[]=mob.toArray();

	    BufferedImage bi=ImageIO.read(new ByteArrayInputStream(ba));
	    return bi;
	}
}