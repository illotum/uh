(ns uh.views
    (:require [re-frame.core :as re-frame :refer [subscribe dispatch]]
              [clojure.string :as string]
              [cljs.pprint :as pprint]
              [reagent.core :as r]
              [re-com.core :as re-com]))

(defn bundle-picker [kind]
  (let [model (subscribe [:picked-id kind])
        choices (subscribe [:index-vec kind])]
    (fn []
      [re-com/single-dropdown
       :choices choices
       :model model
       :id-fn first
       :label-fn #(:name (second %))
       :placeholder (str "Pick your " (-> kind name string/capitalize))
       :on-change #(dispatch [:pick-bundle kind %])
       ])))

(defn option-picker [[ix [kind opts]] bundle-kind]
  (let [;option-data (subscribe [:index-map opts])
        id (keyword (str (name bundle-kind) "-options"))
        model (subscribe [:picked-id id ix])]
    (fn []
      [re-com/h-box
       :children [(doall (for [o opts]
                           ^{:key o}
                           (let [v {kind o}]
                             [re-com/radio-button
                              :label (str o)
                              :value v
                              :model model
                              :on-change #(dispatch [:pick-option id ix v])])))]]
      ; [re-com/p (str opts)]
      )
    ))

(defn options-list [kind]
  (let [options (subscribe [:options kind])]
    (fn []
      [re-com/v-box
       :children [(doall (for [opt @options]
                          [(option-picker opt kind)]
                           ))]])))

(def bundles
  [re-com/h-box
   :children [[re-com/v-box :size "30%" :children [[bundle-picker :homeworld]
                                                   [options-list :homeworld]
                                                   ]]
              [re-com/v-box :size "30%" :children [[bundle-picker :background]
                                                   [options-list :background]
                                                   ]]
              [re-com/v-box :size "30%" :children [[bundle-picker :role]
                                                   [options-list :role]
                                                   ]] ]])

(defn debug []
  (let [dump (subscribe [:debug])]
    (fn []
       [:pre (with-out-str (pprint/pprint @dump))])))

(defn main-panel []
  (fn []
    [re-com/v-box
     :height "100%"
     :children [bundles
                [debug]
                ]]))
