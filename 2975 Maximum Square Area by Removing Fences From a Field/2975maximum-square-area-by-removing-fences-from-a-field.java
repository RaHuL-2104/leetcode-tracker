class Solution {
    static final int MOD = 1000000007;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] H = new int[hFences.length + 2];
        int[] V = new int[vFences.length + 2];
        H[0] = 1;
        H[H.length - 1] = m;
        for(int i = 0; i < hFences.length; i++){
            H[i + 1] = hFences[i];
        }
        V[0] = 1;
        V[V.length - 1] = n;
        for(int i = 0; i < vFences.length; i++){
            V[i + 1] = vFences[i];
        }

        Arrays.sort(H);
        Arrays.sort(V);

        Set<Integer> hDiff = new HashSet<>();
        for(int i = 0; i < H.length; i++){
            for(int j = i + 1; j < H.length; j++){
                hDiff.add(H[j] - H[i]);
            }
        }
        int maxSide = 0;
        for(int i = 0; i < V.length; i++){
            for(int j = i + 1; j < V.length; j++){
                int diff = V[j] - V[i];
                if(hDiff.contains(diff)){
                    maxSide = Math.max(maxSide, diff);
                }
            }
        }
        if(maxSide == 0) return -1;
        return (int)((1L * maxSide * maxSide) % MOD);
    }
}