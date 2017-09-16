import java.util.*;

public class Vacuumba {
	static double adjustHeading(double old, double delta) {
		double deltaRad = Math.toRadians(delta);
		return (old + deltaRad) % (2*Math.PI);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int nCases = in.nextInt();
		while (nCases-- > 0) {
			int m = in.nextInt();
			// The robot starts at the origin,
			// facing in the positive Y direction.
			double heading = Math.PI/2;
			double x = 0.0,
				   y = 0.0;
			for(int i = 0; i < m; i++) {
				double angle = in.nextDouble(),
					   distance = in.nextDouble();
				heading = adjustHeading(heading, angle);
				y += (Math.sin(heading) * distance);
				x += (Math.cos(heading) * distance);
			}
			System.out.printf("%f %f\n", x, y);
		}
	}
}

