(ns reverse_list_test
  (:require [clojure.test :refer :all])
  (:require [reverse_list :refer :all]))

(deftest name
  (is (= '(1) (reverse-list '(1))))
  (is (= '(2 1) (reverse-list '(1 2))))
  )
