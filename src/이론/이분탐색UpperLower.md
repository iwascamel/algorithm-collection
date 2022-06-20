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

* 어떤 거를 해줘도 상관없으나, end를 기준으로 할거면 `start+1`을 해줘야 한다.

### 2-2) = 방향에 따라 upper, lower

* 상한은 target값과 같거나, 작으면 올라가야 한다.
  * 그래서 `arr[mid]<=target` 이면 `start=mid+1`을 해주어야 한다.
* 반대로 하한은 target과 같거나 크면 내려가야 한다.

### 2-3) 코드

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

### 3 실습코드

> * [BinaryUpperLower](./BinaryUpperLowerBound.java)

<hr/>

## REF

* [st-lab 블로그](https://st-lab.tistory.com/267)