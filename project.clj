(defproject whitewash-web "0.1.0-SNAPSHOT"
  :description "A web app for encoding text as whitespace"
  :url "http://whitewash-web.herokuapp.com"
  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/MIT"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [whitewash "0.1.0-SNAPSHOT"]
                 [ring/ring-defaults "0.1.2"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler whitewash-web.core.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
