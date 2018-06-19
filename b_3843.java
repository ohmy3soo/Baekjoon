import java.io.*;
import java.util.*;

public class b_3843 {
	static Point center;
	static double r;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			Point[] p = new Point[3];
			double[] ang = new double[3];

			StringTokenizer st = new StringTokenizer(in.readLine());
			String flag = st.nextToken();
			if(flag.equals("END"))
				break;
			p[0] = new Point(Double.parseDouble(flag), Double.parseDouble(st.nextToken()));
			for(int i=1; i<=2; i++) {
				st = new StringTokenizer(in.readLine());
				p[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
			}
			getCenter(p);
			for(int i=0; i<3; i++)
				ang[i] = getCos(p[i], p[(i+1)%3], center);

			OUTER:
			for(int step=3; ; step++) {
				double unit = 2 * Math.PI / step;
				for(int i=0; i<3; i++) {
					if(Math.abs(Math.round(ang[i]/unit)-ang[i]/unit) > 0.000001) break;

					if(i==2) {
						sb.append(step+"\n");
						break OUTER;
					}
				}
			}
		}
		System.out.println(sb);
	}


	public static double getCos(Point p1, Point p2, Point c) {
		double v1x = p1.x - c.x;
		double v1y = p1.y - c.y;
		double v2x = p2.x - c.x;
		double v2y = p2.y - c.y;

		Double innerProduct = v1x*v2x + v1y*v2y;
		Double s = Math.sqrt(v1x*v1x + v1y*v1y) * Math.sqrt(v2x*v2x + v2y*v2y);

		return Math.acos(innerProduct/s);
	}

	public static void getCenter(Point[] p) {
		double x1 = p[0].x;
		double x2 = p[1].x;
		double x3 = p[2].x;

		double y1 = p[0].y;
		double y2 = p[1].y;
		double y3 = p[2].y;

		double y = ((-2*x1+2*x2)*(-y2*y2+y3*y3-x2*x2+x3*x3) - (-2*x2+2*x3)*(-y1*y1+y2*y2-x1*x1+x2*x2)) /
				((-2*x2+2*x3)*(2*y1-2*y2)-(-2*x1+2*x2)*(2*y2-2*y3));
		double x = ((2*y1-2*y2)*y - y1*y1+y2*y2-x1*x1+x2*x2) / (-2*x1+2*x2);

		center = new Point(x, y);
		r = Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));
	}
}

class Point {
	double x;
	double y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
