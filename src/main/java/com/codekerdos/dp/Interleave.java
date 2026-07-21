package com.codekerdos.dp;

class Interleave {

    public boolean isInterleave(String s1, String s2, String s3) {

        // Length check
        if(s3.length()!=s1.length()+s2.length()){
            return false;
        }

        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];

        return solve(0, 0, s1, s2, s3, dp);
    }

    private boolean solve(int index1,
                          int index2,
                          String s1,
                          String s2,
                          String s3, Boolean[][] dp) {

        if(index1 == s1.length() && index2 == s2.length()){
            return true;
        }

        int index3 = index1 + index2;
        boolean ans = false;

        if(dp[index1][index2]!=null){
            return dp[index1][index2];
        }

        if((index1<s1.length()) && s1.charAt(index1)==s3.charAt(index3)){
            ans |= solve(index1+1,index2,s1,s2,s3,dp);
        }
        if((index2<s2.length()) && s2.charAt(index2) == s3.charAt(index3)){
            ans |= solve(index1, index2+1, s1, s2, s3,dp);
        }

        dp[index1][index2] = ans;

        return ans;

    }
}
