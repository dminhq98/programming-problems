import java.util.*;

public class Logo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nCases = Integer.parseInt(in.nextLine());
		while(nCases--) {
			int nCommands = Integer.parseInt(in.nextLine());
			while(nCommands--) {
				String[] line = in.nextLine().trim().split(" ");
				String cmd = line[0];
				int val = Integer.parseInt(line[1]);
				float heading = 0.0,
					  x = 0.0,
					  y = 0.0;
				if (cmd.equals("fd")) {
					
