    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    public class Main_1931 {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int[][] arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    arr[i][j] =Integer.parseInt(st.nextToken());
                }
            }

            Arrays.sort(arr, (o1, o2) -> {

                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            });

            int count = 0;
            int end = 0;

            for (int i = 0; i < N; i++) {
                if (end <= arr[i][0]) {
                    end = arr[i][1];
                    count++;
                }
            }

            System.out.println(count);

        }

    }
