(ns edngen.core
  (:require [clojure.test-clojure.generators :as cgen])
  (:gen-class))

;; Based on
;; https://github.com/clojure/clojure/blob/71511b7800e18c83377a322f43585a853b303698/test/clojure/test_clojure/edn.clj#L17

(defmacro with-safe-print
  [& body]
  `(binding [*print-length* nil
             *print-dup* nil
             *print-level* nil]
    ~@body))

(def ^:private gen*
  cgen/ednable)

(defn gen
  "Return a random EDN structure in one string."
  []
  (with-safe-print
    (pr-str (gen*))))

(defn -main
  [& args]
  (let [n (when-let [arg (first args)]
            ;; Abort with an exception if this is not a valid number
            (Long/parseLong arg))]
    (with-safe-print
      (if n
        (dotimes [_ n]
          (prn (gen*)))
        (while true
          (prn (gen*)))))))

(ns-unmap *ns* 'with-safe-print)
