def solution(s):
    count = 0
    zeroCount = 0
    
    while s != "1":
        zeroCount +=s.count('0')
        
        s = s.replace('0', '')
        s = bin(len(s))[2:] # 2진수 변환
        
        count +=1
        
    return [count, zeroCount]