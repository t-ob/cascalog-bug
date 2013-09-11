(ns cascalog-bug.core
  (:require [cascalog.api :refer :all]
            [cascalog.cascading.io :refer [with-log-level]]
            [cascalog-bug.playground :refer [bootstrap]]))

;; Will replace the first tuple with a copy of the second
(defbufferfn wtf [tuples]
  (map (partial apply concat)
       (partition 2 1 tuples)))

;; Mapping vec over tuples first gives desired behaviour
(defbufferfn wtff [tuples]
  (map (partial apply concat)
       (partition 2 1 (map vec tuples))))

#_(let [source [["a" 1]
                ["b" 2]
                ["c" 3]
                ["d" 4]]]
    (with-log-level :warn
      (?- (stdout)
          (<- [?a ?b ?c ?d]
              (source ?x ?y)
              (wtf ?x ?y :> ?a ?b ?c ?d)))))

;; RESULTS
;; -----------------------
;; b	2	b	2
;; b	2	c	3
;; c	3	d	4
;; -----------------------

#_(let [source [["a" 1]
                ["b" 2]
                ["c" 3]
                ["d" 4]]]
    (with-log-level :warn
      (?- (stdout)
          (<- [?a ?b ?c ?d]
              (source ?x ?y)
              (wtff ?x ?y :> ?a ?b ?c ?d)))))

;; RESULTS
;; -----------------------
;; a	1	b	2
;; b	2	c	3
;; c	3	d	4
;; -----------------------
