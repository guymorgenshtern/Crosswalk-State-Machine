Premise:
A Pelican crossing simulator involving hierarchical state machines. The system should provide an efficient system for both cars and pedestrians. Green lights for cars stay on for a minimum of 10 seconds and after that will switch to pedestrian crossing. If a pedestrian requests to cross within those 10sec, the state will switch immediately once count down is over, otherwise the light will stay green until the request button is pressed.

Setup:
- Enter Eclipse
- File —> Open Projects from File System 
- Locate and open the downloaded submission titled “101151430_Assignment4”
- There is a provided test harness that can be used to test the basic functionality of the state machine. 

Class Files 
States: All state classes are organised within folders pertaining to their superstate (Operational is in based directory, two subfolders for vehicles state and pedestrian state, respectively). All state files are named after the states defined in the diagram provided in the assignment description with the exception of being in capital case and "State" is added to the end of the class name(i.e vehiclesEnabled -> VehiclesEnabledState)
Timer: Is a timer. Takes in a interval and calls context.timeout once timer expires
Test: Test harness
Context: The context in which the state machine is used for 
Logger: A couple static methods to output print statements

Questions:
1. Law abiding citizens who will not start crossing once the pedestrian light begins flashing become annoyed because the pedestrianFlashing state does not account for a pedestrianWaiting request to come in at that time. This is fixed in the design by overriding the "pedestrianTimeout()" method in PedestrianFlashingState to set a "pedestrianWaiting" boolean that is then passed through the remaining states, all the way back to the next time VehiclesGreenState. Once the timeout on VehiclesGreenState is called, the light would immediately go yellow instead of staying green until the pedestrian sends another request.

2. Within pedestrianFlash state there is a "magic number" for pedestrianFlashCtr. The only thing specifying the behaviour of that counter is the action triggered on transition between states after a timeout event. In another system, this could cause issues as there is no clear definition for the expected behaviour and reason for pedestrianFlashCtr. This could be addressed by having another substate within pedestriansEnabled called PedestrianFlashing state which in itself would hold a PedestrianFlashingON and PedestrianFlashingOFF substates. The superstate could then hold the value of the counter itself and the substates could handle decrementing the counter rather than relying on actions in between states.