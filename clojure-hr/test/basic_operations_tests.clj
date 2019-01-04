(ns basic_operations_tests
  (:require [clojure.test :refer :all])
  (:require [basic_operations :refer :all]))

(deftest abs-list-tests
  (is (= '(1) (abs-list '(1))))
  (is (= '(1) (abs-list '(-1))))
  (is (= '(1 2 3) (abs-list '(1 -2 -3))))
  )

