class Solution {
    public String reversePrefix(String s, int k) {

        String res = s.substring(0,k);

        StringBuilder sc = new StringBuilder(res).reverse();
        sc.toString();

        return sc + s.substring(k);
        
    }
}