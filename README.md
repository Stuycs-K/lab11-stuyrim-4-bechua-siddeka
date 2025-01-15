[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

Make a clear list of features that work/dont work

:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.


# Adventurer Battle Game

## Adventurer Subclasses

The game includes different adventurers, each with their own abilities and roles. Each adventurer has a certain amount of **HP** and different **actions** that can be used during combat.

### Healer

**Starting HP:** 23 HP

* **Attack:** Deals 2-3 damage to a specified opponent.
* **Support:** Heals another player by adding 5-7 HP to specified player.
* **Special:** Decreases the opponent's next attack by 5%; *This ability is unlocked once they have healed teammates by at least 15 HP*

### Mage

**Starting HP:** 28 HP

* **Attack:** Deals 4-6 damage to a random opponent
* **Support:** Adds 6-7 HP to all players on their team, excluding itself.
* **Special:** Skips the opponent's next turn; *This ability is unlocked once they have 5 Magic Points; Magic Points are earned by attacking opponents*

---

## The Dragon Boss

### Dragon
**Starting HP:** 80 HP
* **Attack:** Deals 10-12 damage to a single target.
* **Support:** Adds 7-9 HP to itself.
* **Special Attack:** This attack decreases the HP of all three opponents by 17 HP across all three (the amount of individual damage is randomized but must sum to 17 across the opponent's team). *Special resource must be at least 20 for this to be used. After one use, the special resource reverts to zero and must be built up again through attacks- each attack adds 4 magic points*
