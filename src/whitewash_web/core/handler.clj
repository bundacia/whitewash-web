(ns whitewash-web.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [whitewash.core :refer [wash unwash]]))  

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/unwash" [text]
       (unwash text))
  (GET "/wash" [text]
       (wash text))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
