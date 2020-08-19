(ns duct-book.build
  (:require [clojure.java.io :as io])
  (:import (org.asciidoctor Asciidoctor Asciidoctor$Factory SafeMode)))

(defn -main []
  (let [asciidoctor (Asciidoctor$Factory/create)
        options {"backend" "html5"
                 "safe" (.getLevel SafeMode/UNSAFE)
                 "to_dir" "./build/"
                 "to_file" "index.html"}]
    (.convertFile asciidoctor (io/as-file (io/resource "book.adoc")) options)))
