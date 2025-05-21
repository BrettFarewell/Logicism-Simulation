# Logic Circuit Simulation - Personal Project

## Application Use & Purpose - Project Discription

Logic Circuit Simulator is an interactive application that allows users to design, build, and test custom digital circuits in a visual, real-time environment. Users can place logic gates (AND, OR, NOT, NOR, etc.), outputs (such as light bulbs or speakers), and power sources, then connect them using drawable wires to create functioning logic systems.

The application provides a flexible workspace where users can create and simulate circuits from scratch, making it ideal for exploring the fundamentals of digital logic and circuit design. It serves as both a powerful prototyping tool and an accessible platform for understanding the basic principles behind modern computing systems.

This project was developed to deepen my understanding of digital systems and low-level architecture, particularly as it relates to security and hardware. Inspired by my involvement in CTF competitions, this simulator is a step toward exploring how logical components interact and where vulnerabilities can arise within computer hardware.


## User Stories

**User Interaction with Circuit Builder**:
- As a user, I want to create and manage multiple circuit scenarios, each starting from a blank state.
- As a user, I want to populate a scenario by adding and drawing logic gates, outputs, power sources, and wires to design a custom circuit.
- As a user, I want to view and open any scenario from a centralized list of saved scenarios.
- As a user, I want to see a complete list of all components (logic gates and outputs) added to a specific scenario.
- As a user, I want to draw wires to interconnect components and simulate the circuit in real-time to verify functionality.
- As a user, I want to select gates (OR, NOR, AND, NAND, NOT, XOR, XNOR) from a menu and view a brief description of each gate’s behavior.
- As a user, I want to include visual (light) and audio (tone/frequency) outputs in my circuit, with options to customize their color and sound frequency.

**Persistence (Save/Load) Functionality**:
- As a user, I want to save the current application state and all scenarios from the GUI home tab.
- As a user, I want to load a previously saved application state, including scenarios, from the GUI home tab.


# Instructions for End User

**Creating and Editing Logic Circuits**
To begin designing a logic circuit:

  1. Navigate to the Scenes tab at the top of the interface.
  2. Select an existing scenario from the list, or create a new one using the “New Scene” button on the left panel.
  3. Choose a logic element (e.g., ANDGate, ORGate, Power) from the component menu. Once selected, the current element selection will update.
  4. Click anywhere on the scenario grid to place the selected logic element.
  5. To remove an element, click the Delete button, then select the element you want to remove from the grid.

**Viewing Circuit Components**
To inspect all components within a scenario:

- Click the "Generate List of Logic Elements" button at the bottom of any Scenario tab.
- A new window will appear showing all placed logic elements (excluding wires), grouped by type.
- Each element entry includes its position on the grid for quick reference.

**Running and Resetting Circuits**
- To simulate a scenario, click the Run button in the Scenario tab.
- Clicking Run again will reset the scenario to its original (pre-run) state.
- During simulation, the circuit will activate visually within the grid area, reflecting logical outputs in real time.

**Saving and Loading Application State**
- To save your current session, including all created scenarios, click the Save button on the Home tab.
- To load a previously saved session, click the Load button on the Home tab.

# Planned Improvements to Architecture and Design

- UI Refactoring: The StartingScreenGUI contains several redundant associations that can be removed to streamline the interface. Within the buttons package, functionality is overly fragmented—only ElementButton is essential, while constructs like the ButtonName enum introduce unnecessary complexity. Furthermore, responsibility for UI rendering is inconsistently distributed across tab classes. While HomeTab handles its content adequately, ScenarioTab violates the Single Responsibility Principle by constructing and managing all of its UI panels internally. Refactoring ScenarioTab into more modular components would improve maintainability and separation of concerns.

- Model Redesign: The current implementation of the LogicElement class borrows elements from both the Composite and Observer design patterns but lacks a cohesive integration of either. Revisiting the architectural relationship between the Scenario class, LogicElement, and its subclasses could improve clarity and extensibility. A cleaner abstraction—possibly through a hybrid design pattern combining Composite for structural hierarchy and Observer for state propagation—would reduce ambiguity. For instance, the abstract LogicGate class is currently underutilized, lacking shared behavior or structure to justify its existence. A more principled use of inheritance and interfaces could streamline the logic layer and better support future expansion.


