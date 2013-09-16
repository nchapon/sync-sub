(ns sync-sub.cmdline
  (:use [sync-sub.core]
        [clojure.tools.cli :only [cli]])
  (:gen-class))




(defn -main
  "Main method"
  [& args]
  (let [[opts args banner] (cli args
                                "Subtitle Synchronisation Tool Usage"
                                ["-h" "--help" :flag true :default false]
                                ["-f" "--input-file" "Subtitle input filename"]
                                ["-s" "--sync-time" "Synchronization time in millis" :parse-fn #(Integer/parseInt %)])]
    (when (:help opts)
      (println banner)
      (System/exit 0))
    (if (and
         (:input-file opts)
         (:sync-time opts))
      (sync-file (:input-file opts) (:sync-time opts))
      (println banner))))
