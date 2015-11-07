(ns uh.merger)

(defn deep-merge-with [f & vsx]
  "Deeply merges like `deep-merge`, but uses `f` to produce a value from the
  conflicting values for a key in multiple maps."
  (let [vs (filter some? vsx)]
    (if (every? map? vs)
      (apply merge-with (partial deep-merge-with f) vs)
      (apply f vs))))

(defn array-concat [& as]
  (into [] (flatten as)))

;; View
(defn simple-view [& bs]
  (let [bs' (map #(dissoc % :options :repr :choices) bs)
        deep-concat (partial deep-merge-with array-concat)
        cs (->> bs
                (map :choices)
                (filter some?)
                (map vals)
                (flatten)
                (apply deep-concat)
                )
        bs (conj bs' cs)]
    [:code (str (apply deep-concat bs))]))
