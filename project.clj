(defproject edngen "0.1.0-SNAPSHOT"
  :description "Generate random EDN data"
  :url "https://github.com/bfontaine/edngen"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/data.generators "0.1.2"]]
  :main edngen.core)