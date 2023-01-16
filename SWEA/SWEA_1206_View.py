
def two_max(A, left, right):
    B=[]
    global temp_Max
    # M = 가장 큰 값, m = 두 번째로 큰 값
    # 1. base case
    if left == right: # 범위에 해당하는 값이 하나 뿐일 때
        return A[left], None
    
    mid = (left+right)//2
    # 2. 재귀적으로 left ... mid에 대해 가장 큰 값 L1과 두 번째로 큰 값 L2 계산 
    # 3. 재귀적으로 mid+1 ... right에 대해 가장 큰 값 R1과 두 번째로 큰 값 R2 계산
    # 4. L1, L2, R1, R2로부터 left ... right에 대한 M, m을 계산 
    
    L1,L2 = two_max(A, left, mid)
    R1,R2 = two_max(A, mid+1, right)
    
    B.append(L1)
    if L2 != None:
        B.append(L2)
    B.append(R1)
    if R2 != None:
        B.append(R2)
    
    left = 0
    right = len(B)-1
    while(left!=right):
        if B[left]<B[right]:
            if B[left]>temp_Max:
                temp_Max=B[left]
            left+=1
        else:
            if B[right]>temp_Max:
                temp_Max=B[right]
            right-=1
                
    if temp_Max<B[left]:
        M=B[left]
        m=temp_Max
    else:
        M=temp_Max
        m=B[left]
        
    return M, m


T = 10
temp_Max = -1

for testcase in range(1,T+1):
    N = int(input())
    buildings = list(map(int, input().split()))
    answer = 0

    for i in range(2,len(buildings)-2):
        temp_Max = -1
        tmp = []
        tmp = buildings[i-2:i+3]
        M, m = two_max(tmp,0,len(tmp)-1)
        if M==buildings[i]:
            answer+=M-m
    print("#"+str(testcase)+" "+str(answer))