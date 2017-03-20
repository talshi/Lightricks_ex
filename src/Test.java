import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.opencv.core.Point;

public class Test {
	public static void main(String[] args) {

		// get parameters
		Scanner s = new Scanner(System.in);
		System.out.println("Please insert the following parameters:");
		int z = getZ(s);
		float epsilon = getEpsilon(s);
		int pixelConnectivity = getPixelConnectivityMethod(s);

		// create Mock image with random floats between [0,1] and a hole inside it
		Image img = new Image();
		img.createMockImage(10, 10);
		
		System.out.println(img.getDumpedImage());
		System.out.println();
		
		// init weight function
		Weight weight = new Weight(z, epsilon);
		
		// init the rest classes
		ImageBoundary ib = new ImageBoundary(pixelConnectivity);
		HoleFilling hf = new HoleFilling();
		
		// find boundaries and hole
		HashSet<Point> boundaries = ib.findBoundaries(img);
		HashSet<Point> hole = ib.findHole(img);
		
		// fill the hole according to the weight function
		Image filledImg = hf.fill(img, boundaries, hole, weight);
		
		System.out.println(filledImg.getDumpedImage());
		System.out.println();

	}

	private static int getZ(Scanner s) {
		System.out.println("Insert z: ");
		int z = 1;

		try {
			z = s.nextInt();
			if(z > 0) {
				return z;
			} else {
				System.out.println("Invalid parameter. Parameter set to default (1)");
				z = 1;
			}
		} catch(InputMismatchException e) {
			System.out.println("Invalid parameter. Parameter set to default (1)");
			z = 1;
		}

		return z;

	}

	private static float getEpsilon(Scanner s) {
		System.out.println("Insert epsilon: ");
		float eps = 0.0001f;

		try {
			eps = s.nextFloat();
			if(eps > 0) {
				return eps;
			} else {
				System.out.println("Invalid parameter. Parameter set to default (0.0001)");
				eps = 0.0001f;
			}
		} catch(InputMismatchException e) {
			System.out.println("Invalid parameter. Parameter set to default (0.0001)");
			eps = 0.0001f;
		}

		return eps;
	}
	
	private static int getPixelConnectivityMethod(Scanner s) {
		System.out.println("Insert pixel connectivity method (4 or 8): ");
		int pixelConnectivity = 4;

		try {
			pixelConnectivity = s.nextInt();
			if(pixelConnectivity == 4 || pixelConnectivity == 8) {
				return pixelConnectivity;
			} else {
				System.out.println("Invalid parameter. Parameter set to default (4)");
				pixelConnectivity = 4;
			}
		} catch(InputMismatchException e) {
			System.out.println("Invalid parameter. Parameter set to default (4)");
			pixelConnectivity = 1;
		}

		return pixelConnectivity;
	}
}
