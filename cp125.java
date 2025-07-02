import java.io.*;
public class cp125 {
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder out = new StringBuilder();
    int tc = Integer.parseInt(br.readLine());
    while(tc-- > 0){
      String[] nk = br.readLine().split(" ");
      int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
      char[] s = br.readLine().toCharArray();

      // inside each test:
int[] P = new int[n+1];
for(int i=0;i<n;i++) P[i+1]=P[i]+(s[i]=='1'?1:0);
int tot = P[n];
if(tot<=k){
    out.append("Alice\n");
    continue;
}
int maxIn=0;
for(int i=0;i+k<=n;i++){
    int in = P[i+k]-P[i];
    if(in>maxIn) maxIn=in;
}
int minOutside = tot - maxIn;
if(minOutside<=k){
    out.append("Alice\n");
} else {
    out.append("Bob\n");
}
    }
    System.out.print(out);
  }
}