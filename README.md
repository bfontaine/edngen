# edngen

`edngen` is a simple Clojure library/program to generate random EDN strings.
It’s based off [Clojure’s own EDN test suite][clj].

I wrote it to generate tests for the [`edn_format`][py] Python library.

[clj]: https://github.com/clojure/clojure/blob/71511b7800e18c83377a322f43585a853b303698/test/clojure/test_clojure/edn.clj
[py]: https://github.com/swaroopch/edn_format#edn_format

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

    lein run [N]

It generates `N` EDN string, one per line. If `N` is not given, it runs
infinitely.

## Known Issues

The program doesn’t terminate when its output is truncated, e.g. `lein run |
head`.

## License

Copyright © 2018-2019 Baptiste Fontaine

Distributed under the Eclipse Public License either version 1.0 or (at your
option) any later version.
