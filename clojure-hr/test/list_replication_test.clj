(ns list-replication-test
  (:require [clojure.test :refer :all])
  (:require [list-replication :refer :all]))


(deftest a-test
  (is (= '(1 1) (replicate-list 2 '(1))))
  (is (= '(1 1 1) (replicate-list 3 '(1))))
  (is (= '(1 1 2 2 3 3) (replicate-list 2 '(1 2 3)))))
