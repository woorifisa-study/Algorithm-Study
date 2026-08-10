import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Set<String> phoneSet = new HashSet<>();
        
        int len = phone_book.length; 
        
        for (String str : phone_book) {
            String phone = str.replace(" ", "");
            phoneSet.add(phone);
        }
        
        for (int i = 0; i < len; i++) {
            String curPhone = phone_book[i];
            
            for (int j = 0; j < curPhone.length(); j++) {
                String str = curPhone.substring(0, j + 1);
                
                if (!str.equals(curPhone) && phoneSet.contains(str)) return false;
            }
        }
        
        return true;
    }
}