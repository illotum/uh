(ns uh.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(defn indexed [s]
  "Returns a lazy sequence of [index, item] pairs, where items come
  from 's' and indexes count up from zero.
  (indexed '(a b c d))  =>  ([0 a] [1 b] [2 c] [3 d])"
  (map vector (iterate inc 0) s))

(re-frame/register-sub
 :debug
 (fn [db _]
   (reaction (dissoc @db :index))))

(re-frame/register-sub
 :picked-id
 (fn [db [_ & rst]]
   (reaction (get-in @db (into [:picked-id] rst)))))

(re-frame/register-sub
 :index-vec
 (fn [db [_ kind]]
   (reaction (vec (get-in @db [:index kind])))))

(re-frame/register-sub
 :options
 (fn [db [_ kind]]
   (reaction (indexed (get-in @db [kind :options])))))
