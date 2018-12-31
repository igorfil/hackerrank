(ns filter_array_test
  (:require [clojure.test :refer :all])
  (:require [filter_array :refer :all]))

(deftest tst
  (is (= '(1) (filter-array 2 '(1 2 3 4))))
  (is (= '(1 2 3) (filter-array 4 '(1 2 3 4 5 6))))
  (is (= '(1 2 3) (filter-array 5 '(1 2 3)))))
