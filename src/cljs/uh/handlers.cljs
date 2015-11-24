(ns uh.handlers
    (:require [re-frame.core :as re-frame]
              [schema.core :as s :include-macros true]
              [uh.db :as db]))

(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   (s/validate db/AppDB db/default-db)))

(re-frame/register-handler
 :pick-bundle
 (fn [db [_ id v]]
   (let [options-path (keyword (str (name id) "-options"))
         bundle (get-in db [:index id v])]
     (-> db
         (update-in [:picked-id] dissoc options-path)
         (assoc id bundle)
         (assoc-in [:picked-id id] v)))))

(re-frame/register-handler
 :pick-option
 (fn [db [_ id ix v]]
   (-> db
       (assoc-in [:picked-id id ix] v))))
