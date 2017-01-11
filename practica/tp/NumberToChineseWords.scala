package utils

object NumberToChineseWords {

  val digits = Map(0 -> "〇", 1 -> "壹", 2 -> "貳", 3 -> "參", 4 -> "肆", 5 -> "伍", 6 -> "陸", 7 -> "柒", 8 -> "捌", 9 -> "玖");
  val exponent = Map(1 -> "", 10 -> "拾", 100 -> "佰", 1000 -> "仟", 10000 -> "萬", 100000 -> "億", 1000000 -> "兆");

  def format(unit: Int, decimal: Int): String =
    if (unit <= 0) {
      ""
    } else {
      val internalDecimal = decimal * 10
      val number: Int = (unit % internalDecimal) / decimal

      if (number == 0) {
        format(unit - (unit % internalDecimal), internalDecimal)
      } else {
        format(unit - (unit % internalDecimal), internalDecimal) + digits.get(number) + exponent.get(decimal)
      }
    }

}

