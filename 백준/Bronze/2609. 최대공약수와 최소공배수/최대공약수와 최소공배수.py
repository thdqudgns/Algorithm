a,b = map(int,input().split(' '))
aa,bb = a,b

while bb!=0:    # 호제법(유클리드 알고리즘)
    aa = aa%bb
    aa,bb = bb,aa   # bb=0일 때 aa는 최대공약수가 된다.

L = aa
l = a*b//aa

print(L)
print(l)
