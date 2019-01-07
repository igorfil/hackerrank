(use ['clojure.string :only '(split)])

; https://www.hackerrank.com/challenges/lambda-march-compute-the-perimeter-of-a-polygon

(defn str-to-ints
  [string]
  (map #(Integer/parseInt %)
       (split string #" ")))

(defn get-sides [coords]
  (conj (partition 2 1 coords) (list (first coords) (last coords))))

(defn side-length [side]
  (let [
        a (first side)
        b (second side)]
    (Math/sqrt (+ (Math/pow (- (first a) (first b)) 2) (Math/pow (- (second a) (second b)) 2)))
    )
  )

(defn read-input
  []
  (doall (line-seq (java.io.BufferedReader. *in*))))

(->>
  (read-input)
  (rest)
  (map str-to-ints)
  (get-sides)
  (map side-length)
  (reduce +)
  (println)
  )
