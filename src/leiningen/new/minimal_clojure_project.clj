(ns leiningen.new.minimal-clojure-project
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "minimal-clojure-project"))

(defn minimal-clojure-project
  "Leiningen template for minimal Clojure project."
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' minimal-clojure-project project.")
    (->files data
             ["README.markdown" (render "README.markdown" data)]
             ["project.clj" (render "project.clj" data)]
             ["main.clj" (render "main.clj" data)]
             [".gitignore" (render "gitignore" data)])))
