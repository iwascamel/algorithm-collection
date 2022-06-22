# PrefixSum

> * [PrefixSum](PrefixSum.java)

* `prefixSum`은 기존 `arr` 보다 +1을 선언한다.
* 구간합을 구하고 싶은 구간의 end+1에서 start값을 빼준다.
  * ex) index 1~3구간의 합
    * `prefixSum[4] - prefixSum[1]`