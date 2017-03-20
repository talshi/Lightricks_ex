import org.opencv.core.Point;

public class Weight {

	private float z = 2;
	private float epsilon = 0.0001f;

	public Weight(float z, float epsilon){
		this.z = z;
		this.epsilon = epsilon;

	}
	
	public double weight(Point p) {
		return 1 / Math.pow(Math.abs(p.x - p.y), z) + epsilon;
	};

}
