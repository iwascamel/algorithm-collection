# 크루스칼

## 이론 정리(22.07.01)

> * [코드](../../연습/그래프이론/Kruskal.java)

* setParents, find, union 먼저 설정
  * 이 때 find에서 못 찾았을 때 자식값이 아니라 부모값을 함수에 넘겨야한다

<br/>

* edgeList들을 입력 받은 뒤 `Comparable` - `compareTo`를 이용해 정렬
  * union에서 이미 연결이 됐으면 `false`를 반환할 것이다.
  * 해당 간선의 값들을 더해줌