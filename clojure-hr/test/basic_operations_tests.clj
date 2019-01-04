(ns basic_operations_tests
  (:require [clojure.test :refer :all])
  (:require [basic_operations :refer :all]))

(deftest abs-list-tests
  (is (= '(1) (abs-list '(1))))
  (is (= '(1) (abs-list '(-1))))
  (is (= '(1 2 3) (abs-list '(1 -2 -3))))
  )

(deftest odds-sum-tests
  (is (= 0 (odds-sum '())))
  (is (= 1 (odds-sum '(1))))
  (is (= 1 (odds-sum '(1 2))))
  (is (= 4 (odds-sum '(1 2 3))))
  (is (= 4 (odds-sum '(1 2 3 4 6 8))))
  )
