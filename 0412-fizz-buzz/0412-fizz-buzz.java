class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> fizz = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5==0){
                fizz.add("FizzBuzz");
            }
            else if(i%5==0){
                fizz.add("Buzz");
            }
            else if(i%3==0){
                fizz.add("Fizz");
            }
            else{
                fizz.add(String.valueOf(i));
            }
            
        }
        return fizz;
    }
}