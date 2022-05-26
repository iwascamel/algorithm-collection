## 초기 생각했던 아이디어

```java
for i <- loop 0 to N
if !queue.contains(arr[i]):
	queue.offer(arr[i])
	isIn[arr[i]] = true
else
	if i == N-1:
		cnt++
	else
		pointer = i+1
		while pointer < N:
			if check() == 1:
				kickOutNotChecked()
				getInThisPointer()
				isIn[arr[kickedOutIndex]] = false
				isIn[arr[pointer]] = true
				cnt++
				continue first loop
		pushLastNumInNotChecked() 
		cnt ++
```