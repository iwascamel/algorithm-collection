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

* 해당하는 숫자가 없는 경우
	* 만약 `int[] arr = {3,4,5,7,8}` 이고 `target = 6` 이라면 결과값은 `lowerBound` , `upperBound` 둘다 큰 값에서 걸리는 위치인 3이 나온다 ( 7의 위치 )
* ![[Pasted image 20220701175447.png]]

## 4 실습코드

> * [BinaryUpperLower](./BinaryUpperLowerBound.java)

<hr/>

## REF

* [st-lab 블로그](https://st-lab.tistory.com/267)