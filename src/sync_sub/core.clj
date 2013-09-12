(ns sync-sub.core
  (:use [clojure.string :as str :only [split-lines split trim]])
  (:import [org.joda.time LocalTime]))

(defn convert-to-time [s]
  (let [[hours min sec millis] (map #(Integer/parseInt %) (str/split s #"[,:]"))]
    (LocalTime. hours min sec millis)))

(defn add-millis [s millis]
  (.plusMillis (convert-to-time s) millis))


(defn extract-times-from-line [line]
  (map #(str/trim %) (str/split line #"-->")))

(defn is-time? [s]
  (if (> (.indexOf s "-->") 0) true false))



(defn update-line
  [line millis]
  (let [[start end] (extract-times-from-line line)]
    (str (clojure.string/replace (add-millis start 1000) "." ",")
         " --> "
         (clojure.string/replace (add-millis end 1000) "." ","))))

(defn sync-line
  [line millis]
  (cond
   (is-time? line) (update-line line millis)
   :else line))


;; (defn sync-lines
;;   [lines millis]
;;   (loop [output []
;;         work-todo lines]
;;     (if (empty? work-todo)
;;       output
;;       (recur (conj output (sync-line-with-time (first work-todo) 1000))
;;              (rest work-todo)))))




(defn get-lines [filename]
  (with-open [rdr (clojure.java.io/reader filename)]
                               (reduce conj [] (line-seq rdr))))

(defn sync-file [filename millis]
  (with-open [rdr (clojure.java.io/reader filename)
              wrt (clojure.java.io/writer (str filename ".out"))]
    (doseq [line (line-seq rdr)]
      (.write wrt (str (sync-line line millis) "\n")))))
