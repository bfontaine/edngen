(ns edngen.core
  (:require [clojure.test-clojure.generators :as cgen])
  (:gen-class))

;; Based on
;; https://github.com/clojure/clojure/blob/71511b7800e18c83377a322f43585a853b303698/test/clojure/test_clojure/edn.clj#L17
(defn gen
  []
  (binding [*print-length* nil
            *print-dup* nil
            *print-level* nil]
    (pr-str (cgen/ednable))))

(defn -main
  [& args]
  (while true
    (println (gen))))
