(ns basic_operations)

;; some basic functions. Not worth creating separate file for each

;; https://www.hackerrank.com/challenges/fp-update-list/problem
(defn abs-list [lst]
  (map #(max % (- %)) lst))  (map #(max % (- %)) lst))