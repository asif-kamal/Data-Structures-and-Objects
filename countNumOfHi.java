public class countNumOfHi {

  public static int countHi(String str) {
    if (str.length() <= 1) {
      return 0;
    } else if (str.substring(0, 2).equals("hi")) {
      return 1 + countHi(str.substring(2));
    } else {
      return countHi(str.substring(1));
    }
  }

  public static void main(String[] args) {
    String str = "ihihihihih";

    System.out.println(countHi(str));
  }
}
//CodingBat problems
