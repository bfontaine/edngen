(ns edngen.core-test
  (:require [clojure.test :refer :all]
            [edngen.core :as sut]))

(deftest simple-test
  (is (string? (sut/gen))))
