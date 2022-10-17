import sys
N, M = map(int, sys.stdin.readline().rstrip().split())
set_A = set(map(int, sys.stdin.readline().rstrip().split()))
set_B = set(map(int, sys.stdin.readline().rstrip().split()))
print(len(set_A ^ set_B))