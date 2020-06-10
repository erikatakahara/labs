(ns re-frame-study.views
  (:require
   [re-frame.core :as re-frame]
   [re-frame-study.subs :as subs]
   [reagent.core :as r]))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "NuDS on Re-frame"]]))
