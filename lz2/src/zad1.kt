fun agoToText(seconds: Int): String {
    return when {
        seconds <= 60 -> "был(а) только что"
        seconds <= 60 * 60 -> "был(а) ${minutesToText(seconds / 60)}"
        seconds <= 24 * 60 * 60 -> "был(а) ${hoursToText(seconds / 3600)}"
        seconds <= 2 * 24 * 60 * 60 -> "был(а) вчера"
        seconds <= 3 * 24 * 60 * 60 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}
fun minutesToText(minutes: Int): String {
    val lastTwo = minutes % 100
    val lastOne = minutes % 10

    return when {
        lastTwo in 11..14 -> "$minutes минут назад"
        lastOne == 1 -> "$minutes минуту назад"
        lastOne in 2..4 -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}
fun hoursToText(hours: Int): String {
    val lastTwo = hours % 100
    val lastOne = hours % 10

    return when {
        lastTwo in 11..14 -> "$hours часов назад"
        lastOne == 1 -> "$hours час назад"
        lastOne in 2..4 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}
fun main() {
    println(agoToText(30))
    println(agoToText(300))
    println(agoToText(7200))
    println(agoToText(90000))
    println(agoToText(200000))
    println(agoToText(400000))
}