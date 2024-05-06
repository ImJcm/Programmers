package Programmers;

import java.util.Arrays;

/*
k진수에서 소수 개수 구하기
제출 내역
문제 설명
문제 설명
양의 정수 n이 주어집니다. 이 숫자를 k진수로 바꿨을 때, 변환된 수 안에 아래 조건에 맞는 소수(Prime number)가 몇 개인지 알아보려 합니다.

0P0처럼 소수 양쪽에 0이 있는 경우
P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
P처럼 소수 양쪽에 아무것도 없는 경우
단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.
예를 들어, 101은 P가 될 수 없습니다.
예를 들어, 437674을 3진수로 바꾸면 211020101011입니다. 여기서 찾을 수 있는 조건에 맞는 소수는 왼쪽부터 순서대로 211, 2, 11이 있으며, 총 3개입니다. (211, 2, 11을 k진법으로 보았을 때가 아닌, 10진법으로 보았을 때 소수여야 한다는 점에 주의합니다.) 211은 P0 형태에서 찾을 수 있으며, 2는 0P0에서, 11은 0P에서 찾을 수 있습니다.

정수 n과 k가 매개변수로 주어집니다. n을 k진수로 바꿨을 때, 변환된 수 안에서 찾을 수 있는 위 조건에 맞는 소수의 개수를 return 하도록 solution 함수를 완성해 주세요.

제한사항
1 ≤ n ≤ 1,000,000
3 ≤ k ≤ 10
입출력 예
n	k	result
437674	3	3
110011	10	2
 */
/*
에라토스테네스의 체를 이용하여 소수를 판별할 배열을 생성하는 과정에서 배열의 최대 길이가 1,000,000 -> 3bit -> 1212210202001이므로 int[1212210202001]로 생성되어야 하는데
이는 배열의 허용 범위를 넘어가므로 에라스토테네스의 체를 이용한
 */
class Solution {
    static int[] sieve;
    public static int solution(int n, int k) {
        int count = 0;

        eratos(n,k);

        String[] parr = Integer.toString(n,k).split("0");

        for(String p : parr) {
            if(p.isEmpty() || p.isBlank()) continue;

            if(sieve[Integer.parseInt(p)] == 0) {
                count++;
            }
        }

        return count;
    }

    static void eratos(int n, int k) {
        //1000000 -> 3bit -> 1212210202001
        //int max_range = Integer.parseInt(Integer.toString(n,k));
        int max_range = Integer.MAX_VALUE - 8;
        sieve = new int[max_range];

        Arrays.fill(sieve,0);

        sieve[1] = 1;

        for(int i=2;i<max_range;i++) {
            if(sieve[i] != 0) continue;

            for(int j=2*i;j<max_range;j += i) {
                sieve[j] = 1;
            }
        }
    }

    public static void main(String[] args) {
        //int n = 437674;
        //int n = 883438;
        int n = 1000000;
        int k = 3;
        System.out.println(solution(n,k));
    }
}