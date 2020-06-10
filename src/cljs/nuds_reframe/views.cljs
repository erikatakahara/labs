(ns nuds-reframe.views
  (:require
   [re-frame.core :as rf]
   [reagent.core :as r]
   [nuds-reframe.subs :as subs]
   ["@material-ui/core" :as mui]
   ["@material-ui/icons" :as mui-icons]))

(defn main-panel []
  (let [name         (rf/subscribe [::subs/name])
        person-email*  (r/atom "")
        four (future/sum 2 2)
        three (future/autoSum)]
    (fn []
      [:> mui/Box
       [:> mui/Typography {:variant :h3
                           :component :h1}
        "Hello from " @name]
       [:ul "Importing function from local lib"
        [:li three]
        [:li four]]
       [:> mui/Box {:display :flex}
        [:> mui/Box {:flex 1}
         [:> mui/Typography {:variant :h4
                             :component :h4} "Person form"]

         [:> mui/FormControl
          [:> mui/InputLabel {:html-for "email"} "Email address"]
          [:> mui/Input {:id               "email"
                         :aria-describedby "email-tip"
                         :value            @person-email*
                         :on-change        (fn [e]
                                             (js/console.log (-> e .-target .-value))
                                             (reset! person-email* (-> e .-target .-value)))}]
          [:> mui/FormHelperText {:id "email-tip"} "We'll never share your email."]]]

        [:> mui/Box {:flex 1}
         [:> mui/Typography {:variant :h4
                             :component :h4}"Person data"]
         [:> mui/Typography {:component :p} "E-mail"]
         [:> mui/Typography {:color "textSecondary" :component :p} @person-email*]]]])))
