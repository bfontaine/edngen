;; Imported from
;;   https://github.com/clojure/clojure/blob/71511b7800e18c83377a322f43585a853b303698/test/clojure/test_clojure/generators.clj
;;
;; Clojure
;; Copyright (c) Rich Hickey. All rights reserved.
;; The use and distribution terms for this software are covered by the
;; Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;; which can be found in the file epl-v10.html at the root of this distribution.
;; By using this software in any fashion, you are agreeing to be bound by
;; the terms of this license.
;; You must not remove this notice, or any other, from this software.
;;
(ns clojure.test-clojure.generators
  (:require [clojure.data.generators :as gen]))

(def keyword-pool
  (delay
   (binding [gen/*rnd* (java.util.Random. 42)]
     (into [] (repeatedly 1000 gen/keyword)))))

(defn keyword-from-pool
  []
  (gen/rand-nth @keyword-pool))

(def symbol-pool
  (delay
   (binding [gen/*rnd* (java.util.Random. 42)]
     (into [] (repeatedly 1000 gen/symbol)))))

(defn symbol-from-pool
  []
  (gen/rand-nth @keyword-pool))

(def ednable-scalars
  [(constantly nil)
   gen/byte
   gen/long
   gen/boolean
   gen/printable-ascii-char
   gen/string
   symbol-from-pool
   keyword-from-pool
   gen/uuid
   gen/date
   gen/ratio
   gen/bigint
   gen/bigdec])

(defn- call-through
  "Recursively call x until it doesn't return a function."
  [x]
  (if (fn? x)
    (recur (x))
    x))

(defn ednable-scalar
  []
  (call-through (rand-nth ednable-scalars)))

(def ednable-collections
  [[gen/vec [ednable-scalars]]
   [gen/set [ednable-scalars]]
   [gen/hash-map [ednable-scalars ednable-scalars]]])

(defn ednable-collection
  []
  (let [[coll args] (rand-nth ednable-collections)]
    (apply coll (map rand-nth args))))

(defn ednable
  []
  (gen/one-of ednable-scalar ednable-collection))
