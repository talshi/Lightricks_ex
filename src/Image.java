import java.util.Random;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class Image {
	
	private Mat img;
	
	public Image() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	
	public Image(Image img) {
		this.img = img.getImage().clone();
	}
	
	public void createMockImage(int col, int row) {
		Mat mat = new Mat(col, row, CvType.CV_32FC1);
		for(int i = 0; i < mat.width(); i++) {
			for(int j = 0; j < mat.height(); j++) {
				double randFloat = getRandomNumber();
				mat.put(i, j, randFloat);
			}
		}
		
		mat = createHole(mat);
		
		this.img = mat;
	}
	
	private Mat createHole(Mat m) {
		Mat mat = m;
		for(int i = mat.width()/2; i < mat.width(); i++) {
			for(int j = 0; j < mat.height(); j++) {
				mat.put(i, j, -1.0);
			}
		}
		return mat;
	}
	
	private double getRandomNumber() {
		Random rand = new Random();
		return rand.nextDouble();
	}

	public String getDumpedImage() {
		return this.img.dump();
	}
	
	public Mat getImage() {
		return this.img;
	}
	
}
