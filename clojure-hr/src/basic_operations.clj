(ns basic_operations)

;; some basic functions. Not worth creating separate file for each

;; https://www.hackerrank.com/challenges/fp-update-list/problem
(defn abs-list [lst]
  (map #(max % (- %)) lst))

;; https://www.hackerrank.com/challenges/fp-sum-of-odd-elements/problem
(defn odds-sum [lst]
  (reduce + 0 (filter odd? lst)))