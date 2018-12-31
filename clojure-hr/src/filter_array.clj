(ns filter_array)

;; https://www.hackerrank.com/challenges/fp-filter-array/problem

(defn filter-array [delim lst]
  (filter #(< % delim) lst))