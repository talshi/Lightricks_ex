import java.util.HashSet;

import org.opencv.core.Point;

public class FillAlgorithm {

	private float z = 2;
	private float epsilon = 0.0001f;

	public FillAlgorithm(float z, float epsilon){
		this.z = z;
		this.epsilon = epsilon;

	}

	private double weight(Image img, Point p, Point pb) {
		double x = img.getImage().get(new Double(p.x).intValue(), new Double(p.y).intValue())[0];
		double yi = img.getImage().get(new Double(pb.x).intValue(), new Double(pb.y).intValue())[0];
		return 1 / (Math.pow(Math.abs(x - yi), z) + epsilon);
	};

	public double fillFunction(Image img, Point p, HashSet<Point> boundary) {
		double numerator = 0;
		double denominator = 0;
		for (Point pb : boundary) {
			double weight = weight(img, p, pb);
			numerator +=  weight * img.getImage().get(new Double(pb.x).intValue(), new Double(pb.y).intValue())[0];
			denominator += weight;
		}

		return numerator/denominator;
	}

}
