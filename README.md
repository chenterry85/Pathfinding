# Pathfinding

## Introduction

Welcome to pathfinding! This is a grid pathfinding project that employs uniform cost search, greedy search, and A* search from one starting node to the end node. I built this project out of my own interest to visualize pathfinding algorithm in live action!

## Algorithms

**Uniform Cost Search**: a variant of Dijikstra’s algorithm, useful for infinite graphs and those graph which are too large to represent in the memory
**Greedy Search**: also called the heuristic search, might not always find the best solution but is guaranteed to find a good solution in reasonable time. Useful in solving tough problems which 1) could not be solved any other way 2) solutions take an infinite time or very long time to compute.
**A* Search**: arguably the best pathfinding algorithm, it's a combination of Uniform cost search and Greedy search.

## Usage

1) Lay out first two white blocks as the starting node and the ending node
2) Layout the red nodes as obstacles
3) Execute Search Algorithm <br />
  press **A** for A* Search <br />
  press **G** for Greedy Search <br />
  press **U** for Uniform Cost search <br />
4) press **R** to reset grid
