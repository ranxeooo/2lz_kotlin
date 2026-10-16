fun calculateCommission(
    cardType: String = "VK Pay",
    previousTransfers: Int = 0,
    amount: Int
): Double {

    return when (cardType) {
        "Mastercard", "Maestro" -> {
            if (previousTransfers + amount <= 75000) {
                0.0
            } else {
                amount * 0.006 + 20
            }
        }

        "Visa", "Мир" -> {
            val commission = amount * 0.0075
            if (commission < 35) {
                35.0
            } else {
                commission
            }
        }
        "VK Pay" -> 0.0
        else -> 0.0
    }
}
fun main() {
    println(calculateCommission(amount = 1000))
    println(calculateCommission(cardType = "Mastercard", previousTransfers = 5000, amount = 2000))
    println(calculateCommission(cardType = "Visa", amount = 10000))
}