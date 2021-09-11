package com.coder.leetcode

import scala.collection.mutable

object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    import scala.collection.mutable.Map
    val map: Map[Int, Int] = Map()
    for (i ← nums.indices) {
      val adder = target - nums(i)
      if (map.contains(adder)) {
        return Array(map(adder), i)
      }
      map += (nums(i) → i)
    }
    Array(0, 0)
  }


  def minTimeToType(word: String): Int = {
    var pre = 'a'
    var sum = 0
    word.foreach(ch => {
      if (ch < pre) {
        sum += Math.min(pre - ch, ch + 26 -pre);
      } else {
        sum += Math.min(ch - pre, pre + 26 - ch)
      }
      pre = ch
    })
    return sum + word.length
  }


//  def singleNonDuplicate(nums: Array[Int]): Int = {
//    nums.sortBy(num -> nums[i])
//    nums.foreach(num => {
//
//    })
//
//  }

  def main(args: Array[String]): Unit = {
    val solution = Solution

    solution.twoSum(Array[Int](3,4,5), 7)
  }
}
