(ns sync-sub.cmdline
  (:use [sync-sub.core])
  (:gen-class))




;; Need to use https://github.com/clojure/tools.cli to check args
(defn -main
  "Main method"
  [& args]
  (let [[input-filename time] args]
    (sync-file input-filename (Integer/parseInt time))
    (println "Subs synchronized finished.")))
