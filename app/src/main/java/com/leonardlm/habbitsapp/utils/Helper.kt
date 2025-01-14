package com.leonardlm.habbitsapp.utils

class Helper {
    companion object {
        fun splitTextWithAsteriskIdentification(text: String): List<Pair<String, Boolean>> {
            val regex = "\\*(.*?)\\*".toRegex()
            val parts = mutableListOf<Pair<String, Boolean>>()
            var lastIndex = 0

            regex.findAll(text).forEach { matchResult ->
                val startIndex = matchResult.range.first
                if (startIndex > lastIndex) {
                    parts.add(Pair(text.substring(lastIndex, startIndex), false))
                }
                parts.add(Pair(matchResult.groupValues[1], true))
                lastIndex = matchResult.range.last + 1
            }

            if (lastIndex < text.length) {
                parts.add(Pair(text.substring(lastIndex), false))
            }

            return parts
        }
    }
}