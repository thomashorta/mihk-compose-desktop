package util

import java.text.SimpleDateFormat
import java.util.*

fun formatTimer(timeMillis: Long) = SimpleDateFormat("mm:ss").format(Date(timeMillis))