(ns filter_position)

;; https://www.hackerrank.com/challenges/fp-filter-positions-in-a-list/problem

(defn remove-odd [lst]
  (take-nth 2 (rest lst)))