import java.util.*;

public class Yoda {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String N = in.nextLine(),
			   M = in.nextLine();

		int nLen = N.length(),
			mLen = M.length();
		int shorter = nLen < mLen ? nLen : mLen;

		StringBuilder newN = new StringBuilder(),
					  newM = new StringBuilder();
		int i;
		for(i = 0; i < shorter; i++) {
			char nc = N.charAt(nLen - i - 1),
				 mc = M.charAt(mLen - i - 1);
			if (nc == mc) {
				newN.append(nc);
				newM.append(mc);
				continue;
			} else if (nc > mc) {
				newN.append(nc);
			} else {
				newM.append(mc);
			}
		}

		if (nLen > mLen) {
			while (i++ < N.length())
				newN.append(N.charAt(nLen - i));
		} else if (nLen < mLen) {
			while (i++ < M.length())
				newM.append(M.charAt(mLen - i));
		}

		if (newN.length() > 0)
			System.out.println(Integer.parseInt(newN.reverse().toString()));
		else
			System.out.println("YODA");

		if (newM.length() > 0)
			System.out.println(Integer.parseInt(newM.reverse().toString()));
		else
			System.out.println("YODA");
	}
}

