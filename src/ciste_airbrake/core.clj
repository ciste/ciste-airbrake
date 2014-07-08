(ns ciste-airbrake.core)

(defn send-airbrake
  [ex options]
  (airbrake/notify
   (config :airbrake :key)
   (name @*environment*)
   "/" ex options))

(defn errors
  [ex]
        (when (config :airbrake :enabled)
        (let [options {:url "foo"
                       :params (into {} (map (fn [[k v]] {k (pr-str v)})
                                             (:environment data)))}]
          (try
            (send-airbrake ex options)
            (catch Exception ex))))

  )



(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
