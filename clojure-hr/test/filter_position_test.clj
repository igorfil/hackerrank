(ns filter_position_test
  (:require [clojure.test :refer :all])
  (:require [filter_position :refer :all]))

(deftest tst
  (is (= '() (remove-odd '())))
  (is (= '() (remove-odd '(1))))
  (is (= '(2) (remove-odd '(1 2 3))))
  (is (= '(2 4 6) (remove-odd '(1 2 3 4 5 6 7))))
  )
