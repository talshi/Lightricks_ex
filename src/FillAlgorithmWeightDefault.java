import org.opencv.core.Point;

public class FillAlgorithmWeightDefault extends FillAlgorithmWeight {

	private float z = 2;
	private float epsilon = 0.0001f;
	
	public FillAlgorithmWeightDefault(float z, float epsilon) {
		this.z = z;
		this.epsilon = epsilon;
	}
	
	public double weight(Image img, Point p, Point pb) {
		double x = img.getImage().get(new Double(p.x).intValue(), new Double(p.y).intValue())[0];
		double yi = img.getImage().get(new Double(pb.x).intValue(), new Double(pb.y).intValue())[0];
		return 1 / (Math.pow(Math.abs(x - yi), z) + epsilon);
	};
	
}
