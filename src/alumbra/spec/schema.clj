(ns alumbra.spec.schema
  (:require [clojure.spec.alpha :as s]
            [alumbra.spec common]))

;; ## Schema

(s/def :alumbra/schema
  (s/keys :req [:alumbra/metadata]
          :opt [:alumbra/type-definitions
                :alumbra/input-type-definitions
                :alumbra/type-extensions
                :alumbra/interface-definitions
                :alumbra/schema-definitions
                :alumbra/enum-definitions
                :alumbra/scalar-definitions
                :alumbra/directive-definitions
                :alumbra/union-definitions]))

;; ## Type Definition/Extension

(s/def :alumbra/type-definitions
  (s/coll-of :alumbra/type-definition
             :gen-max 4))

(s/def :alumbra/type-extensions
  (s/coll-of :alumbra/type-definition
             :gen-max 2))

(s/def :alumbra/type-definition
  (s/keys :req [:alumbra/field-definitions
                :alumbra/type-name
                :alumbra/metadata]
          :opt [:alumbra/interface-types
                :alumbra/directives]))

(s/def :alumbra/interface-types
  (s/coll-of :alumbra/interface-type
             :min-count 1
             :gen-max 3))

(s/def :alumbra/interface-type
  (s/keys :req [:alumbra/type-name
                :alumbra/metadata]))

(s/def :alumbra/field-definitions
  (s/coll-of :alumbra/field-definition
             :min-count 1
             :gen-max 3))

(s/def :alumbra/field-definition
  (s/keys :req [:alumbra/field-name
                :alumbra/type
                :alumbra/metadata]
          :opt [:alumbra/argument-definitions
                :alumbra/directives]))

(s/def :alumbra/argument-definitions
  (s/coll-of :alumbra/argument-definition
             :min-count 1
             :gen-max 3))

(s/def :alumbra/argument-definition
  (s/keys :req [:alumbra/argument-name
                :alumbra/argument-type
                :alumbra/metadata]
          :opt [:alumbra/default-value
                :alumbra/directives]))

;; ## Input Type Definition

(s/def :alumbra/input-type-definitions
  (s/coll-of :alumbra/input-type-definition
             :gen-max 4))

(s/def :alumbra/input-type-definition
  (s/keys :req [:alumbra/input-field-definitions
                :alumbra/type-name
                :alumbra/metadata]
          :opt [:alumbra/directives]))

(s/def :alumbra/input-field-definitions
  (s/coll-of :alumbra/input-field-definition
             :min-count 1
             :gen-max 3))

(s/def :alumbra/input-field-definition
  (s/keys :req [:alumbra/field-name
                :alumbra/type
                :alumbra/metadata]))

;; ## Interface Definition

(s/def :alumbra/interface-definitions
  (s/coll-of :alumbra/interface-definition
             :gen-max 2))

(s/def :alumbra/interface-definition
  (s/keys :req [:alumbra/field-definitions
                :alumbra/type-name
                :alumbra/metadata]
          :opt [:alumbra/directives]))

;; ## Scalar Definition

(s/def :alumbra/scalar-definitions
  (s/coll-of :alumbra/scalar-definition
             :gen-max 2))

(s/def :alumbra/scalar-definition
  (s/keys :req [:alumbra/type-name
                :alumbra/metadata]
          :opt [:alumbra/directives]))

;; ## Directive Definition

(s/def :alumbra/directive-definitions
  (s/coll-of :alumbra/directive-definition
             :gen-max 1))

(s/def :alumbra/directive-definition
  (s/keys :req [:alumbra/directive-locations
                :alumbra/directive-name
                :alumbra/metadata]
          :opt [:alumbra/argument-definitions]))

;; ## Union Definition

(s/def :alumbra/union-definitions
  (s/coll-of :alumbra/union-definition
             :gen-max 2))

(s/def :alumbra/union-definition
  (s/keys :req [:alumbra/union-types
                :alumbra/type-name
                :alumbra/metadata]
          :opt [:alumbra/directives]))

(s/def :alumbra/union-types
  (s/coll-of :alumbra/union-type
             :min-count 1
             :gen-max 3))

(s/def :alumbra/union-type
  (s/keys :req [:alumbra/type-name
                :alumbra/metadata]))

;; ## Enum Definition

(s/def :alumbra/enum-definitions
  (s/coll-of :alumbra/enum-definition
             :gen-max 2))

(s/def :alumbra/enum-definition
  (s/keys :req [:alumbra/enum-fields
                :alumbra/type-name
                :alumbra/metadata]
          :opt [:alumbra/directives]))

(s/def :alumbra/enum-fields
  (s/coll-of :alumbra/enum-field
             :min-count 1
             :gen-max 3))

(s/def :alumbra/enum-field
  (s/keys :req [:alumbra/enum
                :alumbra/metadata]
          :opt [:alumbra/integer
                :alumbra/directives]))

;; ## Schema Definition

(s/def :alumbra/schema-definitions
  (s/coll-of :alumbra/schema-definition
             :gen-max 1))

(s/def :alumbra/schema-definition
  (s/keys :req [:alumbra/schema-fields
                :alumbra/metadata]
          :opt [:alumbra/directives]))

(s/def :alumbra/schema-fields
  (s/coll-of :alumbra/schema-field
             :min-count 1
             :gen-max 3))

(s/def :alumbra/schema-field
  (s/keys :req [:alumbra/schema-type
                :alumbra/operation-type
                :alumbra/metadata]))

(s/def :alumbra/schema-type
  (s/keys :req [:alumbra/type-name
                :alumbra/metadata]))
