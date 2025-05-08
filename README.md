# ⚔️ Runa's Strive

A Java-based turn-based combat game where the player controls a character named Runa who battles against various monsters using physical and magical abilities. This project was created as a programming final task at KIT.

## 📁 Project Structure

- **game**: Core game engine and runner
- **gamemodelling**: 
  - **abilities**: Combat abilities (offensive, non-offensive)
  - **entities**: Game characters (Runa and monsters)
- **states**: Game state management using State pattern
- **UI**: User interface components

## 🎮 Game Features

- Turn-based combat system
- Character class system for Runa
- Various monster types with unique abilities
- Focus point resource management
- Physical and magical damage types
- Defensive abilities (Parry, Reflect, Block, Deflect)

## 🚀 How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line terminal

### Compilation
1. Navigate to the project root directory
2. Create a bin directory for compiled classes:
   ```
   mkdir -p bin
   ```
3. Compile all Java files:
   ```
   javac -d bin -cp src src/game/GameRunner.java
   ```
   This compiles the main class and all its dependencies.

### Execution
Run the game using:
```
java -cp bin game.GameRunner
```

## 🎲 Gameplay

The game progresses through different states:
1. Level initialization
2. Runa's turn (player chooses abilities)
3. Monster's turn (AI-controlled)
4. Post-fight resolution
5. Proceed to next level or game over

## 🕹️ Controls

The game is controlled through the command line. Follow the prompts to select abilities and make decisions during combat. The game will display the current state of Runa and the monster, including health points, focus points, and available abilities.

### Basic Commands:
- Enter numbers to select options
- Multiple selections can be made using comma-separated values (e.g., "1,3,4")
- Enter "quit" to exit the game at any prompt
- Empty input (just pressing Enter) is sometimes allowed for "no action"