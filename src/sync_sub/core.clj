(ns sync-sub.core
  (:use [clojure.string :as str :only [split-lines split]])
  (:import [org.joda.time LocalTime]))

(defn convert-to-time [s]
  (let [[hours min sec millis] (map #(Integer/parseInt %) (str/split s #"[,:]"))]
    (LocalTime. hours min sec millis)))

(defn add-millis [s millis]
  (.plusMillis (convert-to-time s) millis))

(defn is-time? [s]
  (if (> (.indexOf s "-->") 0) true false))

(defn get-lines [filename]
  (with-open [rdr (clojure.java.io/reader filename)]
                               (reduce conj [] (line-seq rdr))))
