import java.util.HashSet;

import org.opencv.core.Point;

public class FillAlgorithm {

	FillAlgorithmWeight weight;
	
	// default constructor
	public FillAlgorithm(float z, float epsilon) {
		this.weight = new FillAlgorithmWeightDefault(z, epsilon);
	}
	
	// custom weight function
	public FillAlgorithm(FillAlgorithmWeight weight) {
		this.weight = weight;
	}
	
	public double fillFunction(Image img, Point p, HashSet<Point> boundary) {
		double numerator = 0;
		double denominator = 0;
		for (Point pb : boundary) {
			double weight = this.weight.weight(img, p, pb);
			numerator +=  weight * img.getImage().get(new Double(pb.x).intValue(), new Double(pb.y).intValue())[0];
			denominator += weight;
		}

		return numerator/denominator;
	}

}
