import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.swing.Timer;

public class Domain {
	PriorityQueue<Node> pqueue = new PriorityQueue<Node>();
	Timer timer;

	//Uniform Cost Search
	public void UCS(Node start, Node end) {

		System.out.println("Performing Uniform Cost Search Algorithm.");

		start.g = 0;
		start.t = start.g;
		pqueue.add(start);

		timer = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!pqueue.isEmpty()) {
					Node current = pqueue.poll();

					if (current.equals(end)) {
						System.out.println("Path found! Press \"r\" to reset.\n");
						Game.isUserActionEnabled = false;
						backtrack(current);
						timer.stop();
					}

					if (!current.visited) {
						current.visited = true;
						for (int i = 0; i < current.edges.size(); i++) {
							Node edge = current.edges.get(i);
							if (!edge.visited && !edge.isObstacle) {
								double newCost;
								if (current.isDiagonal(edge))
									newCost = current.g + 1.4;
								else
									newCost = current.g + 1;
								if (newCost < edge.g) {
									edge.g = newCost;
									edge.t = edge.g;
									edge.parent = current;
									pqueue.add(edge);
									edge.openList = true;
								}
							}
						}
						Game.getInstance().repaint();
					}

				}
			}
		});
		timer.start();
	}


	//Greedy Search
	public void Greedy(Node start, Node end) {

    System.out.println("Performing Greedy Search Algorithm.");

		start.h = start.getDistance(end);
		start.t = start.h;
		pqueue.add(start);

		timer = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!pqueue.isEmpty()) {
					Node current = pqueue.poll();

					if (current.equals(end)) {
						System.out.println("Path found! Press \"r\" to reset.\n");
						Game.isUserActionEnabled = false;
						backtrack(current);
						timer.stop();
					}

					if (!current.visited) {
						current.visited = true;
						for (int i = 0; i < current.edges.size(); i++) {
							Node edge = current.edges.get(i);
							if (!edge.visited && !edge.isObstacle) {
								edge.h = edge.getDistance(end);
								edge.t = edge.h;
								edge.parent = current;
								pqueue.add(edge);
								edge.openList = true;
							}
						}
						Game.getInstance().repaint();
					}
				}
			}
		});
		timer.start();
	}


	//A* Search
	public void AStar(Node start, Node end) {

    System.out.println("Performing A Star Search Algorithm.");

		start.g = 0;
		start.h = start.getDistance(end);
		start.t = start.g +start.h;
		pqueue.add(start);

		timer = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!pqueue.isEmpty()) {
					Node current = pqueue.poll();

					if (current.equals(end)) {
						System.out.println("Path found! Press \"r\" to reset.\n");
						Game.isUserActionEnabled = false;
						backtrack(current);
						timer.stop();
					}

					if (!current.visited) {
						current.visited = true;
						for (int i = 0; i < current.edges.size(); i++) {
							Node edge = current.edges.get(i);
							if (!edge.visited && !edge.isObstacle) {
								double newCost;
								if (current.isDiagonal(edge))
									newCost = current.g + 1.4;
								else
									newCost = current.g + 1;
								edge.h = edge.getDistance(end);
								double newTotal = newCost + edge.h;
								if (newTotal < edge.t) {
									edge.g = newCost;
									edge.t = edge.g + edge.h;
									edge.parent = current;
									pqueue.add(edge);
									edge.openList = true;
								}
							}
						}
						Game.getInstance().repaint();
					}
				}
			}
		});
		timer.start();
	}

	private void backtrack(Node end) {
		Node current = end.parent;
		while (!current.isStart) {
			current.inPath = true;
			current = current.parent;
		}
	}
}
