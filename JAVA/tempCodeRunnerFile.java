import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Multiple {

    public static long solve(long A, long B) {
        if (B % A == 0) {
            return 0;
        }

        long minExtra = Long.MAX_VALUE;

        // Loop for a small number of extra chocolates for Alex (X)
        // A limit of 200,000 is chosen to cover cases where a small
        // number of chocolates for Alex is the optimal solution.
        for (long X = 0; X <= 200000; X++) {
            long newA = A + X;
            long Y = 0;
            if (B % newA != 0) {
                Y = newA - (B % newA);
            }
            minExtra = Math.min(minExtra, X + Y);
        }

        // Loop for a small multiple (k)
        // This covers cases where the optimal A+X is large.
        // A limit of 200,000 is chosen for the same reason.
        for (long k = 1; k <= 200000; k++) {
            // Calculate the smallest newA >= A such that B/newA is approximately k.
            // newA = ceil(B/k)
            long newA = (B + k - 1) / k; 
            
            // Only consider if the new A is not less than the original A.
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