package Programmers;

import java.util.*;
import java.util.stream.Collectors;

/*
귤 고르기
문제 설명
경화는 과수원에서 귤을 수확했습니다. 경화는 수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매하려고 합니다. 그런데 수확한 귤의 크기가 일정하지 않아 보기에 좋지 않다고 생각한 경화는 귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화하고 싶습니다.

예를 들어, 경화가 수확한 귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 합시다. 경화가 귤 6개를 판매하고 싶다면, 크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면, 귤의 크기의 종류가 2, 3, 5로 총 3가지가 되며 이때가 서로 다른 종류가 최소일 때입니다.

경화가 한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 매개변수로 주어집니다. 경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하도록 solution 함수를 작성해주세요.

제한사항
1 ≤ k ≤ tangerine의 길이 ≤ 100,000
1 ≤ tangerine의 원소 ≤ 10,000,000
입출력 예
k	tangerine	result
6	[1, 3, 2, 5, 4, 5, 2, 3]	3
4	[1, 3, 2, 5, 4, 5, 2, 3]	2
2	[1, 1, 1, 1, 2, 2, 2, 3]	1
입출력 예 설명
입출력 예 #1

본문에서 설명한 예시입니다.
입출력 예 #2

경화는 크기가 2인 귤 2개와 3인 귤 2개 또는 2인 귤 2개와 5인 귤 2개 또는 3인 귤 2개와 5인 귤 2개로 귤을 판매할 수 있습니다. 이때의 크기 종류는 2가지로 이 값이 최소가 됩니다.
입출력 예 #3

경화는 크기가 1인 귤 2개를 판매하거나 2인 귤 2개를 판매할 수 있습니다. 이때의 크기 종류는 1가지로, 이 값이 최소가 됩니다.
 */
/*
    tangerine의 요소들을 읽어들이고, tangerine이 가질수 있는 값의 최대값인 10000000 만큼의 배열을 만들어 tangerine 값에
    해당하는 index위치의 값을 +1씩 해주어 종류마다 개수를 저장한 배열을 만든다.
    그 배열을 내림차순으로 정렬하고 주어진 k개를 내림차순으로 정렬된 배열의 0에서의 값부터 빼나갔을 때 0보다 작아지는 경우
    해당 index가 최소한의 귤종류를 의미한다.
 */
class Solution {
    public static void main(String[] args) {;
        long n = 2;
        //int[] tangerine = {1,3,2,5,4,5,2,3};
        int[] tangerine = {1,1,1,1,2,2,2,3};
        System.out.println(solution(n,tangerine));
    }

    public static long solution(long n, int[] tangerine) {
        long answer = 0;
        Integer[] cnt_tangerine = new Integer[10000001];
        Arrays.fill(cnt_tangerine,0);

        for(int i=0;i<tangerine.length;i++) {
            int idx = tangerine[i];
            cnt_tangerine[idx] += 1;
        }

        //개수를 기준으로 내림차순 정렬
        Arrays.sort(cnt_tangerine,Collections.reverseOrder());

        int nextidx = 0;
        while(n > 0) {
            n -= cnt_tangerine[nextidx++];
        }

        answer = (long)nextidx;

        return answer;
    }
}
