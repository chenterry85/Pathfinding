# Pathfinding

## Introduction

Welcome to pathfinding! This is a grid pathfinding project that employs uniform cost search, greedy search, and A* search from one starting node to the end node. I built this project out of my own interest to visualize pathfinding algorithm in live action!

<p float="left">
  <a href="https://https://youtu.be/HeObeF7Ac4g">
    <img src="http://i.freegifmaker.me/1/5/9/4/6/4/1594646674114920.gif?1594646688" width="200" />
  </a>
  <a href="https://www.youtube.com/watch?v=d8zUc5UvtF8">
    <img src="http://i.freegifmaker.me/1/5/9/4/6/4/15946474201149226.gif?1594647434" width="200" />
  </a>
  <a href="https://www.youtube.com/watch?v=MzBVTS1Zlek">
    <img src="http://i.freegifmaker.me/1/5/9/4/6/4/15946482201149280.gif?1594648236" width="200" />
  </a>
</p>

## Installation

```bash
# Running the Project
git clone https://github.com/chenterry85/pathfinding.git

# Compile file
javac Window.java

# Run file
java Window.java
```

## Algorithms

**Uniform Cost Search**: a variant of Dijikstra’s algorithm, useful for infinite graphs and those graph which are too large to represent in the memory

**Greedy Search**: also called the heuristic search, might not always find the best solution but is guaranteed to find a good solution in reasonable time. Useful in solving tough problems which 1) could not be solved any other way 2) solutions take an infinite time or very long time to compute.

**A * Search**: arguably the best pathfinding algorithm, it's a combination of Uniform cost search and Greedy search.

## Usage

1) **First Click** to select **STARTING Node**
2) **Second Click** to select **END Node**
3) **Mouse Drag** to create **BARRIER**
4) Select a search Alogirthm
   Key Press:
   - **"a"** - A Star Search\n
   - **"g"** - Greedy Search\n
   - **"u"** - Uniform Cost Search\n
5) Press **"r"** to **RESET**
