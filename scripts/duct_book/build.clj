(ns duct-book.build
  (:require [clojure.java.io :as io])
  (:import (org.asciidoctor Asciidoctor Asciidoctor$Factory SafeMode)))

(defn -main []
  (let [asciidoctor (Asciidoctor$Factory/create)
        options {"in_place" true
                 "backend" "html5"
                 "safe" (.getLevel SafeMode/SAFE)}]
    (.convertFile asciidoctor (io/as-file (io/resource "book.adoc")) options)))
