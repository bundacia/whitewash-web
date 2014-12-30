(ns whitewash.core)
(require '[clojure.set :refer [ map-invert ]])

(def whitespace_map {"0" "\t", "1" " "})
(def bit_map (map-invert whitespace_map))
      
(defn unwash-char
  "Decode the given whitewashed character."
  [washed_char]
  (char (read-string (apply str (cons "2r" (map (comp bit_map str) washed_char))))))

(defn unwash
  "Decode given whitewashed string."
  [washed_str]
  (apply str (map unwash-char (partition 8 washed_str))))

(defn binary_string 
  [character] 
  (clojure.string/replace (format "%8s" (Integer/toString (int character) 2)) \space \0))

(defn wash-char
  "Encode a single character as whitespace."
  [character]
  (apply str 
    (map (comp whitespace_map str) (binary_string character))))

(defn wash
  "Encode given string with whitespace."
  [plaintext]
  (apply str
    (mapcat wash-char plaintext)))

