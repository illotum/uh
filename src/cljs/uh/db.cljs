;; vim:fdm=syntax:foldlevel=1
(ns uh.db
  (:require [schema.core :as s :include-macros true])
  )

(def corebook
  { :apt {
                      :ws {:name "Weapon Skill"}
                      :bs {:name "Ballistic Skill"}
                      :s {:name "Strength"}
                      :t {:name "Toughness"}
                      :a {:name "Agility"}
                      :int {:name "Intelligence"}
                      :per {:name "Perception"}
                      :fel {:name "Fellowship"}
                      :gen {:name "General"}
                      :offence {:name "Offence"}
                      :defence {:name "Defence"}
                      :finesse {:name "Finesse"}
                      :psyker {:name "Psyker"}
                      :tech {:name "Tech"}
                      :knowledge {:name "Knowledge"}
                      :leadership {:name "Leadership"}
                      :fieldcraft {:name "Fieldcraft"}
                      :social {:name "Social"}
                      }
               :stat {
                       :ws  {:name "Weapon Skill" :apts []}
                       :bs  {:name "Ballistic Skill" :apts []}
                       :s   {:name "Strength" :apts []}
                       :t   {:name "Toughness" :apts []}
                       :a   {:name "Agility" :apts []}
                       :int {:name "Intelligence" :apts []}
                       :per {:name "Perception" :apts []}
                       :wp  {:name "Willpower" :apts []}
                       :fel {:name "Fellowship" :apts []}
                       :inf {:name "Influence" :apts []}
                       }
               :skill {
                        :acrobatics      {:name "Acrobatics" :apts []}
                        :athletics       {:name "Athletics" :apts []}
                        :awareness       {:name "Awareness" :apts []}
                        :charm           {:name "Charm" :apts []}
                        :command         {:name "Command" :apts []}
                        :commerce        {:name "Commerce" :apts []}
                        :common-lore     {:name "Common Lore" :apts []}
                        :deceive         {:name "Deceive" :apts []}
                        :dodge           {:name "Dodge" :apts []}
                        :forbidden-lore  {:name "Forbidden Lore" :apts []}
                        :inquiry         {:name "Inquiry" :apts []}
                        :interrogation   {:name "Interrogation" :apts []}
                        :intimidate      {:name "Intimidate" :apts []}
                        :linguistics     {:name "Linguistics" :apts []}
                        :logic           {:name "Logic" :apts []}
                        :medicae         {:name "Medicae" :apts []}
                        :navigate        {:name "Navigate" :apts []}
                        :operate         {:name "Operate" :apts []}
                        :parry           {:name "Parry" :apts []}
                        :psyniscience    {:name "Psyniscience" :apts []}
                        :scholastic-lore {:name "Scholastic Lore" :apts []}
                        :scrutiny        {:name "Scrutiny" :apts []}
                        :security        {:name "Security" :apts []}
                        :sleight-of-hand {:name "Sleight of Hand" :apts []}
                        :stealth         {:name "Stealth" :apts []}
                        :survival        {:name "Survival" :apts []}
                        :tech-use        {:name "Tech-Use" :apts []}
                        :trade           {:name "Trade" :apts []}
                        }
   :homeworld {:feral {:name "Feral World" :apt [:t] :stat-up [:s :t] :stat-down [:inf] :fate 2 :fate-roll 3 :wounds 9}
               :forge {:name "Forge World" :apt [:int] :stat-up [:int :t] :stat-down [:fel] :fate 3 :fate-roll 8 :wounds 8}
               :highborn {:name "Highborn World" :apt [:fel] :stat-up [:fel :inf] :stat-down [:t] :fate 4 :fate-roll 10 :wounds 9}
               :hive {:name "Hive World" :apt [:per] :stat-up [:ag :per] :stat-down [:wp] :fate 2 :fate-roll 6 :wounds 8}
               :shrine {:name "Shrine World" :apt [:wp] :stat-up [:fel :wp] :stat-down [:per] :fate 3 :fate-roll 6 :wounds 7}
               :void {:name "Voidborn" :apt [:int] :stat-up [:int :wp] :stat-down [:s] :fate 3 :fate-roll 5 :wounds 7}}
   :background {:administratum {:name "Adeptus Administratum"
                                :skill [[:common-lore "Text"] :linguistics :logic :scholastic-lore]
                                :options [[:apts [:knowledge :social]]
                                          [:skills [:commerce :medicae]]]}
                :arbites {:name "Adeptus Arbites"
                          :skill [:awareness :common-lore :intimidate :scrutiny]
                          :options [[:apt [:defence :offence]]
                                    [:skill [:inquiry :intimidation]]]}
                :astropath {:name "Adeptus Astra Telepathica"
                            :skill [:awareness :common-lore :forbidden-lore]
                            :options [[:apt [:defence :psyker]]
                                      [:skill [:deceive :interrogation]]
                                      [:skill [:psyniscience :scrutiny]]]}
                :mechanicus {:name "Adeptus Mechanicus"
                             :skill [:common-lore :logic :security :tech-use]
                             :options [[:apt [:knowledge :tech]]
                                       [:skill [:awareness :operate]]]}
                :ministorum {:name "Adeptus Ministorum"
                             :skill [:charm :command :common-lore :linguistics]
                             :options [[:apt [:leadership :social]]
                                       [:skill [:inquiry :scrutiny]]]}
                :guard {:name "Imperial Guard"
                        :skill [:athletics :command :common-lore :navigate]
                        :options [[:apt [:fieldcraft :leadership]]
                                  [:skill [:medicae :operate]]]}
                :outcast {:name "Outcast"
                          :skill [:common-lore :deceive :dodge :stealth]
                          :options [[:apt [:fieldcraft :social]]
                                    [:skill [:acrobatics :sleight-of-hand]]]}}
   :role {:assassin {:name "Assassin" :apt [:ag :fieldcraft :finesse :per]
                     :options [[:apt [:ws :bs]]]}
          :chirurgeon {:name "Chirurgeon" :apt [:fieldcraft :int :s :knowledge :t]}
          :desperado {:name "Desperado" :apt [:ag :bs :defence :fel :finesse]}
          :hierophant {:name "Hierophant" :apt [:fel :social :offence :t :wp]}
          :mystic {:name "Mystic" :apt [:defence :knowledge :int :per :wp]}
          :sage {:name "Sage" :apt [:int :knowledge :tech :wp :per]}
          :seeker {:name "Seeker" :apt [:fel :int :per :social :tech]}
          :warrior {:name "Warrior" :apt [:bs :ws :offence :defence :s]}
          } })

(def corebook-old
  { :apt {
                      :ws {:name "Weapon Skill"}
                      :bs {:name "Ballistic Skill"}
                      :s {:name "Strength"}
                      :t {:name "Toughness"}
                      :a {:name "Agility"}
                      :int {:name "Intelligence"}
                      :per {:name "Perception"}
                      :fel {:name "Fellowship"}
                      :gen {:name "General"}
                      :offence {:name "Offence"}
                      :defence {:name "Defence"}
                      :finesse {:name "Finesse"}
                      :psyker {:name "Psyker"}
                      :tech {:name "Tech"}
                      :knowledge {:name "Knowledge"}
                      :leadership {:name "Leadership"}
                      :fieldcraft {:name "Fieldcraft"}
                      :social {:name "Social"}
                      }
               :stat {
                       :ws  {:name "Weapon Skill" :apts []}
                       :bs  {:name "Ballistic Skill" :apts []}
                       :s   {:name "Strength" :apts []}
                       :t   {:name "Toughness" :apts []}
                       :a   {:name "Agility" :apts []}
                       :int {:name "Intelligence" :apts []}
                       :per {:name "Perception" :apts []}
                       :wp  {:name "Willpower" :apts []}
                       :fel {:name "Fellowship" :apts []}
                       :inf {:name "Influence" :apts []}
                       }
               :skill {
                        :acrobatics      {:name "Acrobatics" :apts []}
                        :athletics       {:name "Athletics" :apts []}
                        :awareness       {:name "Awareness" :apts []}
                        :charm           {:name "Charm" :apts []}
                        :command         {:name "Command" :apts []}
                        :commerce        {:name "Commerce" :apts []}
                        :common-lore     {:name "Common Lore" :apts []}
                        :deceive         {:name "Deceive" :apts []}
                        :dodge           {:name "Dodge" :apts []}
                        :forbidden-lore  {:name "Forbidden Lore" :apts []}
                        :inquiry         {:name "Inquiry" :apts []}
                        :interrogation   {:name "Interrogation" :apts []}
                        :intimidate      {:name "Intimidate" :apts []}
                        :linguistics     {:name "Linguistics" :apts []}
                        :logic           {:name "Logic" :apts []}
                        :medicae         {:name "Medicae" :apts []}
                        :navigate        {:name "Navigate" :apts []}
                        :operate         {:name "Operate" :apts []}
                        :parry           {:name "Parry" :apts []}
                        :psyniscience    {:name "Psyniscience" :apts []}
                        :scholastic-lore {:name "Scholastic Lore" :apts []}
                        :scrutiny        {:name "Scrutiny" :apts []}
                        :security        {:name "Security" :apts []}
                        :sleight-of-hand {:name "Sleight of Hand" :apts []}
                        :stealth         {:name "Stealth" :apts []}
                        :survival        {:name "Survival" :apts []}
                        :tech-use        {:name "Tech-Use" :apts []}
                        :trade           {:name "Trade" :apts []}
                        }
   :homeworld [
               {:name "Feral World" :apt [:t] :stat-up [:s :t] :stat-down [:inf] :fate 2 :fate-roll 3 :wounds 9}
               {:name "Forge World" :apt [:int] :stat-up [:int :t] :stat-down [:fel] :fate 3 :fate-roll 8 :wounds 8}
               {:name "Highborn World" :apt [:fel] :stat-up [:fel :inf] :stat-down [:t] :fate 4 :fate-roll 10 :wounds 9}
               {:name "Hive World" :apt [:per] :stat-up [:ag :per] :stat-down [:wp] :fate 2 :fate-roll 6 :wounds 8}
               {:name "Shrine World" :apt [:wp] :stat-up [:fel :wp] :stat-down [:per] :fate 3 :fate-roll 6 :wounds 7}
               {:name "Voidborn" :apt [:int] :stat-up [:int :wp] :stat-down [:s] :fate 3 :fate-roll 5 :wounds 7} ]
   :background [
                {:name "Adeptus Administratum"
                 :skill [[:common-lore "Text"] :linguistics :logic :scholastic-lore]
                 :options [[:apts [:knowledge :social]]
                           [:skills [:commerce :medicae]]]}
                {:name "Adeptus Arbites"
                 :skill [:awareness :common-lore :intimidate :scrutiny]
                 :options [[:apts [:defence :offence]]
                           [:skills [:inquiry :intimidation]]]}
                {:name "Adeptus Astra Telepathica"
                 :skill [:awareness :common-lore :forbidden-lore]
                 :options [[:apts [:defence :psyker]]
                           [:skills [:deceive :interrogation]]
                           [:skills [:psyniscience :scrutiny]]]}
                {:name "Adeptus Mechanicus"
                 :skill [:common-lore :logic :security :tech-use]
                 :options [[:apts [:knowledge :tech]]
                           [:skills [:awareness :operate]]]}
                {:name "Adeptus Ministorum"
                 :skill [:charm :command :common-lore :linguistics]
                 :options [[:apts [:leadership :social]]
                           [:skills [:inquiry :scrutiny]]]}
                {:name "Imperial Guard"
                 :skill [:athletics :command :common-lore :navigate]
                 :options [[:apts [:fieldcraft :leadership]]
                           [:skills [:medicae :operate]]]}
                {:name "Outcast"
                 :skill [:common-lore :deceive :dodge :stealth]
                 :options [[:apts [:fieldcraft :social]]
                           [:skills [:acrobatics :sleight-of-hand]]]} ]
   :role [
          {:name "Assassin" :apts [:ag :fieldcraft :finesse :per]
           :options [[:apts [:ws :bs]]]}
          {:name "Chirurgeon" :apts [:fieldcraft :int :s :knowledge :t]}
          {:name "Desperado" :apts [:ag :bs :defence :fel :finesse]}
          {:name "Hierophant" :apts [:fel :social :offence :t :wp]}
          {:name "Mystic" :apts [:defence :knowledge :int :per :wp]}
          {:name "Sage" :apts [:int :knowledge :tech :wp :per]}
          {:name "Seeker" :apts [:fel :int :per :social :tech]}
          {:name "Warrior" :apts [:bs :ws :offence :defence :s]}
          ] })

(def default-db
  {:index corebook})

;; Schema
(def Entry
  "Index entry contains all the element information"
  {:name s/Str
   (s/optional-key :apts) [s/Keyword]})

(def Ref
   "Reference to an Entry is either keyword or keyword and Specialization string"
   (s/if vector? [(s/one s/Keyword "k") (s/one s/Str "s")]
          s/Keyword))

(def Option
   "Option holds a kind keyword and list of choices"
   [(s/one s/Keyword "k")
    [Ref]])

(def Choice
   "Choice is indexed by UI widgets and holds one of the choices from the Option"
   [(s/one s/Keyword "k") (s/one Ref "r")])

(def Bundle
   "Bundle contains a set of Refs and numbers of different kinds, and Options"
   {:name s/Str
    (s/optional-key :options) [Option]
    (s/optional-key :choices) {s/Num Choice}
    s/Keyword (s/if vector? [Ref] s/Num)})

(def Index
   "Index contains (static) reference data"
   {:apt {s/Keyword Entry}
    :stat {s/Keyword Entry}
    :skill {s/Keyword Entry}
    :homeworld {s/Keyword Bundle}
    :background {s/Keyword Bundle}
    :role {s/Keyword Bundle}})

(def AppDB
  "Application state total"
  {:index Index
   s/Keyword Bundle})
