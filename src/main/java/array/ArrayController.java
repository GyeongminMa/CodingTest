package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class ArrayController {
    /**
     * 배열 개념
     * 배열 VS ArrayList
     * -> 배열은 처음 선언할 때 배열의 크기 결정, ArrayList는 크기가 동적임(ArrayList도 엄밀히 말하면 초기에 크기결정되지만 동적으로 변하는것 처럼 구현
     * 배열 선택시 고려
     * 1.할당할 수 있는 메모리 크기 확인
     * 2. 중간에 데이터 삽입이 많은지 확인 : 배열은 선형구조 다라서 중간이나 처음에 데이터를 빈번하게 삽입하면 시간 복잡도 높아짐
     */

    /**
     * 문제 1. 배열 정렬하기
     * 제약조건 : 정수 배열의 길이는 2이상 10의 5제곱 이하입니다. 정수 배열의 각 데이터 값은 -100,000 이상 100,000이하
     * 문제  : 정수 배열을 정렬해서 반환하는 solution()함수를 완성하세요
     */
    private static int[] solution(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    /**
     * 문제 2. 배열 제어하기
     * 제약조건 : 정수 배열의 길이는 2이상 1000 이하입니다. 정수 배열의 각 데이터 값은 -100,000 이상 100,000이하
     * 문제  : 정수 배열을 하나 받습니다. 배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환하는 solution()함수를 구현하세요
     * 입출력의 예
     * 입력 [4,2,2,1,3,4] -> 출력 [4,3,2,1]
     * 입력 [2,1,1,3,2,5,4,] -> 출력 [5,4,3,2,1]
     */
    private static int[] solution2(int[] arr){
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new); //중복값 제거
        Arrays.sort(result, Collections.reverseOrder()); //내림차순 정렬
        //int형 배열로 변경, 반환
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    /**
     * 문제 3. 두 개 뽑아서 더하기
     * 제약조건 : 정수 배열의 길이는 2이상 100 이하입니다. 정수 배열의 각 데이터 값은 0 이상 100이하
     * 문제  : 정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 이쓴 2개의 수를 뽑아 더해 만들 수 있는
     *         몯느 수를 배열에 오름차순으로 담아 반환하는 solution()함수를 완성하세요
     * 입출력의 예
     * 입력 [2,1,3,4,1] -> 출력 [2,3,4,5,6,7]
     * 입력 [5,0,2,7] -> 출력 [2,5,7,9,12]
     */
    private static int[] solution3(int[] numbers){
        HashSet<Integer> set = new HashSet<>(); //중복값 제거를 위한 해시셋 생성

        //1.두 수를 선택하는 모든 경우의 수
        for(int i = 0; i < numbers.length -1; i++){
            for(int j = 0; j <numbers.length; j++){
                //2.두 수 더한 결과를 해시셋에 저장
                set.add(numbers[i]+numbers[j]);
            }
        }
        //3.해시셋의 값을 오름차순으로 정렬 , int[] 형태의 배열로 반환
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();


        /*set? 객체를 중복해서 저장할 수 없음, 자동으로 중복 제거, 하나의 null만 저장 가능
        Hashset? Set 인터페이스에서 지원하는 구현 클래스 set의 성질 그대로 상속
        */

    }
}
