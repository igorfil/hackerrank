(ns list-replication)

;; https://www.hackerrank.com/challenges/fp-list-replication/problem

(defn replicate-list [num lst]
  (mapcat (partial repeat num) (sort lst)))