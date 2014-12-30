(ns whitewash-web.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :refer [redirect]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [whitewash.core :refer [wash unwash]]))  

(defroutes app-routes
  (GET "/" [] (redirect "form.html"))
  (GET "/unwash" [text] (unwash text))
  (GET "/wash"   [text] (wash   text))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
