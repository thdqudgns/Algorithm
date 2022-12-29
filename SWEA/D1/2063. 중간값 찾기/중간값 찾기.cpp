#include<iostream>
# include<algorithm>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int N;
    cin >> N;
     
    int score[N];
     
    for(int i=0; i < N; i++){
        cin >> score[i];  // 배열을 위에서 선언하고, for문에서 하나씩 넣어줄 수 있다.
    }
     
    // C++에서 정렬을 하기 위해서는 # include<algorithm> 를 선언해주어야 한다.
    sort(score, score+N);
     
    cout << score[N/2];
     
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}