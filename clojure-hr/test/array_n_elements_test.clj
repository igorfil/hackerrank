(ns array_n_elements_test
  (:require [clojure.test :refer :all])
  (:require [array_n_elements :refer :all]))

(deftest tst
  (is (= '() (gen-array 0)))
  (is (= '(0) (gen-array 1)))
  (is (= '(0 1 2) (gen-array 3)))
  )
