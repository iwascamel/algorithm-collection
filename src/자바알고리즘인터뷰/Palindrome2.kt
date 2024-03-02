package 자바알고리즘인터뷰

class Palindrome2 {
}

// 24.03.02
// 왼쪽, 오른쪽에서 가면서 pointer를 바꿔가면서 비교함
class Solution {
  fun isPalindrome(s: String): Boolean {
    var leftPointer = 0
    var rightPointer = s.length-1
    
    while(leftPointer < rightPointer){
      val leftPointerChar = s[leftPointer]
      val rightPointerChar = s[rightPointer]
      
      if(!leftPointerChar.isLetterOrDigit()){
        leftPointer++
        continue
      }else if(!rightPointerChar.isLetterOrDigit()){
        rightPointer--
        continue
      }else{
        if(leftPointerChar.lowercaseChar() != rightPointerChar.lowercaseChar()){
          return false
        }
        leftPointer++
        rightPointer--
      }
    }
    return true
  }
}

fun main(){
  val tc = "A man, a plan, a canal: Panama"
  
  val solution = Solution()
  print(solution.isPalindrome(tc)) 
}