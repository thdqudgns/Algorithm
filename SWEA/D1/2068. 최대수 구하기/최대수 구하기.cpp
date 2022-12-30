#include<iostream>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
     
    cin>>T;
     
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int N, max = 0;
        
        for (int i = 0; i<10; i++) 
        {
            cin >> N;
            if (N > max) max = N;
        } 
        cout << '#' << test_case << ' ' << max << endl;

    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
