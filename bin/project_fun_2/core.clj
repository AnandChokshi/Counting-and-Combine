(defn firstSeq
  "Function to find first Sequence"
  [v]
  (split-with #(= % (v 0)) v))  ; split vector in two seq according to first character in it

(defn seqDiv
  "Divide sequence in contiguous part"
  [v]
  (loop [result [] v v]
    (if (= (count v) 0) ; Check if v has anymore seq or not
      result
      (recur (conj result ((firstSeq v) 0)) (vec ((firstSeq v) 1))))))

(defn countOccur
  "Count occurrence of character in sequence"
  [v]
  (map 
    (fn [x y]
      (vec [x y])) (vec(map first (seqDiv v))) (vec(map count (seqDiv v)))))