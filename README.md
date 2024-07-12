## Description

This program is a simulation of the Hawk-Dove game, a model used in evolutionary biology to understand the behavior of animals competing for resources. Written in Java, the simulation represents two types of strategies: Hawks, which are aggressive and fight for resources, and Doves, which are more peaceful and share resources. Java was chosen for its object-oriented features, strong typing, and portability across platforms, making it ideal for developing a simulation that models complex interactions.

## Running Instructions

To run the program, follow these steps:

1.⁠ ⁠Ensure you have Java installed on your system (version 8 or higher).
2.⁠ ⁠Compile the program using:
  
   > javac Game.java
 
3.⁠ ⁠Run the program with the following command:
   > java Game <population_size> [percentage_hawks] [resource_amount] [cost_hawk_hawk]

   - ⁠ <population_size> ⁠: Total number of individuals (Hawks + Doves).
   - ⁠ [percentage_hawks] ⁠: Percentage of the population that are Hawks (default is 20%).
   - ⁠ [resource_amount] ⁠: Amount of resources available (default is 50).
   - ⁠ [cost_hawk_hawk] ⁠: Cost associated with Hawk-Hawk interactions (default is 100).

   Example:
   > java Game 100 30 50 100

## Observations

The simulation effectively demonstrates the dynamics of competition and cooperation in a population. By adjusting the parameters, such as the proportion of Hawks or the cost of interactions, users can observe how these changes affect the population's behavior over time. The program's interactive menu allows for real-time analysis of population statistics and individual interactions.

## Changes in Parameters

Adjusting parameters such as population size, percentage of Hawks, resource amount, and interaction costs can lead to varied outcomes. For instance, increasing the number of Hawks generally leads to higher mortality rates due to costly fights. Conversely, a higher resource amount allows for greater survival rates among Doves. This flexibility enables users to explore different scenarios and understand the impact of these variables on population dynamics.

## Learning Outcomes

Through this simulation, I gained insights into Evolutionary Stable Strategies (ESS) in game theory. I learned that strategies can evolve based on the payoff structure of interactions, where Hawks may dominate under certain conditions, but Doves can thrive when resources are abundant or costs are high. Additionally, I explored how AI can model real-world biological phenomena, allowing for deeper understanding of competition and cooperation in ecosystems.

## Conclusion

This simulation serves as an educational tool to illustrate fundamental concepts in game theory and evolutionary biology. By engaging with the program, users can visualize the complex interplay between different strategies and their effects on population dynamics.