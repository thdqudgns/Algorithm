#include<iostream>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int a;
    cin >> a;
    int result = 0;
     
    while (a!=0) {
        result += a%10;
        a /= 10;
    }
     
    cout << result;
     
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}