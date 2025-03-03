package lotto.ui

import lotto.domain.LottoMatchReport
import lotto.domain.enums.LottoRank

object StatisticsView {
    fun printResult(lottoMatchReport: LottoMatchReport) {
        println("당첨 통계")
        println("---------")

        LottoRank.values()
            .reversed()
            .filter { it != LottoRank.NONE }
            .forEach { lottoRank -> println(resultString(lottoRank, lottoMatchReport.matchingCountBy(lottoRank))) }
        println("총 수익률은 ${lottoMatchReport.rateOfReturn}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    private fun resultString(lottoRank: LottoRank, lottoCount: Int): String {
        val sb = StringBuilder()
        sb.append("${lottoRank.matchingCount}개 일치")
        if (lottoRank == LottoRank.SECOND) { sb.append(", 보너스 볼 일치") }
        sb.append(" (${lottoRank.rewardPrice}원)- ${lottoCount}개")
        return sb.toString()
    }
}
