class Solution {
    public int countTrapezoids(int[][] points) {
        
        int n = points.length;
        double INF = 1e9+7;

      //slope -> list of imtercepts
        Map<Double, List<Double>> slopeToIntercept = new HashMap<>();

      //midPoint -> list of slopes
       Map<Integer, List<Double>> midPointToSlope   = new HashMap<>(); 
       int ans = 0;

       //step 1 built all line segments and compute slopes + intercepts

       for(int i=0;i<n;i++)
       {
        int x1 = points[i][0];
        int y1 = points[i][1];

        for(int j =i+1;j<n;j++)
        {
            int x2 = points[j][0];
            int y2 = points[j][1];
            int dx = x1-x2;
            int dy = y1-y2;

            double slope;
            double intercept;


            //vertical line

            if(x1==x2)
            {
                slope = INF;
                intercept = x1;   // x= constant

            }
            else{
                slope = 1.0*(y2-y1)/(x2-x1);

                //formula

                intercept = 1.0*(y1*dx-x1*dy)/dx;  
            }

            //normalize -0.0 to 0.0

            if(slope == -0.0)
            {
                slope = 0.0;
            }
            if(intercept== -0.0){
                intercept = 0.0;
            }

            //unique midpoint key

            int midKey = (x1+x2)*10000 +(y1+y2);

            //store slope and intercept in the map
            slopeToIntercept.computeIfAbsent(slope,key->new ArrayList<>()).add(intercept);
            midPointToSlope.computeIfAbsent(midKey,key->new ArrayList<>()).add(slope);
        }

       } 
//step 2: count all pairs of parallel segment

   for(List<Double> intercepts : slopeToIntercept.values())
   {
    if(intercepts.size() == 1) continue; 
    Map<Double,Integer> freq = new HashMap<>();
    for(double b : intercepts)
    {
        freq.put(b,freq.getOrDefault(b,0)+1);

    }

    int prefix =0;
    for(int count : freq.values())
    {
        ans += (prefix*count);
        prefix+=count;
    }
   }



   //step 3: subtract the invalid pairs(segment sharing mid point)

   for(List<Double> slopes :  midPointToSlope.values())
   {
    if(slopes.size() == 1) continue; 
    Map<Double,Integer> freq = new HashMap<>();
    for(double k : slopes)
    {
        freq.put(k,freq.getOrDefault(k,0)+1);

    }

    int prefix = 0;
    for(int count : freq.values())
    {
        ans -= (prefix*count);
        prefix += count;
    }
   }
   return ans;
    }
}