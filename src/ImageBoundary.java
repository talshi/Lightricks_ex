import java.util.HashSet;
import org.opencv.core.Point;

public class ImageBoundary {

	private int connectivity;

	public ImageBoundary(int connectivity) {
		this.connectivity = connectivity;
	}

	public HashSet<Point> findBoundaries(Image img) {
		HashSet<Point> boundary = new HashSet<Point>();
		for (int i = 0; i < img.getImage().width(); i++) {
			for(int j = 0; j < img.getImage().height(); j++) {
				if(isBoundary(img, i, j)) {
					boundary.add(new Point(i, j));
				}
			}
		}
		return boundary;
	}

	public HashSet<Point> findHole(Image img){
		HashSet<Point> hole = new HashSet<Point>();
		for (int i = 0; i < img.getImage().width(); i++) {
			for(int j = 0; j < img.getImage().height(); j++) {
				if(isHole(img, i, j)) {
					hole.add(new Point(i, j));
				}
			}
		}
		return hole;
	}

	protected boolean isBoundary(Image img, int x, int y) {
		if (isHole(img, x, y)) { 
			return false;
		}
		return(this.connectivity == 4 && fourConnectedPixelBoundary(img, x, y) ||
				this.connectivity == 8 && eightConnectedPixelBoundary(img, x, y));
	}

	private boolean fourConnectedPixelBoundary(Image img, int x, int y) {
		return isHole(img, x, y+1) || isHole(img, x, y-1) || isHole(img, x+1, y) || isHole(img, x-1, y);
	}

	private boolean eightConnectedPixelBoundary(Image img, int x, int y) {
		return isHole(img, x, y+1) || isHole(img, x, y-1) || isHole(img, x+1, y) || isHole(img, x-1, y)
				|| isHole(img, x-1, y-1) || isHole(img, x+1, y+1) || isHole(img, x-1, y+1) || isHole(img, x+1, y-1);
	}

	private boolean isHole(Image img, int x, int y) {
		return((x >= 0) && (y >= 0) && x < img.getImage().width() && y < img.getImage().height() && img.getImage().get(x, y)[0] == -1);
	}

}
