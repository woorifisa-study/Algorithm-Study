class Solution {
    
    static int sign = 0;   // 가입자
    static int amount = 0; // 판매액
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        // 각 이모티콘의 할인율 저장
        int[] discountRate = new int[emoticons.length]; 
        
        setDiscountRate(0, users, emoticons, discountRate);
        
        answer[0] = sign;
        answer[1] = amount;
        
        return answer;
    }
    
    void setDiscountRate(int curidx, int[][] users, int[] emoticons, int[] discountRate){
        
        // 이모티콘 모두 할인율이 정해졌다면 계산하기
        if(curidx == emoticons.length){
            calculate(users, emoticons, discountRate);
            return;
        }
        
        for(int i = 10; i <=40; i+=10){
            discountRate[curidx] = i;
            setDiscountRate(curidx+1, users, emoticons, discountRate);
        }
    }
    
    void calculate(int[][] users, int[] emoticons, int[] discountRate){
        
        int emoticonPlus = 0;
        int emoticonPrice = 0;
        
        for(int[] user: users){
            int price = 0;
            
            for(int i = 0; i < emoticons.length; i++){
                if(discountRate[i] >= user[0]){
                    price += (emoticons[i] * (100-discountRate[i])) / 100;
                }
            }
            
            if(price >= user[1]){
                emoticonPlus++;
            } else{
                emoticonPrice += price;
            }
        }
        
        if(emoticonPlus > sign){
            sign = emoticonPlus;
            amount = emoticonPrice;
        }
        else if(emoticonPlus == sign && amount <= emoticonPrice){
            amount = emoticonPrice;
        }
    }
}