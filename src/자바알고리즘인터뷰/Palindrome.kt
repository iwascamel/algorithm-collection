package 자바알고리즘인터뷰

// 24.03.02
// 역시 재귀라서 시간에서 탈락
class Palindrome {
  fun checkRecursive(str: String): Boolean{
    var str = sanitizeString(str)
    str = str.replace(" ","")
    if(str.length <= 1) return true

    val firstChar = str[0]
    val lastChar = str[str.length-1]
    
    if(firstChar == lastChar){
      return checkRecursive(str.substring(1,str.length-1))
    }
    return false
  }
}

fun sanitizeString(input: String): String {
  val regex = Regex("[a-zA-Z0-9]+")
  return regex.findAll(input).joinToString(separator = "") { it.value }.lowercase()
}

fun main(){
  val palinDrome = Palindrome()
  
  val tc = "A man, a plan, a canal: Panama"
  
  val a = palinDrome.checkRecursive(tc)
  println(a)
}