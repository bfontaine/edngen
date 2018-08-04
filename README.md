# edngen

`edngen` is a simple Clojure library/program to generate random EDN strings.
It’s based off [Clojure’s own EDN test suite][clj].

[clj]: https://github.com/clojure/clojure/blob/71511b7800e18c83377a322f43585a853b303698/test/clojure/test_clojure/edn.clj

## Usage

### Library

```clojure
[edngen "0.0.1"]
```

```clojure
(ns your.ns
  (:require [edngen.core :as edngen]))

(edngen) ; => "...some random edn..."
```

### Program

    lein run

It’ll infinitely generate one EDN string per line.

## Known Issues

The program doesn’t terminate when its output is truncated, e.g. `lein run |
head`.

## License

Copyright © 2018 Baptiste Fontaine

Distributed under the Eclipse Public License either version 1.0 or (at your
option) any later version.
