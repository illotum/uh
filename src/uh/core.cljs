(ns ^:figwheel-always uh.core
    (:require
              [uh.bundle :as bundle]
              [uh.merger :as merger]
              [uh.index :as index]
              [reagent.core :as r]))

;; {{{ State
(defonce defaults {:stat-base {:roll 20 :distribute 25}
                   :stat-adj 5})
(defonce homeworlds-state (r/atom {}))
(defonce backgrounds-state (r/atom {}))
(defonce roles-state (r/atom {}))
(defonce user-state (r/atom {}))
;; }}}

;; {{{ Views
(def homeworlds-view (bundle/view :homeworlds index/core homeworlds-state))
(def backgrounds-view (bundle/view :backgrounds index/core backgrounds-state))
(def roles-view (bundle/view :roles index/core roles-state))


(defn app []
  [:div.container
   [:div.row
    (homeworlds-view)
    (backgrounds-view)
    (roles-view)]
   [:div.row
    (merger/simple-view @homeworlds-state
                        @backgrounds-state
                        @roles-state)]
    ])
;; }}}
(r/render-component [app]
                    (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
