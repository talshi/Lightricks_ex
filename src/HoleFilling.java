import java.util.HashSet;
import org.opencv.core.Point;

public class HoleFilling {

	public Image fill(Image img, HashSet<Point> boundary, HashSet<Point> hole, FillAlgorithm fa) {
		Image tmp = new Image(img);
		for(Point p : hole) {
			tmp.getImage().put(new Double(p.x).intValue(), new Double(p.y).intValue(), fa.fillFunction(img, p, boundary));
		}

		return tmp;
	}

}
