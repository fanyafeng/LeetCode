package twosum

/**
 * Author： fanyafeng
 * Date： 2021/12/27 10:41
 * Email: fanyafeng@live.cn
 *
 * Given an array of integers, return indices of two numbers such that tey add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 *
 * Given nums = [2,7,11,15], target=9
 * Because nums[0] + nums[1] = 2+7=9
 * return[0,1]
 */
class TwoSum {

    fun calculateAndPrintResult(sourceList: List<Int>, target: Int): List<Int> {
        val resultList: HashSet<Int> = hashSetOf()
        val sourceListSize = sourceList.size
        sourceList.forEachIndexed { firstIndex, firstAddNumber ->
            (firstIndex + 1 until sourceListSize).forEach {
                val secondAddNumber = sourceList[it]
                val addResult = firstAddNumber + secondAddNumber
                if (addResult == target) {
                    resultList.add(firstIndex)
                    resultList.add(it)
                }
            }
        }
        return resultList.toMutableList()
    }

    fun calculateAndPrintResult2(sourceList: List<Int>, target: Int): List<Int> {
        val resultList: HashSet<Int> = hashSetOf()
        val storeMap = HashMap<Int, Int>()
        sourceList.forEachIndexed { index, i ->
            storeMap[i] = index
        }
        val size = sourceList.size
        (0 until size).forEach {
            val surplusNumber = target - sourceList[it]
            val targetIndex = storeMap.containsKey(surplusNumber)
            if (targetIndex && storeMap[surplusNumber] != it) {
                resultList.add(it)
                resultList.add(storeMap[surplusNumber] ?: 0)
            }
        }
        return resultList.toMutableList()
    }

    fun calculateAndPrintResult3(sourceList: List<Int>, target: Int): List<Int> {
        val size = sourceList.size
        val resultList: HashSet<Int> = hashSetOf()
        val storeMap = HashMap<Int, Int>()
        (0 until size).forEach {
            val surplusNumber = target - sourceList[it]
            if (storeMap.containsKey(surplusNumber)) {
                resultList.add(it)
                resultList.add(storeMap[surplusNumber] ?: 0)
                return@forEach
            }
            storeMap[sourceList[it]] = it
        }
        return resultList.toMutableList()
    }

}

fun main(args: Array<String>) {
    val sourceIntList: List<Int> = mutableListOf(2, 7, 11, 15)

    val target: Int = 26

    val twoSum = TwoSum()
    val result = twoSum.calculateAndPrintResult(sourceIntList, target)
    println(result)

    val result2 = twoSum.calculateAndPrintResult2(sourceIntList, target)
    println(result2)

    val result3 = twoSum.calculateAndPrintResult3(sourceIntList, target)
    println(result3)

}