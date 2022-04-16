const val SECONDS_IN_MINUTE = 60U
const val SECONDS_IN_HOUR = 3600U
const val SECONDS_IN_DAY = 86400U

enum class Times {
    MINUTES, HOURS
}

fun main() {
    val secondsAgo = 61U
    println(agoToText(secondsAgo))
}

fun agoToText(secondsAgo: UInt) = when (secondsAgo) {
    in 0U..SECONDS_IN_MINUTE -> "только что"
    in SECONDS_IN_MINUTE + 1U..SECONDS_IN_HOUR -> {
        "${secondsAgo / SECONDS_IN_MINUTE} ${
            correctTimeStrIfValue(
                secondsAgo / SECONDS_IN_MINUTE,
                Times.MINUTES
            )
        } назад"
    }
    in SECONDS_IN_HOUR + 1U..SECONDS_IN_DAY -> {
        "${secondsAgo / SECONDS_IN_HOUR} ${
            correctTimeStrIfValue(
                secondsAgo / SECONDS_IN_HOUR,
                Times.HOURS
            )
        } назад"
    }
    in SECONDS_IN_DAY + 1U..2U * SECONDS_IN_DAY -> "сегодня"
    in 2U * SECONDS_IN_DAY + 1U..3U * SECONDS_IN_DAY -> "вчера"
    else -> {
        "давно"
    }
}

fun correctTimeStrIfValue(value: UInt, times: Times) = when (value % 10U) {
    1U -> {
        when (times) {
            Times.MINUTES -> "минуту"
            Times.HOURS -> "час"
        }
    }
    in 2U..4U -> {
        when (times) {
            Times.MINUTES -> "минуты"
            Times.HOURS -> "часа"
        }
    }
    else -> {
        when (times) {
            Times.MINUTES -> "минут"
            Times.HOURS -> "часов"
        }
    }
}