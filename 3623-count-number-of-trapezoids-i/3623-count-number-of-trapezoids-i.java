class Solution {
    public int countTrapezoids(int[][] points) {
        
        long mod = 1000000007;

        Map<Integer,Integer> map = new HashMap<>();

        for(int[] p:points)
        {
            map.put(p[1], map.getOrDefault(p[1], 0) + 1);
        }

        long sumP = 0;
        long sumpSq = 0;


        for(int count:map.values()){
            if(count>=2){
                long P= (long)count*(count-1)/2;
                P%=mod;

                sumP = (sumP+P)%mod;
                sumpSq = (sumpSq+(P*P)%mod)%mod; 
            }
        }
        long result = (sumP*sumP)%mod;
        result =(result-sumpSq+mod)%mod;
        result=(result * inv2(mod)) % mod;

        return (int)result;
    }

    private long inv2(long mod)
    {
        return(mod+1)/2;
    

    }
}