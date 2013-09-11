(ns cascalog-bug.playground
  (:require [cascalog.api :refer :all]
            [cascalog.cascading.conf :as conf])
  (:import [java.io PrintStream]
           [cascalog WriterOutputStream]
           [org.apache.log4j Logger WriterAppender SimpleLayout]))

(defn bootstrap []
  (conf/set-job-conf! {"io.sort.mb" 1})
  (-> (Logger/getRootLogger)
      (.addAppender (WriterAppender. (SimpleLayout.) *out*)))
  (System/setOut (PrintStream. (WriterOutputStream. *out*))))
