(ns nuds-reframe.views
  (:require
   [re-frame.core :as re-frame]
   [nuds-reframe.subs :as subs]
   ["@material-ui/core" :as mui]
   ["@material-ui/icons" :as mui-icons]
   ["nu-sketch/lib/future" :as future]))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])
        four (future/sum 2 2)
        three (future/autoSum)]
    [:div
     [:h1 "Hello from " @name]
     [:ul "Importing function from local lib"
      [:li three]
      [:li four]]
     [:> mui/Button
      {:variant :contained
       :color   :primary}
      "Hey"
      [:> mui-icons/KeyboardArrowRight]]
     [:div
      [:> mui/FormControl
       [:> mui/InputLabel {:html-for "my-input"} "Email address"]
       [:> mui/Input {:id "my-input" :aria-describedby "my-helper-text"}]
       [:> mui/FormHelperText {:id "my-helper-text"} "We'll never share your email."]]]]))
