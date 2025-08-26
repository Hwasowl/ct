class Solution {
    public int solution(int n) {
        int v[] = new int[n];
        v[0]=0; v[1]=1; v[2]=1;
        for (int i = 3; i < n; i++) v[i] = (v[i-2] + v[i-1]) % 1234567;
        return (v[n-2] + v[n-1]) % 1234567;
    }
}