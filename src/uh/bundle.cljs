;; vim:fdm=syntax:foldlevel=0
(ns uh.bundle
  (:require [uh.index :as index]))

;; Helpers
(defn v->kw [e]
  (keyword (.-target.value e)))

(defn v->int [e]
  (js/parseInt (.-target.value e)))

(defn indexed [s]
  "Returns a lazy sequence of [index, item] pairs, where items come
  from 's' and indexes count up from zero.
  (indexed '(a b c d))  =>  ([0 a] [1 b] [2 c] [3 d])"
  (map vector (iterate inc 0) s))

;; Widgets
(defn select= [state src]
  [:select {:default-value :none
            :on-change #(reset! state ((v->kw %) src))}
   (for [[k v] src]
       ^{:key k} [:option {:value k}
                  (:repr v)])])

(defn radio= [state ix [id [kw options]]]
  ^{:key (str options)}
  [:div.radio
   (doall
     (for [[k v] (indexed options)]
       ^{:key k} [:label
                  [:input {:value k
                           :name (str options)
                           :type :radio
                           :on-change #(swap! state assoc-in
                                              [:choices id kw] v)}]
                  (get-in ix [kw v :repr])]))])

;; View
(defn view [kw ix state]
  (let [bundle-ix (kw ix)
        radio= (partial radio= state ix)]
    (fn []
      [:div.one-third.column
        (select= state bundle-ix)
        (doall (map #(radio= %) (indexed (:options @state))))
        ])))
