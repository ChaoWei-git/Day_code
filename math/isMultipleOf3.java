public class Solution {
    public int isMultipleOf3(int num) {
        if(num<0) num = -num;
        if(num==0) return 1;
        if(num==1) return 0;
        int even_count = 0;
        int odd_count = 0;
        while(num!=0){
            if((num&1)==1) even_count++;
            if((num&2)==2) odd_count++;
            num = num>>2;
        }
        return isMultipleOf3((int)Math.abs(even_count-odd_count));
    }
  }