#include<iostream>
#include<algorithm>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
     
    cin>>T;
     
    /*
       여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
    */
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int a[10]; 
        // 배열을 정렬해주는 방식
        for(int i = 0; i<10; i++){
            cin >> a[i];
        } 
         
        sort(a, a+10);
         
        cout << '#' << test_case << " " << a[9] << '\n';
 
 
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
