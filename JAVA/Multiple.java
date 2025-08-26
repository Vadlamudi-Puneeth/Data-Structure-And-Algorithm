import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Multiple {

    public static long solve(long A, long B) {
        if (B % A == 0) {
            return 0;
        }

        long minExtra = Long.MAX_VALUE;

        for (long X = 0; X <= 200000; X++) {
            long newA = A + X;
            long Y = 0;
            if (B % newA != 0) {
                Y = newA - (B % newA);
            }
            minExtra = Math.min(minExtra, X + Y);
        }

        for (long k = 1; k <= 200000; k++) {
            long newA = (B + k - 1) / k; 
            
            if (newA >= A) {
                long X = newA - A;
                long Y = 0;
                if (B % newA != 0) {
                    Y = newA - (B % newA);
                }
                minExtra = Math.min(minExtra, X + Y);
            }
        }
        
        return minExtra;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        System.out.println(solve(A, B));
    }
}