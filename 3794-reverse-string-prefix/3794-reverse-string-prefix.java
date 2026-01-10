class Solution {
    public String reversePrefix(String s, int k) {

        String res = s.substring(0,k);

        String sc = new StringBuilder(res).reverse().toString();

        return sc + s.substring(k);
        
    }
}