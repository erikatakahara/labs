(ns re-frame-study.views
  (:require
   [re-frame.core :as re-frame]
   [re-frame-study.subs :as subs]
   [reagent.core :as r]))

(defn toggle-switch [_]
  (let [selected* (r/atom false)
        id (str "toggle-switch-" (rand 1000))]
    (fn [label]
      [:div.toggle-switch
       [:input {:type :checkbox
                :checked @selected*
                :on-change #(swap! selected* not)
                :id id}]
       [:label {:for id} (str label ": " (if @selected* "Active" "Inactive"))]])))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Features"]
     [toggle-switch "Feature 1"]
     [toggle-switch "Feature 2"]]))
