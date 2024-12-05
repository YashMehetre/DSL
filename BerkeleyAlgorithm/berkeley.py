# Simulating nodes with different clock times
nodes = {
    "Node1": 10.5,  # Time in hours
    "Node2": 10.8,
    "Node3": 11.0,
    "Coordinator": 10.7
}

def berkeley_algorithm(nodes):
    print("Initial times:", nodes)
    
    # Step 1: Extract the coordinator's time
    coordinator_time = nodes["Coordinator"]
    del nodes["Coordinator"]  # Remove coordinator from the list temporarily
    
    # Step 2: Coordinator calculates the time difference for each node
    time_differences = {}
    for node, time in nodes.items():
        time_differences[node] = time - coordinator_time  # Calculate difference
    
    print("Time differences from coordinator:", time_differences)
    
    # Step 3: Calculate the average time (including coordinator)
    total_time = coordinator_time  # Start with coordinator's time
    for time in nodes.values():
        total_time += time  # Add each node's time
    
    num_nodes = len(nodes) + 1  # Include the coordinator
    average_time = total_time / num_nodes
    
    print(f"Average time: {average_time:.2f}")
    
    # Step 4: Adjust all clocks to the average time
    adjusted_times = {}
    for node in nodes:
        adjusted_times[node] = average_time  # Set each node to average time
    adjusted_times["Coordinator"] = average_time  # Adjust coordinator's time as well
    
    print("Adjusted times:", adjusted_times)
    return adjusted_times

# Run the algorithm
adjusted_times = berkeley_algorithm(nodes)
