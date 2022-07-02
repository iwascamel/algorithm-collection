# 1. 상황
```
arr = {2,3,3,3,3,4,5}
```

* 상한 index -> 5
* 하한 index -> 1

## 2. 생각법

* 이진탐색
  * `arr[mid] > target` 이면 내려가야함 (현재 구하는 값이 더 크므로)
    * `end=mid`
  * `arr[mid] < target` 이면 올라가야함 (현재 구하는 값이 더 작으므로)
    * `start=mid+1`

### 2-1) start+1, end-1?

* 어떤 거를 해줘도 상관없으나, `start+1`을 해주는 게 계산상 더 좋다.
  * `end-1` 을 해주면 나중에 +1을 더 해줘서 return 해줘야 한다.

> TIP : `start+1`을 해줘서 `end`로 넘어간다고 생각해주면 좀 더 쉽게 생각할 수 있다.

### 2-2) = 방향에 따라 upper, lower

* 상한은 target값과 같거나, 작으면 올라가야 한다.
  * 그래서 `arr[mid]<=target` 이면 `start=mid+1`을 해주어야 한다.
* 반대로 하한은 target과 같거나 크면 내려가야 한다.

## 3) 코드

* UpperBound

```java
if arr[mid] > target:
    end = mid
else
    start = mid+1
```

* LowerBound

```java
if arr[mid] >= target:
    end = mid
else
    start = mid+1
```

### 3-1) upperbound , lowerbound의 결과

> 참조문제
> * [수찾기BJ1920](.../../../../문제집/backjoon/수찾기BJ1920/Main.java)
> * [수찾기BJ1920](.../../../../문제집/backjoon/수찾기BJ1920/MainV2.java)
> 문제를 잘 못 읽었었다 ㅋ;

아래와 같이 문제를 읽었었다.
```
배열 2개가 주어진다.( A, B )
배열 B를 순회하며 B의 원소가 A안에 존재한다면 해당 수의 개수를 출력하라
```

* `uppderBound` - `lowerBound` 를 하면 target에 해당하는 수가 몇개나 있는 지 알 수 있다.
	*  이 때, 주의할 점이 있다.
	* `int[] arr = {1,2,3}` , `target=3` 이라고 해보자. 그러면 `upperBound = 2`, `lowerBound = 2` 가 나올 것이다.
		* 즉, 마지막 원소에 해당하는 값이 target값일 경우 0으로 counting이 된다.
		* 그러므로 `arr[N-1]` == `num` 일 경우 +1을 해줘야 한다.

* 해당하는 숫자가 없는 경우
	* 만약 `int[] arr = {3,4,5,7,8}` 이고 `target = 6` 이라면 결과값은 `lowerBound` , `upperBound` 둘다 큰 값에서 걸리는 위치인 3이 나온다 ( 7의 위치 )
	* 값이 없는 경우라면 upper와 lower 둘다 값이 같게 나온다.

<br/> 

* 해당하는 숫자가 있는 경우
	* `int[] arr = {1,2,3,3,3,4}` `target = 3`
		* `lowerBound` = 2
		* `upperBound` = 5
		* `lowerBound`의 경우 시작지점, `upperBound`의 경우 끝지점 +1이 나온다.

<br/>

* 해당하는 숫자를 찾고 싶은 경우(원래 알고 있던 이진탐색)
	* 이 때는 while 범위를 `start<=end` 로 해줘야 한다.
		* 이 때는 `end = mid - 1` , `start = mid+1` 로 설정해줘야 한다.
	* [참조](https://st-lab.tistory.com/261)

## 4 실습코드

> * [BinaryUpperLower](./BinaryUpperLowerBound.java)

<hr/>

## REF

* [st-lab 블로그](https://st-lab.tistory.com/267)
