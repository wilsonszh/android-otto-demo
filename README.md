# Android Otto Demo App

Notes: 
1. To "Listen/subscribe" to an event, the class must register to bus. 
2. To stop listening to an event, the class must unregister from the bus. 
3. Register and unregister must be done in every class that want to "listen/subscribe" to events. 
4. Post event can be done in any class without registering to the bus. 
5. OttoBus should be singleton. (created once only)
