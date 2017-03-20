import java.util.HashSet;
import org.opencv.core.Point;

public class HoleFilling {

	public Image fill(Image img, HashSet<Point> boundary, HashSet<Point> hole, Weight weight) {
		Image tmp = new Image(img);
		for(Point p : hole) {
			tmp.getImage().put(new Double(p.x).intValue(), new Double(p.y).intValue(), weight.weight(p));
		}

		return tmp;
	}

}
