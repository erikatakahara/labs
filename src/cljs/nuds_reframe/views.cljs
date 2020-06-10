(ns nuds-reframe.views
  (:require
   [re-frame.core :as re-frame]
   [nuds-reframe.subs :as subs]
   ["@material-ui/core" :as mui]
   ["@material-ui/icons" :as mui-icons]))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from " @name]
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
