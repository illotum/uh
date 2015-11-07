;; vim:fdm=syntax:foldlevel=2

(ns uh.index)

(defonce core {
               :apts {
                      :ws!        {:repr "Weapon Skill"}
                      :bs!        {:repr "Ballistic Skill"}
                      :s!         {:repr "Strength"}
                      :t!         {:repr "Toughness"}
                      :ag!        {:repr "Agility"}
                      :int!       {:repr "Intelligence"}
                      :per!       {:repr "Perception"}
                      :wp!        {:repr "Weapon Skill"}
                      :fel!       {:repr "Fellowship"}
                      :general    {:repr "General"}
                      :offence    {:repr "Offence"}
                      :defence    {:repr "Defence"}
                      :finesse    {:repr "Finesse"}
                      :psyker     {:repr "Psyker"}
                      :tech       {:repr "Tech"}
                      :knowledge  {:repr "Knowledge"}
                      :leadership {:repr "Leadership"}
                      :fieldcraft {:repr "Fieldcraft"}
                      :social     {:repr "Social"}
                      }
               :stats {
                       :ws  {:repr "Weapon Skill" :apts []}
                       :bs  {:repr "Ballistic Skill" :apts []}
                       :s   {:repr "Strength" :apts []}
                       :t   {:repr "Toughness" :apts []}
                       :a   {:repr "Agility" :apts []}
                       :int {:repr "Intelligence" :apts []}
                       :per {:repr "Perception" :apts []}
                       :wp  {:repr "Willpower" :apts []}
                       :fel {:repr "Fellowship" :apts []}
                       :inf {:repr "Influence" :apts []}
                       }
               :skills {
                        :acrobatics      {:repr "Acrobatics" :apts []}
                        :athletics       {:repr "Athletics" :apts []}
                        :awareness       {:repr "Awareness" :apts []}
                        :charm           {:repr "Charm" :apts []}
                        :command         {:repr "Command" :apts []}
                        :commerce        {:repr "Commerce" :apts []}
                        :common-lore     {:repr "Common Lore" :apts []}
                        :deceive         {:repr "Deceive" :apts []}
                        :dodge           {:repr "Dodge" :apts []}
                        :forbidden-lore  {:repr "Forbidden Lore" :apts []}
                        :inquiry         {:repr "Inquiry" :apts []}
                        :interrogation   {:repr "Interrogation" :apts []}
                        :intimidate      {:repr "Intimidate" :apts []}
                        :linguistics     {:repr "Linguistics" :apts []}
                        :logic           {:repr "Logic" :apts []}
                        :medicae         {:repr "Medicae" :apts []}
                        :navigate        {:repr "Navigate" :apts []}
                        :operate         {:repr "Operate" :apts []}
                        :parry           {:repr "Parry" :apts []}
                        :psyniscience    {:repr "Psyniscience" :apts []}
                        :scholastic-lore {:repr "Scholastic Lore" :apts []}
                        :scrutiny        {:repr "Scrutiny" :apts []}
                        :security        {:repr "Security" :apts []}
                        :sleight-of-hand {:repr "Sleight of Hand" :apts []}
                        :stealth         {:repr "Stealth" :apts []}
                        :survival        {:repr "Survival" :apts []}
                        :tech-use        {:repr "Tech-Use" :apts []}
                        :trade           {:repr "Trade" :apts []}
                        }
               :homeworlds {
                            :none     {:repr "Pick your Homeworld"}
                            :feral    {:repr "Feral World" :apts [:t!] :stat-up [:s :t] :stat-down [:inf] :fate 2 :fate-roll 3 :wounds 9}
                            :forge    {:repr "Forge World" :apts [:int!] :stat-up [:int :t] :stat-down [:fel] :fate 3 :fate-roll 8 :wounds 8}
                            :highborn {:repr "Highborn World" :apts [:fel!] :stat-up [:fel :inf] :stat-down [:t] :fate 4 :fate-roll 10 :wounds 9}
                            :hive     {:repr "Hive World" :apts [:per!] :stat-up [:ag :per] :stat-down [:wp] :fate 2 :fate-roll 6 :wounds 8}
                            :shrine   {:repr "Shrine World" :apts [:wp!] :stat-up [:fel :wp] :stat-down [:per] :fate 3 :fate-roll 6 :wounds 7}
                            :void     {:repr "Voidborn" :apts [:int!] :stat-up [:int :wp] :stat-down [:s] :fate 3 :fate-roll 5 :wounds 7}
                            }
               :backgrounds {
                             :none              {:repr "Pick your Background"}
                             :administratum     {:repr "Adeptus Administratum"
                                                 :options {:apts [:knowledge :social]}}
                             :arbites           {:repr "Adeptus Arbites"
                                                 :options {:apts [:knowledge :social]}}
                             :astra-telepathica {:repr "Adeptus Astra Telepathica"
                                                 :options {:apts [:defence :psyker]}}
                             :mechanicus        {:repr "Adeptus Mechanicus"
                                                 :options {:apts [:knowledge :tech]}}
                             :ministorum        {:repr "Adeptus Ministorum"
                                                 :options {:apts [:leadership :social]}}
                             :guard             {:repr "Imperial Guard"
                                                 :options {:apts [:fieldcraft :leadership]}}
                             :outcast           {:repr "Outcast"
                                                 :options {:apts [:fieldcraft :social]}}
                             }
               :roles {
                       :none       {:repr "Pick your Role"}
                       :assassin   {:repr "Assassin" :apts [:ag! :fieldcraft :finesse :per!]
                                    :options {:apts [:ws! :bs!]}}
                       :chirurgeon {:repr "Chirurgeon" :apts [:fieldcraft :int! :s! :knowledge :t!]}
                       :desperado  {:repr "Desperado" :apts [:ag! :bs! :defence :fel! :finesse]}
                       :hierophant {:repr "Hierophant" :apts [:fel! :social :offence :t! :wp!]}
                       :mystic     {:repr "Mystic" :apts [:defence :knowledge :int! :per! :wp!]}
                       :sage       {:repr "Sage" :apts [:int! :knowledge :tech :wp! :per!]}
                       :seeker     {:repr "Seeker" :apts [:fel! :int! :per! :social :tech]}
                       :warrior    {:repr "Warrior" :apts [:bs! :ws! :offence :defence :s!]}
                       }
               }
  )





